package com.codecool.shop.service;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Cart;

public class CartService {
    private final CartDao cartDAO;

    public CartService(CartDao cartDAO) {
        this.cartDAO = cartDAO;
    }

    public Cart getCart(String sessionId) {
        return cartDAO.getCart(sessionId);
    }
}
