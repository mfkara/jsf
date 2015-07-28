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
public class ArabaModel {
    private int araba_id, araba_yili;

    public ArabaModel() {
    }

    public ArabaModel(int araba_id, int araba_yili, String araba_adi) {
        this.araba_id = araba_id;
        this.araba_yili = araba_yili;
        this.araba_adi = araba_adi;
    }
    

    public int getAraba_yili() {
        return araba_yili;
    }

    public void setAraba_yili(int araba_yili) {
        this.araba_yili = araba_yili;
    }
    private String araba_adi;

    public int getAraba_id() {
        return araba_id;
    }

    public void setAraba_id(int araba_id) {
        this.araba_id = araba_id;
    }

    public String getAraba_adi() {
        return araba_adi;
    }

    public void setAraba_adi(String araba_adi) {
        this.araba_adi = araba_adi;
    }
    
    
}
