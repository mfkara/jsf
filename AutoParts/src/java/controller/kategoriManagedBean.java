/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Kategori;

/**
 *
 * @author Sungur
 */
public class kategoriManagedBean implements Serializable{

    private Kategori km;
  static  List<String> Kategoriler ;
   static String secili; 

    public String getSecili() {
        return secili;
    }

    public void setSecili(String secili) {
        this.secili = secili;
    }

    public List<String> getKategoriler() {
        return Kategoriler;
    }

    public void setKategoriler(List<String> Kategoriler) {
        this.Kategoriler = Kategoriler;
    }
    public kategoriManagedBean() {
        km=new Kategori();
        
    }
    

    public Kategori getKm() {
        return km;
    }

    public void setKm(Kategori km) {
        this.km = km;
    }
    
  static  public List<Kategori> getir(){
        List<Kategori> snc=new ArrayList<>();
        Kategoriler= new ArrayList<String>();
        try {
            Baglan b=new Baglan();
            Connection c=b.baglan();
            String Sorgu="select * from kategori";
            PreparedStatement ps=c.prepareStatement(Sorgu);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                snc.add(new Kategori(rs.getString(1),rs.getInt(2)));
                Kategoriler.add(rs.getString(1));
            }
           
        } catch (Exception e) {
        }
        return snc;
    }
     public Kategori getKategori(int K_id){
               try {
            Baglan b=new Baglan();
            Connection c=b.baglan();
            String Sorgu="select * from kategori where kategori_id="+K_id;
            PreparedStatement ps=c.prepareStatement(Sorgu);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
                km=(new Kategori(rs.getString(1),rs.getInt(2)));
        } catch (Exception e) {
        }
        return km;
    }
    static public List<String> kAdGetir(){
         getir();
         return Kategoriler;
     }
    
    
    
    
    
}
