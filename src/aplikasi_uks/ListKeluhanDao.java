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
public class ListKeluhanDao {
    public static void insert(Connection con, ListKeluhan listkeluhan) throws SQLException{
        String sql = "insert into t_listkeluhan values(?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, listkeluhan.getKodeList());
        ps.setString(2, listkeluhan.getKeluhan());
        ps.executeUpdate();
    }
    public static void update(Connection con, ListKeluhan listkeluhan) throws SQLException{
        String sql = "update t_listkeluhan set keluhan=? "
                + "where kode_list=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, listkeluhan.getKeluhan());
        ps.setString(2, listkeluhan.getKodeList());
        ps.executeUpdate();
    }
    public static void delete(Connection con, ListKeluhan listkeluhan) throws SQLException{
        String sql = "delete from t_listkeluhan where kode_list=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, listkeluhan.getKodeList());
        ps.executeUpdate();
    }
    public static ListKeluhan getListKeluhan(Connection con, String kode_list) throws SQLException{
        String sql = "Select * from t_listkeluhan where kode_list=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode_list);
        ListKeluhan listkeluhan = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            listkeluhan = new ListKeluhan();
            listkeluhan.setKodeList(rs.getString(1));
            listkeluhan.setKeluhan(rs.getString(2));
        }
        return listkeluhan;
    }
    /*
    public static ListKeluhan getListKeluhan(Connection con, String kode_list, String keluhan) throws SQLException{
        String sql = "Select * from t_listkeluhan where kode_list=? and keluhan=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode_list);
        ps.setString(2, keluhan);
        ListKeluhan listkeluhan = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            listkeluhan = new ListKeluhan();
            listkeluhan.setKodeList(rs.getString(1));
            listkeluhan.setKeluhan(rs.getString(2));
        }
        return listkeluhan;
    }*/
    
}
