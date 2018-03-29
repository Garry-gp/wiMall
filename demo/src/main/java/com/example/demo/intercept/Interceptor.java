package com.example.demo.intercept;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
        	InterceptMethod loginRequired = findAnnotation((HandlerMethod) handler, InterceptMethod.class);
            //没有声明需要权限,或者声明不验证权限
            if(loginRequired==null){
                return true;
            }else{
                String token=request.getHeader("token");
                if(StringUtils.isEmpty(token)){
                    token=request.getParameter("token");
                }
                //在这里实现自己的权限验证逻辑
                if(!StringUtils.isEmpty(token)){//如果验证成功返回true（这里直接写false来模拟验证失败的处理）
                    return true;
                }else{//如果验证失败
                    response.getWriter().write("您还未登录");
                    return false;
                }       
            }
        }else{
            return true;
        }
    }

    private <T extends Annotation> T findAnnotation(HandlerMethod handler, Class<T> annotationType) {
        T annotation = handler.getBeanType().getAnnotation(annotationType);
        if (annotation != null) return annotation;
        return handler.getMethodAnnotation(annotationType);
    }
}