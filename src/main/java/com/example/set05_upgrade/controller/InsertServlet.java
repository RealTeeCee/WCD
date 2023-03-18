package com.example.set05_upgrade.controller;

import com.example.set05_upgrade.models.Product;
import com.example.set05_upgrade.services.ProductJPAService;
import com.example.set05_upgrade.services.ProductJPAServiceImpl;
import com.example.set05_upgrade.validation.BeanValidation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/insert")

public class InsertServlet extends HttpServlet {
    ProductJPAService productService = new ProductJPAServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext()
                .getRequestDispatcher("/WEB-INF/insert.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Product product = new Product();
            product.setId(req.getParameter("id"));
            product.setProductName(req.getParameter("name"));
            product.setPrice(Double.parseDouble(req.getParameter("price")));
            product.setQuantity(Integer.parseInt(req.getParameter("quantity")));

            BeanValidation<Product> productBeanValidation = new BeanValidation<>();
            String error = productBeanValidation.validProduct(product);

            if(!error.isEmpty()) {
                req.setAttribute("error", error);
                req.getServletContext().getRequestDispatcher("/WEB-INF/insert.jsp").include(req,resp);
            }else {
                if (!productService.addProduct(product)) {
                    req.setAttribute("error", error);
                    req.getServletContext().getRequestDispatcher("/WEB-INF/insert.jsp").include(req,resp);
                } else {
                    resp.sendRedirect(req.getContextPath()+ "/list");
                }
            }

        } catch (Exception ex) {
            req.setAttribute("error", ex.getMessage());
            req.getServletContext().getRequestDispatcher("/WEB-INF/failed.jsp").forward(req, resp);
            ex.printStackTrace();
        }

    }
}
