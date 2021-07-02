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
public class PeriksaDao {
    public static void insert(Connection con, Periksa periksa) throws SQLException{
        String sql = "insert into t_pemeriksaan values(?,?,?,?,?,?)";
        System.out.print("1");
        PreparedStatement ps = con.prepareStatement(sql);
        System.out.print("2");
        ps.setString(1, periksa.getKodePeriksa());
        System.out.print("3");
        ps.setString(2, periksa.getKodeKeluhan());
        System.out.print("4");
        ps.setString(3, periksa.getKodeObat());
        System.out.print("5");
        ps.setString(4, periksa.getKodePasien());
        System.out.print("6");
        ps.setString(5, periksa.getKodePetugas());
        System.out.print("7");
        ps.setString(6, periksa.getDiagnosa());
        System.out.print("8");
        ps.executeUpdate();
    }
    public static void update(Connection con, Periksa periksa) throws SQLException{
        String sql = "update t_pemeriksaan set kode_keluhan=?, kode_obat=?, =?,kode_pasien=?, kode_petugas=?, diagnosa=? "
                + "where kode_periksa=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, periksa.getKodeKeluhan());
        ps.setString(2, periksa.getKodeObat());
        ps.setString(3, periksa.getKodePasien());
        ps.setString(4, periksa.getKodePetugas());
        ps.setString(5, periksa.getDiagnosa());
        ps.setString(6, periksa.getKodePeriksa());
        ps.executeUpdate();
    }
    public static void delete(Connection con, Periksa periksa) throws SQLException{
        String sql = "delete from t_pemeriksaan where kode_periksa=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, periksa.getKodePeriksa());
        ps.executeUpdate();
    }
    public static Periksa getPeriksa(Connection con, String kode_periksa) throws SQLException{
        String sql = "Select * from t_pemeriksaan where kode_periksa=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode_periksa);
        Periksa periksa = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            periksa = new Periksa();
            periksa.setKodePeriksa(rs.getString(1));
            periksa.setKodeKeluhan(rs.getString(2));
            periksa.setKodeObat(rs.getString(3));
            periksa.setKodePasien(rs.getString(4));
            periksa.setKodePetugas(rs.getString(5));
            periksa.setDiagnosa(rs.getString(6));
        }
        return periksa;
    }
    
    public static Periksa getPeriksa(Connection con, String kode_keluhan, String kode_pasien, String kode_petugas) throws SQLException{
        String sql = "Select * from t_pemeriksaan where kode_pasien=? and kode_petugas=? and kode_keluhan=? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode_keluhan);
        ps.setString(2, kode_pasien);
        ps.setString(3, kode_petugas);
        Periksa periksa = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            periksa = new Periksa();
            periksa.setKodePeriksa(rs.getString(1));
            periksa.setKodePasien(rs.getString(2));
            periksa.setKodePetugas(rs.getString(3));
            periksa.setKodeKeluhan(rs.getString(4));
            periksa.setDiagnosa(rs.getString(5));
        }
        return periksa;
    }
}
