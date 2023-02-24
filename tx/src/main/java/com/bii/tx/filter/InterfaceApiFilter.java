package com.bii.tx.filter;

import com.bii.tx.common.util.JsonUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author bihaiyang
 * @desc
 * @since 2023/02/13
 */
@Slf4j
@Component
@WebFilter(urlPatterns = "/*", filterName = "interfaceApiFilter")
public class InterfaceApiFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("【InterfaceApiFilter】is init");
    }
    

    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        
        log.info("【servletRequest】-> {}", request.getRequestURI());
        chain.doFilter(servletRequest, servletResponse);
    }
    
    @Override
    public void destroy() {
        log.info("【InterfaceApiFilter】is destroy");
    }
}
