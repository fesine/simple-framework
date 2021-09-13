package com.fesine.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 注意/与/*的区别
 * /只拦截请求url，/*拦截所有请求，包括jsp页面
 * @author: fesine
 * @createTime:2021/9/12
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/12
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = -7814415974331863709L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("request path is:" + req.getServletPath());
        System.out.println("request method is:" + req.getMethod());
    }
}
