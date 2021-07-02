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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
public class UserController {
    FormLogin view;
    FormRegister viewR;
    FormChangePassword viewRR;
    User user;
    UserDao userdao;
    Connection con;
    
    
    public UserController(FormLogin view) {
        try {
            this.view = view;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
            clearView();
            //isiCombo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public UserController(FormRegister view) {
        try {
            this.viewR = view;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
            isiCombo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public UserController(FormChangePassword view) {
        try {
            this.viewRR = view;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
            isiComboAksesRR();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearView(){
        view.getTxtUsername().setText("");
        view.getTxtPassword().setText("");
    }
    public void clearViewR(){
        viewR.getTxtUsername().setText("");
        viewR.getTxtPassword().setText("");
        viewR.getTxtPassword2().setText("");
    }
    public void isiCombo(){
        viewR.getCboAkses().removeAllItems();
        viewR.getCboAkses().addItem("-");
        viewR.getCboAkses().addItem("Administrator");
        viewR.getCboAkses().addItem("Petugas");
    }
    
    public void isiComboAksesRR(){
        viewRR.getCboAkses().removeAllItems();
        viewRR.getCboAkses().addItem("Administrator");
        viewRR.getCboAkses().addItem("Petugas");
    }
    public boolean onClickBtnLogin(){
        try{
            String username = view.getTxtUsername().getText();
            //user = userdao.getUser(con,username);
            String password = view.getTxtPassword().getText();
            //user = userdao.getUser(con,password);
            UserDao userdao = new UserDao();
            if(userdao.getPassword(username) == "999"){
                JOptionPane.showMessageDialog(view, "Username tidak ditemukan !!!");
            }//else if(userdao.getPassword(username) != password){
             //   System.out.print(userdao.getPassword(username));
             //   System.out.print(password);
             //   JOptionPane.showMessageDialog(view, "Password salah GOBLOK !!!");}
            else if(userdao.getPassword(username).equals(password) && userdao.getAkses(username).equals("Administrator")){
                javax.swing.JOptionPane.showMessageDialog(view, "Login Berhasil");
                FormAdmin f = new FormAdmin();
                FormLogin fl = new FormLogin();
                f.setVisible(true);
                fl.dispose();
                f.toFront();
            }else if(userdao.getPassword(username).equals(password) && userdao.getAkses(username).equals("Petugas")){
                javax.swing.JOptionPane.showMessageDialog(view, "Login Berhasil");
                FormPetugas f = new FormPetugas();
                f.setVisible(true);
                f.toFront();
            }else{
                JOptionPane.showMessageDialog(view, "Isi terlebih dahulu username & password anda !!!");
            }/*
            if(view.getCboAkses().getSelectedItem().equals("admin")){
                javax.swing.JOptionPane.showMessageDialog(view, "Login Berhasil");
                FormAdmin f = new FormAdmin();
                f.setVisible(true);
                f.toFront();
            }else if(view.getCboAkses().getSelectedItem().equals("petugas")){
                javax.swing.JOptionPane.showMessageDialog(view, "Login Berhasil");
                FormPetugas f = new FormPetugas();
                f.setVisible(true);
                f.toFront();
            }else if(username == "" || password == ""){
                JOptionPane.showMessageDialog(view, "Username atau password kosong !!!");
                FormLogin f = new FormLogin();
                f.setVisible(true);
                f.toFront();
            }
            else{
                JOptionPane.showMessageDialog(view, "Username dan password salah !!!");
                FormLogin f = new FormLogin();
                f.setVisible(true);
                f.toFront();
            }*/
            return true;
        //}catch (SQLException ex) {
         //   Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NullPointerException ex){
            JOptionPane.showMessageDialog(view, "Username dan password salah !!!");
            clearView();
        }finally {
            clearView();
        }
        return false;
    }
    
    public String getPasswordAttempt(){
        if(viewR.getTxtPassword().getText().equals("")){
            return "0";
        }else if(viewR.getTxtPassword().getText().length() < 5){
            return "-1";
        }else if(!viewR.getTxtPassword().getText().equals(viewR.getTxtPassword().getText())){
            return "1";
        }else{
            return viewR.getTxtPassword().getText();
        }
    }
    public boolean usernameCheck(){
        try{
            String username = viewR.getTxtUsername().getText();
            user = userdao.getUser(con,username);
            if(user == null) return true;
        }catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void onClickBtnCreate(){
        if(getPasswordAttempt() == "0"){
            javax.swing.JOptionPane.showMessageDialog(viewR, "Password tidak boleh kosong!");
        }else if(getPasswordAttempt() == "-1"){
            javax.swing.JOptionPane.showMessageDialog(viewR, "Password minimal 5 Karakter!");
        }else if(getPasswordAttempt() == "1"){
            javax.swing.JOptionPane.showMessageDialog(viewR, "Password tidak sama!");
        }else{
            user = new User();
            //user.setIdUser(Integer.parseInt(viewR.getTxtId().getText()));
            user.setUsername(viewR.getTxtUsername().getText());
            //javax.swing.JOptionPane.showMessageDialog(viewR, "Username tidak boleh kosong!");
            user.setPassword(getPasswordAttempt());
            user.setAkses(viewR.getCboAkses().getSelectedItem().toString());
            try {
                UserDao.insert(con, user);
                JOptionPane.showMessageDialog(viewR, "Berhasil Register");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(viewR, "Error e "+ex.getMessage()); 
            }
        }
    }
}
