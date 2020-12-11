package com.example.models;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;

public class GalleryDAO {
    Gallery gallery = null;
    ArrayList<Gallery> imageList = new ArrayList<>();

    public ArrayList getAll() throws SQLException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/image", "root", "12345");
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM gallery ORDER BY date DESC ");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                gallery = new Gallery();
                String title = rs.getString("title");
                String text = rs.getString("text");
                Blob blob = rs.getBlob("image");
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                inputStream.close();
                outputStream.close();
                gallery.setTitle(title);
                gallery.setText(text);
                gallery.setBase64Image(base64Image);
                imageList.add(gallery);


            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw e;
        }
        return imageList;
    }
}
