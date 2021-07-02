/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_uks;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class UserDao {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;
    public UserDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/uks", "root", "");
            st=con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi Database gagal, Terjadi kesalahan pada : \n " +e);
        }
    }
     public static void insert(Connection con, User user) throws SQLException{
        String sql = "insert into t_user values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, user.getIdUser());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getAkses());
        ps.executeUpdate();
    }
    public static void update(Connection con, User user) throws SQLException{
        String sql = "update t_user set username=?, password=?, akses=? "
                + "where id_user=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getAkses());
        ps.setInt(4, user.getIdUser());
        ps.executeUpdate();
    }
    public static void delete(Connection con, User user) throws SQLException{
        String sql = "delete from t_user where id_user=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, user.getIdUser());
        ps.executeUpdate();
    }
    public static User getUser(Connection con, String username) throws SQLException{
        String sql = "Select * from t_user where username=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        User user = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            user = new User();
            user.setIdUser(rs.getInt(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setAkses(rs.getString(4));
        }
        return user;
    }
    
    /*public User getUser(String User){
        User user = new User(); 
        sql = "select * from t_user where id_user='" +User+ "'";
        try{
            rs = st.executeQuery(sql);
            while (rs.next()) {                
                user.setIdUser(rs.getInt("id_user"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                //user.setNamaAkun(rs.getString("nama"));
                user.setAkses(rs.getString("hak_akses"));
            }
            return user;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Tampil, pada : "+e);
        }
        return user;
    }*/
    
    public List cariLogin(String username, String password) {
        List logLogin = new ArrayList();
        int result;
        sql = "select username, password, hak_akses from t_user where username='" +username+ "' and password='" +password+"'";
        try {
            rs=st.executeQuery(sql);
            while (rs.next()) {                
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                //user.setNamaAkun(rs.getString("nama"));
                user.setAkses(rs.getString("hak_akses"));
                logLogin.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ternjadi kesalahan login, pada:n" +e);
        }
        return logLogin;
    }
    
    public String getPassword(String username){
        sql =  "select password from t_user where username ='" +username+ "'";
        String psw = "";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {                
                psw = rs.getString(1);
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Terjadi kesalahan pencarian data id, pada" +e);
            psw = "999";
        }
        return psw;
    }
    
    public String getAkses(String username){
        sql =  "select hak_akses from t_user where username ='" +username+ "'";
        String psw = "";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {                
                psw = rs.getString(1);
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Terjadi kesalahan pencarian data id, pada" +e);
            psw = "999";
        }
        return psw;
    }
    
    public List cariId(int id_user) {
        List logLogin = new ArrayList();
        int result;
        sql =  "select id_user from t_user where id_user ='" +id_user+ "'";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {                
                User user = new User(); 
                user.setIdUser(rs.getInt("id_user"));
                logLogin.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pencarian data id, pada" +e);
        }
        return logLogin;
    }
    
    public int tambah(User user) {
        sql = "insert into t_user  values ('"+user.getIdUser()+"','"+user.getUsername()+"','" +user.getPassword()+ "','"+user.getAkses()+ "')";
        int hasil = 0;
        try {
            hasil = st.executeUpdate(sql);
        } catch (Exception e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
        }
        return hasil;
    }
    
    public List Tampil () {
        List logMainMenu = new ArrayList();
        sql = "select id_user, username, password, akses from t_user order by id_user asc";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {                
                User user = new User(); 
                user.setIdUser(rs.getInt("id_user"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                //user.setNamaAkun(rs.getString("nama"));
                user.setAkses(rs.getString("hak_akses"));
                logMainMenu.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Tampil, pada : "+e);
        }
        return logMainMenu;
    }
}
