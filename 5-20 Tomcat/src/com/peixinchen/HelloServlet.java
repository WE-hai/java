package com.peixinchen;

import standard.HttpServlet;
import standard.HttpServletRequest;
import standard.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    // 一定晚于 new
    // 一定早于 process 之前
    public void init() {
        System.out.println("Hello");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("你好世界");
    }
}
