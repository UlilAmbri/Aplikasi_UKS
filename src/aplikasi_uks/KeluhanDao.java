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
//import Keluhan.Keluhan;
/**
 *
 * @author User
 */
public class KeluhanDao {
    Keluhan keluhan;
    public static void insert(Connection con, Keluhan keluhan) throws SQLException{
        String sql = "insert into t_keluhan values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, keluhan.getKodeKeluhan());
        ps.setString(2, keluhan.getKodeList());
        ps.setString(3, keluhan.getKodeList1());
        ps.setString(4, keluhan.getKodeList2());
        ps.executeUpdate();
    }
    public static void update(Connection con, Keluhan keluhan) throws SQLException{
        String sql = "update t_keluhan set kode_list=?, kode_list1=?, kode_list2=?, kode_pasien=?, kode_petugas=?  "
                + "where kode_keluhan=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, keluhan.getKodeList());
        ps.setString(2, keluhan.getKodeList1());
        ps.setString(3, keluhan.getKodeList2());
        ps.setString(6, keluhan.getKodeKeluhan());
        ps.executeUpdate();
    }
    public static void delete(Connection con, Keluhan keluhan) throws SQLException{
        String sql = "delete from t_keluhan where kode_keluhan=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, keluhan.getKodeKeluhan());
        ps.executeUpdate();
    }
    public static Keluhan getKeluhan(Connection con, String kode_keluhan) throws SQLException{
        String sql = "Select * from t_keluhan where kode_keluhan=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode_keluhan);
        Keluhan keluhan = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            keluhan = new Keluhan();
            keluhan.setKodeKeluhan(rs.getString(1));
            keluhan.setKodeList(rs.getString(2));
            keluhan.setKodeList1(rs.getString(3));
            keluhan.setKodeList2(rs.getString(4));
        }
        return keluhan;
    }
    
    public static Keluhan getKeluhan(Connection con, String kode_list, String kode_pasien, String kode_petugas) throws SQLException{
        String sql = "Select * from t_keluhan where kode_list=?, kode_pasien=?, kode_petugas=? ";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, kode_list);
        ps.setString(2, kode_pasien);
        ps.setString(3, kode_petugas);
        Keluhan keluhan = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            keluhan = new Keluhan();
            keluhan.setKodeKeluhan(rs.getString(1));
            keluhan.setKodeList(rs.getString(2));
            keluhan.setKodeList1(rs.getString(3));
            keluhan.setKodeList2(rs.getString(4));
        }
        return keluhan;
    }
    
    
    
    public static String getKodeKeluhan(Connection con) throws SQLException{
        String sql = "Select kode_keluhan from t_keluhan order by kode_keluhan desc limit 1 ";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String x = "";
        while(rs.next()){
            x = rs.getString(1);
        }
        return x;
    }
    
    public String getKeluhanText(Connection con, String id) throws SQLException{
        String sql = "Select kode_list,kode_list_1, kode_list_2 from t_keluhan where kode_keluhan = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        String x = "";
        String y = "";
        String z = "";
        keluhan = new Keluhan();
        while(rs.next()){
            x = rs.getString(1);
            y = rs.getString(2);
            z = rs.getString(3);
        }
        //String a = keluhan.getKeluhan(con,x);
        
        try{
            String tai = keluhan.getKeluhan(con,x)+","+keluhan.getKeluhan(con,y)+","+keluhan.getKeluhan(con,z);
            return tai;
        }catch(Exception e){
            try{
                String tai = keluhan.getKeluhan(con,x)+","+keluhan.getKeluhan(con,y);
                return tai;
            }catch(Exception f){
                String tai = keluhan.getKeluhan(con,x);
                return tai;
            }
        }
        
    }

}
