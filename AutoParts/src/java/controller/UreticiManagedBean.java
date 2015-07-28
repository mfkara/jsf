package controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Kategori;
import model.UreticiModel;

/**
 *
 * @author Sungur
 */
public class UreticiManagedBean implements Serializable {

    UreticiModel um;
   static List<String> uAdList;
   static String secili;

    public void yaz()
    {
        System.out.println(" TUGFJKHSALAPIDHGJj ıknWKLNFSLİDKFJIJPKFASHDKAGHSŞLFKNSDMŞVLS6845485D6"+secili.toString());
    }
    public Object getSecili() {
        return secili;
    }

    public void setSecili(String secili) {
        this.secili = secili;
    }

    public UreticiModel getUm() {
        return um;
    }

    public void setUm(UreticiModel um) {
        this.um = um;
    }

    public List<String> getuAdList() {
        return uAdList;
    }

    public void setuAdList(List<String> uAdList) {
        this.uAdList = uAdList;
    }

    public UreticiManagedBean() {
    }

  static  public List<UreticiModel> ureticiGetir() {
        uAdList = new ArrayList<String>();
        List<UreticiModel> snc = new ArrayList<>();
        try {
            Baglan b = new Baglan();
            Connection c = b.baglan();
            String Sorgu = "select * from uretici";
            PreparedStatement ps = c.prepareStatement(Sorgu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 
                snc.add(new UreticiModel(rs.getInt(2), rs.getString(1)));
                uAdList.add(rs.getString(1));
            }

        } catch (Exception e) {
        }
        return snc;
    }

 static public List<String> ureticiADGetir() {
        ureticiGetir();
        return uAdList;
    }

}
