package com.example.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/save.do")
public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role=req.getParameter("role");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/list","root","12345");
            PreparedStatement pstm=connection.prepareStatement("INSERT INTO user (username,password,role)"+"values(?,?,?)");
            pstm.setString(1,username);
            pstm.setString(2,password);
            pstm.setString(3,role);
            pstm.executeUpdate();

            req.getRequestDispatcher("/WEB-INF/login/save.jsp").forward(req,resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
