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
public class StokModel {
    private int stok_id;
    private ParcalarModel parca_id;
    private int adet;

    public int getStok_id() {
        return stok_id;
    }

    public void setStok_id(int stok_id) {
        this.stok_id = stok_id;
    }

    public ParcalarModel getParca_id() {
        return parca_id;
    }

    public void setParca_id(ParcalarModel parca_id) {
        this.parca_id = parca_id;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }
}
