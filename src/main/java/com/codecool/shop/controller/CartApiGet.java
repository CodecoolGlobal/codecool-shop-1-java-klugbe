package com.codecool.shop.controller;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.model.Cart;
import com.google.gson.JsonObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/api/cart/session"}, loadOnStartup = 2)
public class CartApiGet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CartDao cartDao = CartDaoMem.getInstance();
        String sessionId = req.getParameter("id");

        Cart cart = cartDao.getCart(sessionId);
        double totalPrice = cart.getTotalPrice();

        resp.setContentType("Application/json");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("totalPrice", totalPrice);

        PrintWriter writer = resp.getWriter();
        writer.write(jsonObject.toString());
    }

}