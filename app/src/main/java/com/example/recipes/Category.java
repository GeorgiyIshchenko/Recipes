package com.example.recipes;

import java.util.ArrayList;

public class Category {

    String name;
    String photoURL;
    ArrayList<Recipe> recipes;

    public Category(String name, String photoURL, ArrayList<Recipe> recipes) {
        this.name = name;
        this.photoURL = photoURL;
        this.recipes = recipes;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }
}
