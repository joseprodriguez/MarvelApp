package edu.galileo.android.marvelapp.utilities;

import java.io.Serializable;

/**
 * Created by José P. Rodríguez on 27/01/2016.
 */
public class SuperInfo implements Serializable{
    private String name;
    private String img;
    private String description;

    public SuperInfo(String n, String i, String des) {
        this.name = new String(n);
        this.img = new String(i);
        this.description = new String(des);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
