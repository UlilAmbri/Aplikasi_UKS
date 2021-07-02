/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_uks;

import aplikasi_uks.Anggota;
import aplikasi_uks.ListKeluhan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class KeluhanController {
     FormKeluhan view;
    //FormLaporanObat formLaporanObat;
    Keluhan keluhan;   //model
    Connection con;
    
     public KeluhanController(FormKeluhan view) {
        try {
            this.view = view;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
            clearForm();
            viewTable();
            viewTable1();
            isiCboKodePasien();
            isiCboKodeList();
            isiCboKodeList1();
            isiCboKodeList2();
            isiCboKodePetugas();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObatController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ObatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*public ObatController(FormLaporanBuku formLaporanBuku) {
        this.formLaporanBuku = formLaporanBuku;
        Koneksi k = new Koneksi();
        try {
            con = k.getKoneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    public void clearForm(){
        view.getTxtKodeKeluhan().setText("");
        
    }
    
    
    public void viewTable(){
        try {
            DefaultTableModel tabelModel =
                    (DefaultTableModel) view.getTabelKeluhan().getModel();
            tabelModel.setRowCount(0);
            ResultSet rs = con.createStatement().executeQuery("select * from t_keluhan");
            while(rs.next()){
                Object[] data={
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                };
                tabelModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void viewTable1(){
        try {
            DefaultTableModel tabelModel =
                    (DefaultTableModel) view.getTabelListKeluhan().getModel();
            tabelModel.setRowCount(0);
            ResultSet rs = con.createStatement().executeQuery("select * from t_listkeluhan");
            while(rs.next()){
                Object[] data={
                    rs.getString(1),
                    rs.getString(2)
                };
                tabelModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListKeluhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   /* public void onClickTabel() {
        try {
            String kode = view.getTabelKeluhan().getValueAt(view.getTabelKeluhan().getSelectedRow(), 0).toString();
            keluhan = KeluhanDao.getKeluhan(con, kode);
            if (keluhan != null) {
                view.getTxtKodeKeluhan().setText(keluhan.getKodeKeluhan());
                view.getCboList().setSelectedItem(keluhan.getKodeList());
                view.getCboKodePasien().setSelectedItem(keluhan.getKodePasien());
                view.getCboKodePetugas().setSelectedItem(keluhan.getKodePetugas());
            } else {
                javax.swing.JOptionPane.showMessageDialog(view, "Data Tidak Ada");
                clearForm();
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    public String getKodeList(){
        String[] s = view.getCboList().getSelectedItem().toString().split("-");
        return s[0];
    }
    
    public String getKodeList1(){
        String[] s = view.getCboList1().getSelectedItem().toString().split("-");
        return s[0];
    }
    
    public String getKodeList2(){
        String[] s = view.getCboList2().getSelectedItem().toString().split("-");
        return s[0];
    }
    
    public String getKodePasien(){
        String[] s = view.getCboKodePasien().getSelectedItem().toString().split("-");
        return s[0];
    }
    
    public String getKodePetugas(){
        String[] s = view.getCboKodePasien().getSelectedItem().toString().split("-");
        return s[0];
    }
    
    
    public void isiCboKodePasien(){
        view.getCboKodePasien().removeAllItems();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from t_pasien");
            while (rs.next()) {                
                view.getCboKodePasien().addItem(rs.getString(1)+"-"+rs.getString(2)); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void isiCboKodePetugas(){
        view.getCboKodePetugas().removeAllItems();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from t_petugas");
            while (rs.next()) {                
                view.getCboKodePetugas().addItem(rs.getString(1)+"-"+rs.getString(2)); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void isiCboKodeList(){
        view.getCboList().removeAllItems();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from t_listkeluhan");
            while (rs.next()) {                
                view.getCboList().addItem(rs.getString(1)+"-"+rs.getString(2)); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void isiCboKodeList1(){
        view.getCboList1().removeAllItems();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from t_listkeluhan");
            while (rs.next()) {                
                view.getCboList1().addItem(rs.getString(1)+"-"+rs.getString(2)); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void isiCboKodeList2(){
        view.getCboList2().removeAllItems();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from t_listkeluhan");
            while (rs.next()) {                
                view.getCboList2().addItem(rs.getString(1)+"-"+rs.getString(2)); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /*public void previewBuku() {
        HashMap parameter = new HashMap();
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport("report/buku.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.print(ex.toString());
            //Logger.getLogger(formlaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void previewBukuTahunTerbit() {
        HashMap parameter = new HashMap();
        parameter.put("tahunterbit", formLaporanBuku.getCboTahun().getSelectedItem().toString());
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport("report/buku_TahunTerbit.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.print(ex.toString());
            //Logger.getLogger(formlaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    /*public void insert(){
        keluhan = new Keluhan();
        keluhan.setKodeKeluhan(view.getTxtKodeKeluhan().getText());
        keluhan.setKodeList(getKodeList());
        keluhan.setKodeList1(getKodeList1());
        keluhan.setKodeList2(getKodeList2());
        keluhan.setKodePasien(getKodePasien());
        keluhan.setKodePetugas(getKodePetugas());
        
        try {
            KeluhanDao.insert(con, keluhan);
            JOptionPane.showMessageDialog(view, "Entri Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error "+ex.getMessage()); 
        }
    }
    
    public void update() {
        keluhan = new Keluhan();
        keluhan.setKodeKeluhan(view.getTxtKodeKeluhan().getText());
        keluhan.setKodeList(getKodeList());
        keluhan.setKodePasien(getKodePasien());
        keluhan.setKodePetugas(getKodePetugas());
        
        try {
            KeluhanDao.update(con, keluhan);
            JOptionPane.showMessageDialog(view, "Update Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error " + ex.getMessage());
        }
    }
    
    public void delete(){
        try {
            KeluhanDao.delete(con, keluhan);
            JOptionPane.showMessageDialog(view, "Delete Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error " + ex.getMessage());
        }
    }*/

}
