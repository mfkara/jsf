/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Sungur
 */
public class musteriBilgileri {
    private int mus_id;
    private String mus_adi;
    private String mus_soyadi;
    private Date dtarih;
    private String adres;
    private String telefon;
    private userModel user_id;

    public int getMus_id() {
        return mus_id;
    }

    public void setMus_id(int mus_id) {
        this.mus_id = mus_id;
    }

    public String getMus_adi() {
        return mus_adi;
    }

    public void setMus_adi(String mus_adi) {
        this.mus_adi = mus_adi;
    }

    public String getMus_soyadi() {
        return mus_soyadi;
    }

    public void setMus_soyadi(String mus_soyadi) {
        this.mus_soyadi = mus_soyadi;
    }

    public Date getDtarih() {
        return dtarih;
    }

    public void setDtarih(Date dtarih) {
        this.dtarih = dtarih;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public userModel getUser_id() {
        return user_id;
    }

    public void setUser_id(userModel user_id) {
        this.user_id = user_id;
    }
    
}
