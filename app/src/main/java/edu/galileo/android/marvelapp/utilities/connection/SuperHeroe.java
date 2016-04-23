package edu.galileo.android.marvelapp.utilities.connection;

import java.io.Serializable;

/**
 * Created by José P. Rodríguez on 21/04/2016.
 */
public class SuperHeroe implements Serializable {

    public SuperHeroe(String n, String d) {
        this.name = n;
        this.description = d;
        this.thumbnail = null;
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

    public ImagenChar getThumbnail() {
        return thumbnail;
    }

    public String getImagePath() {
        return this.thumbnail.getPath() + "." + this.thumbnail.getExtension();
    }

    public void setThumbnail(ImagenChar thumbnail) {
        this.thumbnail = thumbnail;
    }

    private String name;
    private String description;
    private ImagenChar thumbnail;
}
