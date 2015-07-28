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
public class UreticiModel {
    private int uretici_id;
    private String uretici_adi;

    public UreticiModel(int uretici_id, String uretici_adi) {
        this.uretici_id = uretici_id;
        this.uretici_adi = uretici_adi;
    }
    

    public int getUretici_id() {
        return uretici_id;
    }

    public void setUretici_id(int uretici_id) {
        this.uretici_id = uretici_id;
    }

    public String getUreitici_adi() {
        return uretici_adi;
    }

    public void setUreitici_adi(String uretici_adi) {
        this.uretici_adi = uretici_adi;
    }
}
