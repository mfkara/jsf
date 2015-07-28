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
import model.KategoriModel;
import model.ParcalarModel;

/**
 *
 * @author Sungur
 */
public class ParcalarManagedBean implements Serializable {

    private ParcalarModel pm;
    private KategoriModel kM;
    private List<ParcalarModel> snc;
    private ParcalarModel seciliParca;
    static List<String> parcalar;
   static String secili;

    public String getSecili() {
        return secili;
    }

    public void setSecili(String secili) {
        this.secili = secili;
    }

    public List<String> getParcalar() {
        return parcalar;
    }

    public void setParcalar(List<String> parcalar) {
        this.parcalar = parcalar;
    }

    

    public KategoriModel getkM() {
        return kM;
    }

    public void setkM(KategoriModel kM) {
        this.kM = kM;
    }

    public List<ParcalarModel> getSnc() {
        return snc;
    }

    public void setSnc(List<ParcalarModel> snc) {
        this.snc = snc;
    }

    public ParcalarModel getSeciliParca() {
        return seciliParca;
    }

    public void setSeciliParca(ParcalarModel seciliParca) {
        this.seciliParca = seciliParca;
    }

    public ParcalarManagedBean() {
        pm = new ParcalarModel();
        getir();

    }

    public ParcalarModel getPm() {
        return pm;
    }

    public void setPm(ParcalarModel pm) {
        this.pm = pm;
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

    public void ekle() {
        try {
            Baglan b = new Baglan();
            Connection c = b.baglan();
            
            String Sorgu = "insert into parcalar (parca_adi,kategori_id,araba_id,uretimyili,fiyat,uretici_id) values(?,?,?,?,?,?);";
            PreparedStatement ps = c.prepareStatement(Sorgu);
            ps.setString(1, pm.getParca_adi());
            ps.setInt(2, idGetir(kategoriManagedBean.kAdGetir(), kategoriManagedBean.secili));
            ps.setInt(3, idGetir(ArabaManagedBean.arabalar, ArabaManagedBean.secili));
            ps.setInt(4, pm.getUretimyili());
            ps.setDouble(5, pm.getFiyat());
            ps.setInt(6, idGetir(UreticiManagedBean.uAdList, UreticiManagedBean.secili));
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ParcalarModel> getir() {
        List<ParcalarModel> snc = new ArrayList<>();
        parcalar=new ArrayList<>();
        try {
            Baglan b = new Baglan();
            Connection c = b.baglan();
            String Sorgu = "select * from parcalar";
            PreparedStatement ps = c.prepareStatement(Sorgu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                snc.add(new ParcalarModel(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7), rs.getString(8)));
                parcalar.add(rs.getString(1));
                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return snc;
    }

    public void guncelle() {
        try {
            Baglan b = new Baglan();
            Connection c = b.baglan();
            /* UPDATE table_nameSET column1=value1,column2=value2 WHERE some_column=some_value;*/
            PreparedStatement ps=c.prepareStatement("update parcalar set parca_adi = ?,kategori_id=?,araba_id=?,uretimyili=?,fiyat=?,uretici_id=? where parca_id="+seciliParca.getParca_id());
            ps.setString(1, seciliParca.getParca_adi());
            ps.setInt(2, idGetir(kategoriManagedBean.kAdGetir(), kategoriManagedBean.secili));
            ps.setInt(3, idGetir(ArabaManagedBean.arabalar, ArabaManagedBean.secili));
            ps.setInt(4, seciliParca.getUretimyili());
            ps.setDouble(5, seciliParca.getFiyat());
            ps.setInt(6, idGetir(UreticiManagedBean.uAdList, UreticiManagedBean.secili));
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public void sil(){
        try {
            Baglan b = new Baglan();
            Connection c = b.baglan();
            /* UPDATE table_nameSET column1=value1,column2=value2 WHERE some_column=some_value;*/
            PreparedStatement ps=c.prepareStatement(" delete from parcalar where parca_id="+seciliParca.getParca_id());
           ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    

}
