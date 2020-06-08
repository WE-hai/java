package com.bit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/add-message")
public class AddMessage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String message = req.getParameter("message");
        if (message == null) {
            resp.sendRedirect("/");
            return;
        }

        try (Connection con = DBUtil.getConnection()) {
            String sql = "INSERT INTO tbl_messages (message) VALUES (?)";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, message);
                stmt.executeUpdate();

                resp.sendRedirect("/messages");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
