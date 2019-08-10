package com.example.intercept;

import com.example.app.dao.OperationDao;
import com.example.app.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class OperationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private OperationDao operationDao;
    /**
     * 在业务处理器处理请求之前被调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // TODO Auto-generated method stub
        //判断用户身份在Session中是否存在
        HttpSession session = request.getSession();
        Users activeUser = (Users) session.getAttribute("activeUser");
        //如果用户身份在session中存在则放行
        if (activeUser==null) {
            return false;
        }
        return roleControl(request, response, handler);
    }

    /**角色权限控制访问
     * @throws IOException */
    private boolean roleControl(HttpServletRequest request,HttpServletResponse response, Object handler) throws IOException {

        if(handler instanceof HandlerMethod){
            HandlerMethod hMethod=(HandlerMethod)handler;
            Class<?> clazz=hMethod.getBeanType();
            Method method=hMethod.getMethod();
            boolean isClzAnnotation= clazz.isAnnotationPresent(OperationAction.class);
            boolean isMethondAnnotation=method.isAnnotationPresent(OperationAction.class);
            OperationAction rc=null;
            //如果方法和类声明中同时存在这个注解，那么方法中的会覆盖类中的设定。
            if(isMethondAnnotation){
                rc=method.getAnnotation(OperationAction.class);
                String orleName=rc.name();
                String operate = rc.value();
                //获取用户角色的操作权限
                List<String> obj= operationDao.findArray(orleName);
                boolean isEquals = obj.contains(operate);
                if(!isEquals){
                    //401未授权访问
                    String url = response.encodeRedirectURL(request.getContextPath()
                            + "/401.jsp");
                    response.sendRedirect(url);
                    return false;
                }
            }else if(isClzAnnotation){
                rc=clazz.getAnnotation(OperationAction.class);
            }
        }
        return true;
    }



}
