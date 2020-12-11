package com.example.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;

@WebServlet("/upload.do")
@MultipartConfig(maxFileSize = 15*1024*1024)
public class UploadController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart=req.getPart("file");
        String title=req.getParameter("title");
        String text=req.getParameter("text");
        InputStream input=null;
        PreparedStatement pstm=null;
        if(filePart!=null){
            input=filePart.getInputStream();
        }


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/image","root","12345");
           pstm=connection.prepareStatement("insert into gallery (image,title,text,date)"+"values(?,?,?,?)");
           pstm.setString(2,title);

           pstm.setString(3,text);
           pstm.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
           if(input!=null) {
               pstm.setBlob(1,input);
           }
           int row=pstm.executeUpdate();
           if(row>0)
            req.getRequestDispatcher("/WEB-INF/gallery/upload.jsp").forward(req,resp);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
