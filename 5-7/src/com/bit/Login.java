package com.bit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain; charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username != null) {
            if (password != null) {
                resp.sendRedirect("/login");
                return;
            }
        }
        resp.sendRedirect("/login");
    }
}
