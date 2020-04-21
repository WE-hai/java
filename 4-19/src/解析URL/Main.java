package 解析URL;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String, Integer> standardPort = new HashMap<>();
    static {
        standardPort.put("ssh", 22);
        standardPort.put("http", 80);
        standardPort.put("https", 443);
        standardPort.put("jdbc:mysql", 3306);
    }
    private static void parseUrl(String url) {
        System.out.println(url);
        System.out.println();

        // 1. 从 url 中找出 协议部分 —— ://
        int i = url.indexOf("://");
        String schema = url.substring(0, i);
        System.out.println(schema);

        String rest = url.substring(i + 3); // 3 就是 :// 的长度

        // 2. 从 url 中找出整个的主机部分（域名 + port） —— /
        i = rest.indexOf("/");
        String host = rest.substring(0, i);
        rest = rest.substring(i);   // 保留 / 部分

        // 3. 把 host 部分的 域名 和 端口分离 —— :
        String[] fragments = host.split(":");
        String domainOrIP;
        int port;
        if (fragments.length == 1) {
            // 主机部分没有携带端口
            domainOrIP = host;
            // TODO: 没有考虑不认识的协议的情况
            port = standardPort.get(schema);
        } else {
            // 主机部分有端口
            domainOrIP = fragments[0];
            port = Integer.parseInt(fragments[1]);
        }
        System.out.println(domainOrIP);
        System.out.println(port);

        // 4. 分离出 path 和 queryString 部分 —— ?
        String path;
        String queryString;
    /*
    fragments = rest.split("\\?");  // 记得对 ? 进行转义，传入的正则表达式，而 ? 正则表达式中有特殊含义，所以需要转义
    if (fragments.length == 1) {
        path = rest;
        queryString = "";
    } else {
        path = fragments[0];
        queryString = fragments[1];
    }
    //*/

        //*
        i = rest.indexOf("?");
        if (i == -1) {
            path = rest;
            queryString = "";
        } else {
            path = rest.substring(0, i);
            queryString = rest.substring(i + 1);
        }
        //*/

        System.out.println(path);
        System.out.println(queryString);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        parseUrl(url);
        System.out.println();
    }
}
