package com.example.set05_upgrade.controller;


import com.example.set05_upgrade.services.ProductJPAService;
import com.example.set05_upgrade.services.ProductJPAServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    ProductJPAService productService = new ProductJPAServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String[] ids = req.getParameterValues("ids");
            for (String id: ids) {
                productService.deleteProduct(id);
            }

            resp.sendRedirect(req.getContextPath() + "/list");
        }catch (Exception ex) {
            req.setAttribute("error", ex.getMessage());
            req.getServletContext().getRequestDispatcher("/WEB-INF/failed.jsp").forward(req, resp);
            ex.printStackTrace();
        }


    }

}
