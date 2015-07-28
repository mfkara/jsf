/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import model.StokModel;

/**
 *
 * @author Sungur
 */
public class StokManagedBean {
    StokModel sm;
    List<StokModel> snc;
    int adet=0;

    public StokModel getSm() {
        return sm;
    }

    public void setSm(StokModel sm) {
        this.sm = sm;
    }

    public List<StokModel> getSnc() {
        return snc;
    }

    public void setSnc(List<StokModel> snc) {
        this.snc = snc;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }
    public StokManagedBean() {
        sm=new StokModel();
    }
    
    public void ekle(){
        try {
            Baglan b = new Baglan();
            Connection c = b.baglan();
            System.out.println("geldi");
            String Sorgu = "insert into stok (parca_id,adet) values(?,?);";
            PreparedStatement ps = c.prepareStatement(Sorgu);
            ps.setInt(1, idGetir(ParcalarManagedBean.parcalar, ParcalarManagedBean.secili));
            ps.setInt(2, adet);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<StokModel> listele(){
        
        return snc;
    }
     public int idGetir(List<String> liste, String secili) {
        int id = 0;
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).equals(secili)) {
                id = ++i;
                break;

            }
        }
        return id;
    }
    public  void guncelle(){
        
    }
   
}
