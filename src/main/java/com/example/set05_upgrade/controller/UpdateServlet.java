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

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    ProductJPAService productService = new ProductJPAServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("product", productService.getProductById(id));
        request.getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        product.setId(request.getParameter("id"));
        product.setProductName(request.getParameter("name"));
        product.setPrice(Double.parseDouble(request.getParameter("price")));
        product.setQuantity(Integer.parseInt(request.getParameter("quantity")));

        BeanValidation<Product> productBeanValidation = new BeanValidation<>();
        String error = productBeanValidation.validProduct(product);

        if(!error.isEmpty()) {
            request.setAttribute("error", error);
            request.setAttribute("product",product);
            request.getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").include(request,response);
        }else{
            if(productService.updateProduct(product)){
                response.sendRedirect(request.getContextPath() + "/list");
            } else{
                request.setAttribute("error", "Delete Error!");
                request.getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").include(request,response);
            }
        }

    }
}
