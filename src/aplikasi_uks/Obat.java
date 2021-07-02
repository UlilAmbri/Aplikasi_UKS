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
public class Obat {
    private String kode_obat;
    private String nama;
    private String satuan;
    private int stok;
    
    public String getKodeObat(){
        return kode_obat;
    }
    
    public void setKodeObat(String kode_obat){
    this.kode_obat = kode_obat;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getSatuan(){
        return satuan;
    }
    
    public void setSatuan(String satuan){
        this.satuan = satuan;
    }
    
    public int getStok(){
        return stok;
    }
    
    public void setStok(int stok){
        this.stok = stok;
    }
    
    public String getObat(Connection con, String kode_keluhan) throws SQLException{
        String sql = "Select nama from t_stokobat where kode_obat=?";
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
