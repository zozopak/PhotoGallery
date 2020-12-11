package com.example.models;

import java.sql.*;

public class Checker {
    public static boolean checkEntry(String username,String password,String role){
        boolean st=false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/list","root","12345");
            PreparedStatement pstm=connection.prepareStatement("select * from user where username=? and password=? and role=?");
            pstm.setString(1,username);
            pstm.setString(2,password);
            pstm.setString(3,role);
            ResultSet rs= pstm.executeQuery();
            st=rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       ;
        return st;
    }
}