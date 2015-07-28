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
import javax.faces.event.ActionEvent;
import model.userModel;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
 
import org.primefaces.context.RequestContext;

/**
 *
 * @author Sungur
 */
public class userManagedBean implements Serializable{

    static String admin="parcaEkle";
    public userManagedBean() {
         HttpSession session = SessionBean.getSession();
        session.invalidate();
    }
   private String userEmail;
   private String userPassword;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public boolean giris() throws ClassNotFoundException, SQLException{
        Baglan b=new Baglan();
        boolean snc=false;
        Connection c=b.baglan();
        String sorgu="select * from users where userEmail='"+getUserEmail()+"' and userPassword='"+getUserPassword()+"'";
        System.out.println(sorgu);
        PreparedStatement prs;
     
        prs=c.prepareStatement(sorgu);
        ResultSet rs=prs.executeQuery();
        userModel usr=null;
        boolean bs=rs.next();

        while(bs){
   
            usr=new userModel();
            usr.setUserEmail(rs.getString("userEmail"));
            usr.setUserPassword(rs.getString("userPassword"));
            usr.setYetki(rs.getInt("yetki"));
            usr.setUser_id(rs.getInt("user_id"));
            bs=rs.next();
        }
        if(usr==null)
            snc=false;
        else if(usr.getYetki()==1)
            snc=true;
        else
        {
            snc=true;
            admin="index";
        }
       
        return snc;
    }
    public void login(ActionEvent event) throws ClassNotFoundException, SQLException {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
         
        if(giris()) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", getUserEmail());
            indexManagedBean.MasterPage="1";
            indexManagedBean.git(admin);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        
    }   
    //validate login
  /*  public String validateUsernamePassword() throws ClassNotFoundException, SQLException {
        boolean valid = giris();
        if (valid) {
            HttpSession session = SessionBean.getSession();
            session.setAttribute("username", getUserEmail());
            return "parcaEkle";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "parcaEkle";
        }
    }
 
    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        return "index";
    }*/
}
