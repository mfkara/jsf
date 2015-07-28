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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.ArabaModel;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Sungur
 */
public class ArabaManagedBean implements Serializable{

    private ArabaModel a;
   static List<String> arabalar ;
   static String secili;

    public String getSecili() {
        return secili;
    }

    public void setSecili(String secili) {
        this.secili = secili;
    }
    public ArabaManagedBean() {
    
        a=new ArabaModel();
    }
    
    public String ekle()
    {
        boolean snc=false;
        try {
            System.out.println("geldik");
            Baglan b=new Baglan();
            Connection c=b.baglan();
            String sorgu="insert into araba (araba_adi, araba_yili) values(?,?)";
            PreparedStatement prs=c.prepareStatement(sorgu);
            prs.setString(1, a.getAraba_adi());
            prs.setInt(2, a.getAraba_yili());
            prs.executeUpdate();
            snc=true;
        } catch (Exception e) {
            snc=false;
            System.out.println(e.getMessage());
        }
        return "ArabaEkle";
    }
    
    
 static   public List<ArabaModel> getir(){
        List<ArabaModel> snc=new  ArrayList<>();
        arabalar= new ArrayList<String>();
        
        try {
            Baglan b=new Baglan();
            Connection c=b.baglan();
            String sorgu="select * from araba";
            PreparedStatement prs=c.prepareStatement(sorgu);
            ResultSet rs=prs.executeQuery();
            while (rs.next())       
            {
                snc.add(new ArabaModel(rs.getInt("araba_id"),rs.getInt("araba_yili"),rs.getString("araba_adi")));
                arabalar.add(rs.getString("araba_adi"));
            }
                
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        return snc;
    }
   static public List<String> arabaAdGetir(){
        getir();
        return arabalar;
    }
            
    public ArabaModel getA() {
        return a;
    }

    public void setA(ArabaModel a) {
        this.a = a;
    }
    
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg;
        msg = new FacesMessage("Car Edited", String.valueOf(((ArabaModel) event.getObject()).getAraba_id()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled",String.valueOf(((ArabaModel) event.getObject()).getAraba_id()) );
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) throws ClassNotFoundException, SQLException {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
          System.out.println("geldi");
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            try {
               
            Baglan b=new Baglan();
            Connection c=b.baglan();
            String sorgu="UPDATE araba SET araba_yili="+newValue+" WHERE araba_yili="+oldValue;
            PreparedStatement prs=c.prepareStatement(sorgu);
            prs.executeUpdate();
               
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
