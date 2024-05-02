package com.example.coach.model;

import android.graphics.drawable.Drawable;

import com.example.coach.R;

public class Profil {

    // constants
    private static final int minWoman = 15;// skinny below
    private static final int maxWoman = 30;// fat above
    private static final int minMan = 10;// skinny below
    private static final int maxMan = 25;// fat above

    //properties
    // cm
    private int height;
    private int weight;
    // 0 = woman and 1 = man
    private int sex;
    private int year;
    private float img;
    private String message;
    private int imgPictureId;

    public Profil() {
    }

    public Profil(int height, int weight, int sex, int year) {
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.year = year;
        calculImg();
        resultImg();
    }

    private void calculImg(){
        float meterHeight = (float) height / 100;
        this.img = (float) ((1.2* weight/(meterHeight*meterHeight)) + (0.23 * year) - (10.83 * this.sex) - 5.4);
    }

    private void resultImg(){
        //init with woman values
        int min =  minWoman ;
        int max =  maxWoman;

        //if man
        if(sex == 1){
            min = minMan;
            max = maxMan;
        }
        // appropiate message
        message = "Taux de graisse normal";
        imgPictureId = R.drawable.normal;
        if(img < min){
            message = "Trop maigre";
            imgPictureId = R.drawable.skinny;
        }
        if(img > max){
            message = "Trop de graisse";
            imgPictureId = R.drawable.fat;
        }
    }

    public float getImg() {
        return img;
    }

    public void setImg(float img) {
        this.img = img;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getImgPictureId() {
        return imgPictureId;
    }

    public void setImgPictureId(int imgPicture) {
        this.imgPictureId = imgPicture;
    }
}
