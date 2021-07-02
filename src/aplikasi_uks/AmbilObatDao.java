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
public class AmbilObatDao {
    Obat obat;
    public static void insert(Connection con, AmbilObat ambilobat) throws SQLException{
        String sql = "insert into t_ambilobat values(?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, ambilobat.getKodeAmbilObat());
        ps.setString(2, ambilobat.getObat());
        ps.setString(3, ambilobat.getObat1());
        ps.setString(4, ambilobat.getObat2());
        ps.setInt(5, ambilobat.getNama());
        ps.setInt(6, ambilobat.getNama1());
        ps.setInt(7, ambilobat.getNama2());
        ps.executeUpdate();
    }
    public static void update(Connection con, AmbilObat ambilobat) throws SQLException{
        String sql = "update t_obat set obat=?, obat1=?, obat2=?, nama=?, nama1=?, nama2=? "
                + "where kode_ambilobat=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, ambilobat.getObat());
        ps.setString(2, ambilobat.getObat1());
        ps.setString(3, ambilobat.getObat2());
        ps.setInt(4, ambilobat.getNama());
        ps.setInt(5, ambilobat.getNama1());
        ps.setInt(6, ambilobat.getNama2());
        ps.setString(7, ambilobat.getKodeAmbilObat());
        ps.executeUpdate();
    }
    public static void delete(Connection con, AmbilObat ambilobat) throws SQLException{
        String sql = "delete from t_obat where kode_ambilobat=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, ambilobat.getKodeAmbilObat());
        ps.executeUpdate();
    }
    public static AmbilObat getObat(Connection con, String kode_ambilobat) throws SQLException{
        String sql = "Select * from t_ambilobat where kode_ambilobat=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode_ambilobat);
        AmbilObat ambilobat = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            ambilobat = new AmbilObat();
            ambilobat.setKodeAmbilObat(rs.getString(1));
            ambilobat.setObat(rs.getString(2));
            ambilobat.setObat1(rs.getString(3));
            ambilobat.setObat2(rs.getString(4));
            ambilobat.setNama(rs.getInt(5));
            ambilobat.setNama1(rs.getInt(6));
            ambilobat.setNama2(rs.getInt(7));
        }
        return ambilobat;
    }
    
    public static String getKodeObat(Connection con) throws SQLException{
        String sql = "Select kode_ambilobat from t_ambilobat order by kode_ambilobat desc limit 1 ";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String x = "";
        while(rs.next()){
            x = rs.getString(1);
        }
        return x;
    }
    
    public String getObatText(Connection con, String id) throws SQLException{
        String sql = "Select obat,obat1,obat2 from t_ambilobat where kode_ambilobat = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        String x = "";
        String y = "";
        String z = "";
        obat = new Obat();
        while(rs.next()){
            x = rs.getString(1);
            y = rs.getString(2);
            z = rs.getString(3);
        }
        try{
            String t = obat.getObat(con,x)+","+obat.getObat(con,y)+","+obat.getObat(con,z);
            return t;
        }catch(Exception e){
            try{
                String t = obat.getObat(con,x)+","+obat.getObat(con,y);
                return t;
            }catch(Exception f){
                String t = obat.getObat(con,x);
                return t;
            }
        }
        //return obat.getObat(con,x)+","+obat.getObat(con,y)+","+obat.getObat(con,z);
    }
}
