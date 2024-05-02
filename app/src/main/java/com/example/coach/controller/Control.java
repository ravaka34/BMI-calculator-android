package com.example.coach.controller;

import com.example.coach.model.Profil;

//it s the activity that is launched and created first in an android app and not the controller like
// usual web app so we need to figure out how to share one controller among all the views
// One solution is using a singleton
public final class Control {

    private static Control instance = null;
    private Profil profil;

    private Control(){
        super();
    }

    /**
     * Instance creation
     * @return instance
     */
    public static Control getInstance(){
        if(instance == null){
            instance = new Control();
        }
        return instance;
    }

    /**
     * Profil creation
     * @param height cm
     * @param weight
     * @param sex 1 = man and 0 = woman
     * @param year
     */
    public void createProfil(int height, int weight, int sex, int year){
        this.profil = new Profil(height, weight, sex, year);
    }

    /**
     * Get the img of the current profil
     * @return img
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     *Get the message of the current profil
     * @return message
     */
    public String getMessage(){
        return profil.getMessage();
    }

    /**
     * get the id of the resource picture
     * @return
     */
    public int getImgPicture(){
        return profil.getImgPictureId();
    }

}
