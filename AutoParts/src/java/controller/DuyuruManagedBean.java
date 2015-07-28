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
import model.userModel;

/**
 *
 * @author Sungur
 */
public class DuyuruManagedBean implements Serializable{

   String duyuru;
 List<String> snc;
    public String getDuyuru() {
        return duyuru;
    }

    public void setDuyuru(String duyuru) {
        this.duyuru = duyuru;
    }
    public DuyuruManagedBean() {
    }
    
    public List<String> duyuruListele()
    {
         snc=new ArrayList<>();
            try {
             Baglan b=new Baglan();
        
        Connection c=b.baglan();
        String sorgu="select * from duyuru";
   
        PreparedStatement prs;
     
        prs=c.prepareStatement(sorgu);
        ResultSet rs=prs.executeQuery();
                while (rs.next()) {                    
                    snc.add(rs.getString(2));
                }
      

        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
        return snc;
    }
    public void duyuruEKle(){
         try {
             Baglan b=new Baglan();
        
        Connection c=b.baglan();
        String sorgu="insert into duyuru (duyuru) values('"+duyuru+"')";
             System.out.println(sorgu);
        PreparedStatement prs;
     
        prs=c.prepareStatement(sorgu);
       prs.executeUpdate();
              
      

        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
    }
     public void duyuruSil(){
         System.out.println(duyuru);
        try {
            Baglan b = new Baglan();
            Connection c = b.baglan();
            /* UPDATE table_nameSET column1=value1,column2=value2 WHERE some_column=some_value;*/
            PreparedStatement ps=c.prepareStatement(" delete from duyuru where duyuru_id="+snc.indexOf(duyuru)+1);
           ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     public void duyuruGuncelle(){
           try {
            Baglan b = new Baglan();
            Connection c = b.baglan();
               System.out.println(duyuru+"srdftghjklş");
            /* UPDATE table_nameSET column1=value1,column2=value2 WHERE some_column=some_value;*/
            String sorgu="update duyuru set duyuru="+duyuru+" where duyuru_id="+(snc.indexOf(duyuru)+1);
            PreparedStatement ps=c.prepareStatement(sorgu);
               System.out.println(  sorgu);
               
            ps.executeUpdate();
        } catch (Exception e) {
           e.printStackTrace();
        }

     }
}
