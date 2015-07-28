/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sungur
 */
@Entity
@Table(name = "Kategori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategori.findAll", query = "SELECT k FROM Kategori k"),
    @NamedQuery(name = "Kategori.findByKategoriAdi", query = "SELECT k FROM Kategori k WHERE k.kategoriAdi = :kategoriAdi"),
    @NamedQuery(name = "Kategori.findByKategoriId", query = "SELECT k FROM Kategori k WHERE k.kategoriId = :kategoriId")})
public class Kategori implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 2147483647)
    @Column(name = "kategori_Adi")
    private String kategoriAdi;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kategori_id")
    private int kategoriId;

    public Kategori() {
    }

    public Kategori(String kategoriAdi, int kategoriId) {
        this.kategoriAdi = kategoriAdi;
        this.kategoriId = kategoriId;
    }

    public Kategori(int kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getKategoriAdi() {
        return kategoriAdi;
    }

    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }

    public int getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
    }

   

   

    
}
