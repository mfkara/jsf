/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.spi.DirStateFactory;
import model.musteriBilgileri;
import model.userModel;
public class musteriBilgileriManagedBean {
        
   private musteriBilgileri mB=new musteriBilgileri();
   private userModel uM;

    public userModel getuM() {
        return uM;
    }

    public void setuM(userModel uM) {
        this.uM = uM;
    }
    /**
     * Creates a new instance of musteriBilgileriManagedBean
     */
    public musteriBilgileriManagedBean() {
       mB=new musteriBilgileri();
        uM=new userModel();
    }

    public musteriBilgileri getmB() {
        return mB;
    }

    public void setmB(musteriBilgileri mB) {
        this.mB = mB;
    }
    
    public boolean musteriKayit(){
       
        boolean snc=false;
        try {
             Baglan b=new Baglan();
        
        Connection c=b.baglan();
        String sorgu="insert into users (useremail,userpassword,yetki) values (?,?,?)";
        
        PreparedStatement prs;
        prs=c.prepareStatement(sorgu);
        prs.setString(1,uM.getUserEmail());
        prs.setString(2, uM.getUserPassword());
        prs.setInt(3, 0);
        prs.executeUpdate();
                
        prs.close();
        sorgu="select user_id from users where useremail='"+uM.getUserEmail()+"'";
        prs=c.prepareStatement(sorgu);
        ResultSet rs=prs.executeQuery();
            while (rs.next()) {                
                 uM.setUser_id(rs.getInt(1));
            }
       
        mB.setUser_id(uM);
        prs.close();
        sorgu="insert into musteriBilgileri (mus_Adi,mus_Soyadi,DogumTarihi,Adres,Telefon,user_id) values (?,?,?,?,?,?)";
        prs=c.prepareStatement(sorgu);
        prs.setString(1,mB.getMus_adi());
        prs.setString(2, mB.getMus_soyadi());
        prs.setDate(3,new Date(mB.getDtarih().getTime()) );
        prs.setString(4, mB.getAdres());
        prs.setString(5, mB.getTelefon());
        prs.setInt(6, mB.getUser_id().getUser_id());
        prs.executeUpdate(); 
        snc=true;
                    }
        catch (Exception e) {
                snc =false;
                System.out.println(e.getMessage());
        }
        return snc;
        
    }
    
}
