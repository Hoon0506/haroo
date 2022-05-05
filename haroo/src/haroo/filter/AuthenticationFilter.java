package haroo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//구현 중
//@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        HttpSession httpSession = httpServletRequest.getSession();

        String path = ((HttpServletRequest)servletRequest).getRequestURI();
        if (!path.contains("/login")) {
            Integer em_no = (Integer) httpSession.getAttribute("em_no");
            if (em_no == null) httpServletResponse.sendRedirect("/login");
            return;
        } else {
            httpServletResponse.sendRedirect("/login");
        }

        System.out.println("필터 실행");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}