package com.bit;

import com.alibaba.fastjson.JSONArray;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/messages")
public class Messages extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONArray array = new JSONArray();

        try (Connection con = DBUtil.getConnection()) {
            String sql = "SELECT message FROM tbl_messages";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        array.add(rs.getString(1));
                    }

                    resp.setContentType("application/json; charset=utf-8");
                    PrintWriter writer = resp.getWriter();
                    writer.println(array.toJSONString());
                }
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
