/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sungur
 */
public class ParcalarModel {
    private String parca_adi;
    private int kategori_id;
    private int araba_id;
    private int uretimyili;
    private double fiyat;
    private String res_yol;
    public ParcalarModel(String parca_adi, int kategori_id, int araba_id, int uretimyili, double fiyat, int uretici_id, int parca_id,String res_yol) {
        this.parca_adi = parca_adi;
        this.kategori_id = kategori_id;
        this.araba_id = araba_id;
        this.uretimyili = uretimyili;
        this.fiyat = fiyat;
        this.uretici_id = uretici_id;
        this.parca_id = parca_id;
        this.res_yol=res_yol;
    }

    public ParcalarModel() {
    }

   

    public String getParca_adi() {
        return parca_adi;
    }

    public void setParca_adi(String parca_adi) {
        this.parca_adi = parca_adi;
    }

    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    public int getAraba_id() {
        return araba_id;
    }

    public void setAraba_id(int araba_id) {
        this.araba_id = araba_id;
    }

    public int getUretimyili() {
        return uretimyili;
    }

    public void setUretimyili(int uretimyili) {
        this.uretimyili = uretimyili;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public int getUretici_id() {
        return uretici_id;
    }

    public void setUretici_id(int uretici_id) {
        this.uretici_id = uretici_id;
    }

    public int getParca_id() {
        return parca_id;
    }

    public void setParca_id(int parca_id) {
        this.parca_id = parca_id;
    }
    private int uretici_id;
    private int parca_id;

    public String getRes_yol() {
        return res_yol;
    }

    public void setRes_yol(String res_yol) {
        this.res_yol = res_yol;
    }
    
}
