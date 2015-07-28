package controller;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sungur
 */
public class Baglan {
    
  static  Connection c=null;
  static  public Connection baglan() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/autoParts","postgres","12345");
        return c;
    }
    
   static void veriEkle(String[] Veri) throws SQLException, ClassNotFoundException
    {
        String sorgu="insert into araba(araba_adi) values(?)";
        PreparedStatement ps=baglan().prepareStatement(sorgu);
        for(String a:Veri)
        {
            
            ps.setString(1, a);
            ps.executeUpdate();
        }
        
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String[] veri={""};
        
       
        veriEkle(veri);
    
   


    }
  
    
            }
