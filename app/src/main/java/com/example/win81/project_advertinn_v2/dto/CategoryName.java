package com.example.win81.project_advertinn_v2.dto;

import java.io.Serializable;

/**
 * Created by Win 8.1 on 05/12/2017.
 */

public class CategoryName implements Serializable {
    private int image;
    private String name;

    public CategoryName(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
