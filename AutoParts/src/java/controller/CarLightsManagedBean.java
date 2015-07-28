/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ParcalarModel;

/**
 *
 * @author Sungur
 */
public class CarLightsManagedBean {
private List<ParcalarModel> snc;
    private ParcalarModel seciliParca;
    public static String MasterPage="MasterPage";

    public String getMasterPage() {
        return MasterPage;
    }

    public void setMasterPage(String MasterPage) {
        this.MasterPage = MasterPage;
    }

    public ParcalarModel getSeciliParca() {
        return seciliParca;
    }

    public void setSeciliParca(ParcalarModel seciliParca) {
        this.seciliParca = seciliParca;
    }

    public CarLightsManagedBean() {
        listele();
    }
   
    
    
    public List<ParcalarModel> listele(){
       snc=new ArrayList<>();
        try {
            Baglan b=new Baglan();
            Connection c=b.baglan();
            PreparedStatement ps=c.prepareStatement("select * from  parcalar where  kategori_id=1" );
            
       ResultSet rs=ps.executeQuery();
            while (rs.next()) {
              snc.add(new ParcalarModel(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getDouble(5),rs.getInt(6),rs.getInt(7),rs.getString(8)
              ));
                System.out.println(rs.getString(8));
          
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return  snc;
    }

    public List<ParcalarModel> getSnc() {
        return snc;
    }

    public void setSnc(List<ParcalarModel> snc) {
        this.snc = snc;
    }
}
