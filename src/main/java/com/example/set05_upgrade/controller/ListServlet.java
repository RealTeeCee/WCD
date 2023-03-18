package com.example.set05_upgrade.controller;


import com.example.set05_upgrade.services.ProductJPAService;
import com.example.set05_upgrade.services.ProductJPAServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/list","/"})
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductJPAService productService = new ProductJPAServiceImpl();
        req.setAttribute("productList", productService.getAllProduct());
        req.getServletContext().getRequestDispatcher("/WEB-INF/list.jsp").forward(req,resp);
    }

}
