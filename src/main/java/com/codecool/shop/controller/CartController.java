package com.codecool.shop.controller;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.model.Cart;
import com.codecool.shop.service.CartService;
import com.codecool.shop.config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cart/show"}, loadOnStartup = 1)
public class CartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartDao cartDao = CartDaoMem.getInstance();
        CartService cartService = new CartService(cartDao);
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        String sessionId = req.getRequestedSessionId();
        context.setVariable("cart", cartService.getCart(sessionId));
        engine.process("cart/cart.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CartDao  cartDao = CartDaoMem.getInstance();
        String newCountString = req.getParameter("count");
        String productIdString = req.getParameter("productId");
        int newCount = Integer.parseInt(newCountString);
        int productId = Integer.parseInt(productIdString);

        String sessionId = req.getRequestedSessionId();
        Cart cart = cartDao.getCart(sessionId);

        cart.setCount(productId, newCount);
        resp.sendRedirect("/cart/show");
    }

}
