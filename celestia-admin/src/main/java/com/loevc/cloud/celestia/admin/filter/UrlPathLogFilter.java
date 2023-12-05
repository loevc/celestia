package com.loevc.cloud.celestia.admin.filter;

import cn.hutool.json.JSONUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/11/29 16:35
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
public class UrlPathLogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        log.info("UrlPathLogFilter ---> url: {}, remote_addr: {}, params: {}"
                , httpServletRequest.getRequestURL(), httpServletRequest.getRemoteAddr(), JSONUtil.toJsonStr(httpServletRequest.getParameterMap()));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
