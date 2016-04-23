package edu.galileo.android.marvelapp.utilities.connection;

import java.io.Serializable;

/**
 * Created by José P. Rodríguez on 21/04/2016.
 */
public class ImagenChar implements Serializable {
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    private String path;
    private String extension;
}
