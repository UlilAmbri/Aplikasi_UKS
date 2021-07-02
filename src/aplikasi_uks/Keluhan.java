/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_uks;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author User
 */
public class Keluhan {
    private String kode_keluhan;
    private String kode_list;
    private String kode_list_1;
    private String kode_list_2;
    //private String kode_pasien;
    //private String kode_petugas;
    
    public String getKodeKeluhan(){
        return kode_keluhan;
    }
    
    public void setKodeKeluhan(String kode_keluhan){
        this.kode_keluhan = kode_keluhan;
    }
    
    public String getKodeList(){
        return kode_list;
    }
    
    public void setKodeList(String kode_list){
        this.kode_list = kode_list;
    }
    
    public String getKodeList1(){
        return kode_list_1;
    }
    
    public void setKodeList1(String kode_list){
        this.kode_list_1 = kode_list;
    }
    
    public String getKodeList2(){
        return kode_list_2;
    }
    
    public void setKodeList2(String kode_list){
        this.kode_list_2 = kode_list;
    }
    /*
    public String getKodePasien(){
        return kode_pasien;
    }
    
    public void setKodePasien(String kode_pasien){
        this.kode_pasien = kode_pasien;
    }
    
    public String getKodePetugas(){
        return kode_petugas;
    }
    
    public void setKodePetugas(String kode_petugas){
        this.kode_petugas = kode_petugas;
    }
*/
    public String getKeluhan(Connection con, String kode_keluhan) throws SQLException{
        String sql = "Select keluhan from t_listkeluhan where kode_list=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode_keluhan);
        String x = "";
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            x = rs.getString(1);
        }
        return x;
    }
}