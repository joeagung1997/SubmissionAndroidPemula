package com.example.submissionandroidpemula.model;

public class Food {


    private int photo;
    private String tempat;


    private String desc;
    private String jarak;


    public Food(int photo, String tempat, String desc, String jarak) {
        this.photo = photo;
        this.tempat = tempat;
        this.desc = desc;
        this.jarak = jarak;
    }


    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public String getJarak() {
        return jarak;
    }

    public void setJarak(String jarak) {
        this.jarak = jarak;
    }


}
