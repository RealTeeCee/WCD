package com.example.set05_upgrade.controller;

import com.example.set05_upgrade.services.ProductJPAService;
import com.example.set05_upgrade.services.ProductJPAServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    ProductJPAService productService = new ProductJPAServiceImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchStr = request.getParameter("searchStr");
        var cookie = new Cookie("lastSearchStr", searchStr);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        request.setAttribute("productList", productService.searchProduct(searchStr));

        request.getServletContext().getRequestDispatcher("/WEB-INF/list.jsp").forward(request,response);
    }
}
