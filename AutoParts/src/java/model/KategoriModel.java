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
public class KategoriModel {
    private String kategori_adi;
    private int kategori_id;

    public KategoriModel(String kategori_adi, int kategori_id) {
        this.kategori_adi = kategori_adi;
        this.kategori_id = kategori_id;
    }

    public KategoriModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String getKategori_adi() {
        return kategori_adi;
    }

    public void setKategori_adi(String kategori_adi) {
        this.kategori_adi = kategori_adi;
    }

    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }
    
}
