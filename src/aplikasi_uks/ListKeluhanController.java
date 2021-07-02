/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_uks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class ListKeluhanController {
    FormListKeluhan view;
    FormKeluhan viewR;
    FormListKeluhan formListKeluhan;
    ListKeluhan listkeluhan;   //model
    Connection con;
    
    public ListKeluhanController(FormListKeluhan view) {
        try {
            this.view = view;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
            clearForm();
            viewTable();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListKeluhanController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListKeluhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ListKeluhanController(FormKeluhan viewR) {
        try {
            this.viewR = viewR;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
            viewTable1();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PetugasController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PetugasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void clearForm(){
        view.getTxtKode().setText("");
        view.getTxtKeluhan().setText("");
    }
    
    
    public void viewTable(){
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
    
    public void viewTable1(){
        try {
            DefaultTableModel tabelModel =
                    (DefaultTableModel) viewR.getTabelListKeluhan().getModel();
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
    
    public void onClickTabel() {
        try {
            String kode = view.getTabelListKeluhan().getValueAt(view.getTabelListKeluhan().getSelectedRow(), 0).toString();
            listkeluhan = ListKeluhanDao.getListKeluhan(con, kode);
            if (listkeluhan != null) {
                view.getTxtKode().setText(listkeluhan.getKodeList());
                view.getTxtKeluhan().setText(listkeluhan.getKeluhan());
            } else {
                javax.swing.JOptionPane.showMessageDialog(view, "Data Tidak Ada");
                clearForm();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(){
        listkeluhan = new ListKeluhan();
        listkeluhan.setKodeList(view.getTxtKode().getText());
        listkeluhan.setKeluhan(view.getTxtKeluhan().getText());
        
        try {
            ListKeluhanDao.insert(con, listkeluhan);
            JOptionPane.showMessageDialog(view, "Entri Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error "+ex.getMessage()); 
        }
    }
    
    public void update() {
        listkeluhan = new ListKeluhan();
        listkeluhan.setKodeList(view.getTxtKode().getText());
        listkeluhan.setKeluhan(view.getTxtKeluhan().getText());
        
        try {
            ListKeluhanDao.update(con, listkeluhan);
            JOptionPane.showMessageDialog(view, "Update Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error " + ex.getMessage());
        }
    }
    
    public void delete(){
        try {
            ListKeluhanDao.delete(con, listkeluhan);
            JOptionPane.showMessageDialog(view, "Delete Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error " + ex.getMessage());
        }
    }
}
