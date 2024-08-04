package com.whms.token;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        if(token!=null){
            boolean result = TokenUtil.verify(token);
            if(result){
                return true;
            }
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        try{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("msg", "token verify failed");
            jsonObject.put("status", 401);
            response.getWriter().append(jsonObject.toJSONString());
        }catch (Exception e){
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
        return false;
    }
}
