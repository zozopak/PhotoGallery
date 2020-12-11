package com.example.models;

/**
 * author:zohreh pakdaman
 * date:feb/2020
 */

public class Gallery {
    private String title;
    private String text;
    private String base64Image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}
