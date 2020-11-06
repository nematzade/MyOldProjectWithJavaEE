package com.controller.auth;


import org.apache.catalina.realm.GenericPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mohammad on 23/12/2017.
 */

@Controller
@RequestMapping(value = "auth")
public class AuthController {

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        try {
//            req.login(username,password);
//            GenericPrincipal genericPrincipal = (GenericPrincipal) req.getUserPrincipal();
//            resp.sendRedirect("/view/"+genericPrincipal.getRoles()[0]+"/defineUniversity.jsp");
//        }catch (Exception e){
//            e.printStackTrace();
//            resp.sendRedirect("error.jsp");
//        }
//
//
//    }


    @RequestMapping(value = "/login")
    public void login(HttpServletResponse response,HttpServletRequest request) throws IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        try {
            request.login(user,pass);
            GenericPrincipal genericPrincipal = (GenericPrincipal) request.getUserPrincipal();
            response.sendRedirect("/view/"+genericPrincipal.getRoles()[0]+"/linkList.jsp");

        } catch (ServletException e) {

            response.sendRedirect("/error.jsp");
//            e.printStackTrace();

        }

    }

    @RequestMapping(value = "/logout")
    public void logout(HttpServletResponse response,HttpServletRequest request) throws IOException, ServletException {

            request.logout();
            response.sendRedirect("/loginn.jsp");

    }

}
