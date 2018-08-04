package com.iem.safety.iembackend.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author MengQi
 * @create 2018-01-04 17:57
 */
public class SessionInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String reqUri = request.getRequestURI();
        logger.info("ip:" + request.getRemoteAddr() + "  uri:" + reqUri);
        HttpSession session = request.getSession();
        if (reqUri.equals("/") || reqUri.contains("/login")) {
            logger.info("登录页面");
            return true;
        }

        String role = (String) session.getAttribute("_role");
        if (role == null) {
            logger.info("未登录");
            response.sendRedirect("/login");
            return false;
        }
        if (role.equals("su")) {
            logger.info("su权限");
            return true;
        }

        if (role.equals("admin")) {
            if (reqUri.contains("/su/")) {
                logger.info("admin权限不通过");
                return false;
            } else {
                logger.info("admin权限通过");
                return true;
            }
        }

        if (role.equals("normal")) {
            if (reqUri.contains("/admin/") || reqUri.contains("/su/")) {
                logger.info("normal权限不通过");
                return false;
            } else {
                logger.info("normal权限通过");
                return true;
            }
        }
        logger.info("其他");
        return false;
    }
}
