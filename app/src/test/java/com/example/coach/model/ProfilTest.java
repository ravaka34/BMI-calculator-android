package com.example.coach.model;

import junit.framework.TestCase;

public class ProfilTest extends TestCase {

    Profil profil = new Profil(165, 67, 0, 35);
    //result img
    private float img = (float) 32.2;
    //message
    private String message = "Trop de graisse";

    public void testGetImg() {
        assertEquals(img, profil.getImg(), (float) 0.1);
    }

    public void testGetMessage() {
        assertEquals(message, profil.getMessage());
    }
}