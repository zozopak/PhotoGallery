package com.example.controllers;

import com.example.models.Checker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user.do")
public class UserLoginController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role=req.getParameter("role");
        if(Checker.checkEntry(username,password,role))
            req.getRequestDispatcher("/WEB-INF/login/welcome.jsp").forward(req,resp);
        else
            req.getRequestDispatcher("/WEB-INF/login/error.jsp").forward(req, resp);
    }
}
