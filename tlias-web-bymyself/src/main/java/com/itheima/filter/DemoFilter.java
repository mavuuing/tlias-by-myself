package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override //初始化方法只执行一次
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("初始化方法执行了");
    }

    @Override ///可执行多次
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截到了请求");
//放行
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("拦截之后");
    }

    @Override //只执行一次
    public void destroy() {
        Filter.super.destroy();
    }
}
