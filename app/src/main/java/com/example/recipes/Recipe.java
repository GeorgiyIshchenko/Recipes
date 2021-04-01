package com.example.recipes;

public class Recipe {

    String name;
    String description;
    String photoURL;
    String videoURL;

    public Recipe(String name, String description, String photoURL, String videoURL) {
        this.name = name;
        this.description = description;
        this.photoURL = photoURL;
        this.videoURL = videoURL;
    }

    public Recipe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }
}
