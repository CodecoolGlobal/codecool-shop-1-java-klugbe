package com.codecool.shop.controller;


import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import ognl.JavaCharStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.google.common.io.CharStreams;

@WebServlet(urlPatterns = {"/api/add-to-cart"})
public class AddToCartAPI extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println(request);
        String requestData = CharStreams.toString(request.getReader());
        requestData = requestData.replace("\"","");
        int productId = Integer.parseInt(requestData);

        CartDao cart = CartDaoMem.getInstance();
        ProductDao productStore =  ProductDaoMem.getInstance();
        Product product = productStore.find(productId);
        cart.add(product, 1);
    }
}