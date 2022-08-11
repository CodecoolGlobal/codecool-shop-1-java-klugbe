package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Checkout", urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateEngine templateEngine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext webContext = new WebContext(request,response, getServletContext());
        String sessionId = request.getRequestedSessionId();
        double cartValue = fetchCartValue(sessionId);
        webContext.setVariable("value", cartValue);
        templateEngine.process("checkout.html", webContext, response.getWriter());
    }

    private double fetchCartValue(String sessionId) {
    return 0;
    }




/*
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<String> detailsOfOrder = new ArrayList<>();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String zipCode = request.getParameter("cityCode");
        String street = request.getParameter("street");
        String houseNumber = request.getParameter("house-number");


        String billingCountry = request.getParameter("billing-country");
        String billingZipCode = request.getParameter("billing-cityCode");
        String billingStreet = request.getParameter("billing-street");
        String billingHouseNumber = request.getParameter("billing-house-number");
        String paymentType = request.getParameter("payment-type");


        detailsOfOrder.add(name);
        detailsOfOrder.add(email);
        detailsOfOrder.add(country);
        detailsOfOrder.add(zipCode);
        detailsOfOrder.add(street);
        detailsOfOrder.add(houseNumber);
        detailsOfOrder.add(billingCountry);
        detailsOfOrder.add(billingZipCode);
        detailsOfOrder.add(billingStreet);
        detailsOfOrder.add(billingHouseNumber);
        detailsOfOrder.add(paymentType);

 */
}
