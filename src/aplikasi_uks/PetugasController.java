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
public class PetugasController {
    FormInsertPetugas view;
    FormDataPetugas viewR;
    FormLaporanDataPetugas formLaporanDataPetugas;
    Petugas petugas;   //model
    Connection con;
    
    public PetugasController(FormInsertPetugas view) {
        try {
            this.view = view;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
            clearForm();
            viewTable();
            isiComboJekel();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObatController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ObatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public PetugasController(FormDataPetugas viewR) {
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
    
    public PetugasController(FormLaporanDataPetugas formLaporanDataPetugas) {
        this.formLaporanDataPetugas = formLaporanDataPetugas;
        Koneksi k = new Koneksi();
        try {
            con = k.getKoneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clearForm(){
        view.getTxtKode().setText("");
        view.getTxtNama().setText("");
        view.getTxtAlamat().setText("");
        view.getTxtNo_hp().setText("");
    }
    
    public void isiComboJekel(){
        view.getCboJekel().removeAllItems();
        view.getCboJekel().addItem("-");
        view.getCboJekel().addItem("L");
        view.getCboJekel().addItem("P");
    }
    
    public void viewTable(){
        try {
            DefaultTableModel tabelModel =
                    (DefaultTableModel) view.getTabelPetugas().getModel();
            tabelModel.setRowCount(0);
            ResultSet rs = con.createStatement().executeQuery("select * from t_petugas");
            while(rs.next()){
                Object[] data={
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                };
                tabelModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void viewTable1(){
        try {
            DefaultTableModel tabelModel =
                    (DefaultTableModel) viewR.getTabelPetugas().getModel();
            tabelModel.setRowCount(0);
            ResultSet rs = con.createStatement().executeQuery("select * from t_petugas");
            while(rs.next()){
                Object[] data={
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                };
                tabelModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onClickTabel() {
        try {
            String kode = view.getTabelPetugas().getValueAt(view.getTabelPetugas().getSelectedRow(), 0).toString();
            petugas = PetugasDao.getPetugas(con, kode);
            if (petugas != null) {
                view.getTxtKode().setText(petugas.getKodePetugas());
                view.getTxtNama().setText(petugas.getNama());
                view.getTxtAlamat().setText(petugas.getAlamat());
                view.getCboJekel().setSelectedItem(petugas.getJekel());
                view.getTxtNo_hp().setText(petugas.getNo_hp());
            } else {
                javax.swing.JOptionPane.showMessageDialog(view, "Data Tidak Ada");
                clearForm();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void previewPetugas() {
        HashMap parameter = new HashMap();
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport("report/petugas1.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.print(ex.toString());
            //Logger.getLogger(formlaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void previewDataPetugasJekel() {
        HashMap parameter = new HashMap();
        parameter.put("jekel", formLaporanDataPetugas.getCboJekel().getSelectedItem().toString());
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport("report/petugas_jekel1.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.print(ex.toString());
            //Logger.getLogger(formlaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(){
        petugas = new Petugas();
        petugas.setKodePetugas(view.getTxtKode().getText());
        petugas.setNama(view.getTxtNama().getText());
        petugas.setAlamat(view.getTxtAlamat().getText());
        petugas.setJekel(view.getCboJekel().getSelectedItem().toString());
        petugas.setNo_hp(view.getTxtNo_hp().getText());
        
        try {
            PetugasDao.insert(con, petugas);
            JOptionPane.showMessageDialog(view, "Entri Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error "+ex.getMessage()); 
        }
    }
    
    public void update() {
        petugas = new Petugas();
        petugas.setKodePetugas(view.getTxtKode().getText());
        petugas.setNama(view.getTxtNama().getText());
        petugas.setAlamat(view.getTxtAlamat().getText());
        petugas.setJekel(view.getCboJekel().getSelectedItem().toString());
        petugas.setNo_hp(view.getTxtNo_hp().getText());
        
        try {
            PetugasDao.update(con, petugas);
            JOptionPane.showMessageDialog(view, "Update Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error " + ex.getMessage());
        }
    }
    
    public void delete(){
        //JOptionPane.showMessageDialog(view, "Yakin Ingin Hapus Data ?", "Hapus", JOptionPane.YES_NO_OPTION);
                
            
        try {
            PetugasDao.delete(con, petugas);
            JOptionPane.showMessageDialog(view, "Delete Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error " + ex.getMessage());
        }
    }
}
