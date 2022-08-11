package com.codecool.shop.dao;

import com.codecool.shop.model.Cart;
import com.codecool.shop.model.CartItem;

public interface CartDao {

    void add(CartItem cartItem, String sessionId);

    CartItem find(int id, String sessionId);

    void remove(int id, String sessionId);

    Cart getCart(String sessionId);
}