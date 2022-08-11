package com.codecool.shop.controller;


import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.CartItem;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@WebServlet(urlPatterns = {"/api/cart"}, loadOnStartup = 2)
public class CartApiController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String data = IOUtils.toString(req.getInputStream(), StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(data);

        CartDao cartDaoDataStorage = CartDaoMem.getInstance();
        int id = jsonObject.getInt("id");
        double price = jsonObject.getDouble("price-value");
        String name = jsonObject.getString("name");
        String sessionId = jsonObject.getString("session");

        CartItem cartItem = new CartItem(id, price, name);
        Cart cart = cartDaoDataStorage.getCart(sessionId);
        cart.add(cartItem);
        resp.sendRedirect("/");
    }
}

