/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.ParcalarModel;

/**
 *
 * @author Sungur
 */
public class SepetManagedBean {

    List<ParcalarModel> sepet=new ArrayList<>();
    ParcalarModel p;
    ParcalarModel secili;

    public ParcalarModel getSecili() {
        return secili;
    }

    public void setSecili(ParcalarModel secili) {
        this.secili = secili;
    }

    public int getSepetSayac() {
        return sepetSayac;
    }

    public void setSepetSayac(int sepetSayac) {
        this.sepetSayac = sepetSayac;
    }
    int sepetSayac=0;

    public List<ParcalarModel> getSepet() {
        return sepet;
    }

    public void setSepet(List<ParcalarModel> sepet) {
        this.sepet = sepet;
    }

    public ParcalarModel getP() {
        return p;
    }

    public void setP(ParcalarModel p) {
        this.p = p;
    }
    public SepetManagedBean() {
        
    }
    
    public void SepeteEkle(){
        sepet.add(p);
        sepetSayac=sepet.size();
    }
    public String SepetenSil(){
        sepet.remove(p);
        sepetSayac=sepet.size();
        return "sepet";
    }
}
