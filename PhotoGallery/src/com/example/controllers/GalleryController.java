package com.example.controllers;
import com.example.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/gallery.do")
public class GalleryController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GalleryDAO dao=new GalleryDAO();
        ArrayList<Gallery> images=new ArrayList<>();

        try {
            images=dao.getAll();
            req.setAttribute("images",images);
            req.getRequestDispatcher("/WEB-INF/gallery/view.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
