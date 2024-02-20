package com.example.materialme_antoniroig;

class Sport {

    private String title;
    private String info;

    private final int imageResource;
    Sport(String title, String info, int backimage) {
        this.title = title;
        this.info = info;
        this.imageResource = backimage;
    }

    String getTitle() {
        return title;
    }

    String getInfo() {
        return info;
    }

    int getimageResource() {
        return imageResource;
    }
}
