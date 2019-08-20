package lt.bit.photoGallery;

import java.io.*;
import java.util.LinkedList;

public class Image implements Serializable {
    private static LinkedList<Image> images = null;
    private String url;
    private String description;

    public Image(String url, String description) {
        this.url = url;
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static LinkedList<Image> getImages() {
        if (images == null) {
            try {
                images = new LinkedList<>();
                FileInputStream fi = new FileInputStream(new File("C:/Users/User/Documents/JavaHomeWork/Gallery/data/images.txt"));
                ObjectInputStream ois = new ObjectInputStream(fi);
                images = (LinkedList<Image>) ois.readObject();
                ois.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return images;
    }

    public static void addImage(String url, String description) {
        try {
            images.add(new Image(url, description));

            FileOutputStream fo = new FileOutputStream(new File("C:/Users/User/Documents/JavaHomeWork/Gallery/data/images.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(images);
            oos.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}