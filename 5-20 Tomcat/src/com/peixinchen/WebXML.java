package com.peixinchen;

import tomcat.WebDescriptor;

public class WebXML extends WebDescriptor {
    public WebXML() {
        urlToName.put("/hello", "HelloServlet");
        nameToClass.put("HelloServlet", "com.peixinchen.HelloServlet");
    }
}
