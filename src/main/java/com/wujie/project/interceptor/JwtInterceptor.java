package com.wujie.project.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wujie.project.utils.JwtUtil;
import com.wujie.project.utils.ResultInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            try {
                String subject = JwtUtil.parseToken(token.substring(7)).getSubject();
                request.setAttribute("uid", Integer.valueOf(subject));
                return true;
            } catch (Exception e) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                sendErrorResponse(response, "无效的token");
                return false;
            }
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            sendErrorResponse(response, "未提供token");
            return false;
        }
    }

    private void sendErrorResponse(HttpServletResponse response, String message) throws IOException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(400);
        resultInfo.setMsg(message);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(resultInfo);
        response.getWriter().write(json);
    }
}