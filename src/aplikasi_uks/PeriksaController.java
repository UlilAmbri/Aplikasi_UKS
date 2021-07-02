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
public class PeriksaController {
    FormPeriksa view;
    FormPeriksa viewR;
    FormLaporanRekamMedis formLaporanRekamMedis;
    //FormLaporanInventaris formLaporanIventaris;
    Periksa periksa;   //model
    Keluhan keluhan;
    AmbilObat ambilobat;
    AnggotaDao anggotadao = new AnggotaDao();
    PetugasDao petugasdao = new PetugasDao();
    KeluhanDao keluhandao = new KeluhanDao();
    ListKeluhanDao listkeluhandao = new ListKeluhanDao();
    AmbilObatDao ambilobatdao = new AmbilObatDao();
    //Keluhan keluhan;
    Connection con;
   
     public PeriksaController(FormPeriksa view) {
        try {
            this.view = view;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
            clearForm();
            viewTable();
            viewTable1();
            System.out.print(keluhandao.getKodeKeluhan(con));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PeriksaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PeriksaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public PeriksaController(FormLaporanRekamMedis formLaporanRekamMedis) {
        try {
            this.formLaporanRekamMedis = formLaporanRekamMedis;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
            //clearForm();
            //viewTable();
            System.out.print(keluhandao.getKodeKeluhan(con));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PeriksaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PeriksaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      /*public PeriksaController(FormLaporanInventaris formLaporanInventaris) {
        try {
            this.formLaporanIventaris = formLaporanInventaris;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
            clearForm();
            viewTable();
            System.out.print(keluhandao.getKodeKeluhan(con));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PeriksaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PeriksaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    
    public void clearForm(){
        view.getTxtKodePeriksa().setText("");
        view.getTxtKodePasien().setText("");
        view.getTxtNamaPasien().setText("");
        view.getTxtKodePetugas().setText("");
        view.getTxtNamaPetugas().setText("");
        view.getTxtKodeKeluhan().setText("");
        view.getTxtNamaKeluhan().setText("");
        view.getTxtKodeKeluhan2().setText("");
        view.getTxtNamaKeluhan2().setText("");
        view.getTxtKodeKeluhan3().setText("");
        view.getTxtNamaKeluhan3().setText("");
        view.getTxtDiagnosa().setText("");
        view.getTxtObat().setText("");
        view.getTxtObat1().setText("");
        view.getTxtObat2().setText("");
        view.getTxtNama().setText("");
        view.getTxtNama1().setText("");
        view.getTxtNama2().setText("");
        
    }
    
    
    public void viewTable(){
        try {
            DefaultTableModel tabelModel =
                    (DefaultTableModel) view.getTabelPeriksa().getModel();
            tabelModel.setRowCount(0);
            ResultSet rs = con.createStatement().executeQuery("select * from t_pemeriksaan");
            while(rs.next()){
                Object[] data={
                    rs.getString(1),
                    keluhandao.getKeluhanText(con,rs.getString(2)),
                    ambilobatdao.getObatText(con,rs.getString(3)),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
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
                    (DefaultTableModel) view.getTabelKeluhan().getModel();
            tabelModel.setRowCount(0);
            ResultSet rs = con.createStatement().executeQuery("select * from t_listkeluhan");
            ResultSet rs1 = con.createStatement().executeQuery("select * from t_pasien");
            ResultSet rs2 = con.createStatement().executeQuery("select * from t_petugas");
            ResultSet rs3 = con.createStatement().executeQuery("select * from t_stokobat");
            while(rs.next() && rs1.next() && rs2.next() && rs3.next()){
                Object[] data={
                    rs.getString(1),
                    rs.getString(2),
                    rs1.getString(1),
                    rs1.getString(2),
                    rs2.getString(1),
                    rs2.getString(2),
                    rs3.getString(1),
                    rs3.getString(2)
                };
                tabelModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*public void isiCboKodeObat(){
        view.getCboKode1().removeAllItems();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from t_stokobat");
            while (rs.next()) {                
                view.getCboKode1().addItem(rs.getString(1)+"-"+rs.getString(2)); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void isiCboKodeObat1(){
        view.getCboKode2().removeAllItems();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from t_stokobat");
            while (rs.next()) {                
                view.getCboKode2().addItem(rs.getString(1)+"-"+rs.getString(2)); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void isiCboKodeObat2(){
        view.getCboKode().removeAllItems();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from t_stokobat");
            while (rs.next()) {                
                view.getCboKode().addItem(rs.getString(1)+"-"+rs.getString(2)); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getKodeObat(){
        String[] s = view.getCboKode().getSelectedItem().toString().split("-");
        return s[0];
    }
    
    public String getKodeObat1(){
        String[] s = view.getCboKode().getSelectedItem().toString().split("-");
        return s[0];
    }
    
    public String getKodeObat2(){
        String[] s = view.getCboKode().getSelectedItem().toString().split("-");
        return s[0];
    }*/
    
    public void onKeyPressKodePasien(){
        String kode = view.getTxtKodePasien().getText();
        System.out.print(kode);
        try {
            Anggota anggota = AnggotaDao.getAnggota(con, kode);
            view.getTxtNamaPasien().setText(anggota.getNama());
            System.out.print(anggota.getNama());
            view.getTxtKodePetugas().requestFocus();
        } catch (SQLException | NullPointerException e){
            System.out.print("/");
            //JOptionPane.showMessageDialog(view, "Data tidak ada");
        }
    }
    
    public void onKeyPressKodePetugas(){
        String kodekeluhan = view.getTxtKodeKeluhan().getText();
        String kodeanggota = view.getTxtKodePasien().getText();
        String kodepetugas = view.getTxtKodePetugas().getText();
        System.out.print(kodepetugas);
        try {
            //view.getTxtKodePeriksa().setText(String.valueOf(periksa.getKodePeriksa()));
            Petugas petugas = PetugasDao.getPetugas(con, kodepetugas);
            
            System.out.print(petugas.getNama());
            view.getTxtNamaPetugas().setText(petugas.getNama());
            //Keluhan keluhan = KeluhanDao.getKeluhan(con, kodekeluhan);
            //.getTxtKodePeriksa().setText(String.valueOf(periksa.getKodePeriksa()));
            //view.getTxtDiagnosa().setText(String.valueOf(periksa.getDiagnosa()));
            
            
        } catch (SQLException | NullPointerException e){
            System.out.print("/");
            //JOptionPane.showMessageDialog(view, "Data tidak ada\nWalaupun data terisi, tapi tidak ada pasien yang membuat keluhan");
        }
    }
    
    /*public void onKeyPressKodePetugas(){
        String kode = view.getTxtKodePetugas().getText();
        try {
            Petugas petugas = PetugasDao.getPetugas(con, kode);
            view.getTxtNamaPetugas().setText(petugas.getNama());
            view.getTxtKodeKeluhan().requestFocus();
        } catch (SQLException | NullPointerException e){
            JOptionPane.showMessageDialog(view, "Data tidak ada");
        }
    }*/
    
    public void onKeyPressKodeKeluhan(){
        String kode = view.getTxtKodeKeluhan().getText();
        System.out.print(kode);
        try {
            ListKeluhan listkeluhan = ListKeluhanDao.getListKeluhan(con, kode);
            //Keluhan keluhan = KeluhanDao.getKeluhan(con,kode);
            view.getTxtNamaKeluhan().setText(listkeluhan.getKeluhan());
            view.getTxtKodePasien().requestFocus();
        } catch (SQLException | NullPointerException e){
            System.out.print("/");
            //JOptionPane.showMessageDialog(view, "Data tidak ada");
        }
    }
    
    public void onKeyPressKodeKeluhan2(){
        String kode = view.getTxtKodeKeluhan2().getText();
        System.out.print(kode);
        try {
            ListKeluhan listkeluhan = ListKeluhanDao.getListKeluhan(con, kode);
            //Keluhan keluhan = KeluhanDao.getKeluhan(con,kode);
            view.getTxtNamaKeluhan2().setText(listkeluhan.getKeluhan());
            view.getTxtKodePasien().requestFocus();
        } catch (SQLException | NullPointerException e){
            System.out.print("/");
            //JOptionPane.showMessageDialog(view, "Data tidak ada");
        }
    }
    
    public void onKeyPressKodeKeluhan3(){
        String kode = view.getTxtKodeKeluhan3().getText();
        System.out.print(kode);
        try {
            ListKeluhan listkeluhan = ListKeluhanDao.getListKeluhan(con, kode);
            //Keluhan keluhan = KeluhanDao.getKeluhan(con,kode);
            view.getTxtNamaKeluhan3().setText(listkeluhan.getKeluhan());
            view.getTxtKodePasien().requestFocus();
        } catch (SQLException | NullPointerException e){
            System.out.print("/");
            //JOptionPane.showMessageDialog(view, "Data tidak ada");
        }
    }
    
    public void onKeyPressKodeObat(){
        String kode = view.getTxtObat().getText();
        System.out.print(kode);
        try {
            Obat obat = ObatDao.getObat(con, kode);
            //Keluhan keluhan = KeluhanDao.getKeluhan(con,kode);
            view.getTxtNama().setText(obat.getNama());
            view.getTxtObat1().requestFocus();
        } catch (SQLException | NullPointerException e){
            System.out.print("/");
            //JOptionPane.showMessageDialog(view, "Data tidak ada");
        }
    }
    
    public void onKeyPressKodeObat1(){
        String kode = view.getTxtObat1().getText();
        System.out.print(kode);
        try {
            Obat obat = ObatDao.getObat(con, kode);
            //Keluhan keluhan = KeluhanDao.getKeluhan(con,kode);
            view.getTxtNama1().setText(obat.getNama());
            view.getTxtObat2().requestFocus();
        } catch (SQLException | NullPointerException e){
            System.out.print("/");
            //JOptionPane.showMessageDialog(view, "Data tidak ada");
        }
    }
    
    public void onKeyPressKodeObat2(){
        String kode = view.getTxtObat2().getText();
        System.out.print(kode);
        try {
            Obat obat = ObatDao.getObat(con, kode);
            //Keluhan keluhan = KeluhanDao.getKeluhan(con,kode);
            view.getTxtNama2().setText(obat.getNama());
            view.getTxtObat1().requestFocus();
        } catch (SQLException | NullPointerException e){
            System.out.print("/");
            //JOptionPane.showMessageDialog(view, "Data tidak ada");
        }
    }
    
    public void onClickTabel() {
        clearForm();
        try {
            String kode_ang = view.getTabelPeriksa().getValueAt(view.getTabelPeriksa().getSelectedRow(), 0).toString();
            String kode_pe = view.getTabelPeriksa().getValueAt(view.getTabelPeriksa().getSelectedRow(), 1).toString();
            String kode_ke = view.getTabelPeriksa().getValueAt(view.getTabelPeriksa().getSelectedRow(), 2).toString();
            String kode_a = view.getTabelPeriksa().getValueAt(view.getTabelPeriksa().getSelectedRow(), 3).toString();
            String kode_b = view.getTabelPeriksa().getValueAt(view.getTabelPeriksa().getSelectedRow(), 4).toString();
            String kode_k = view.getTabelPeriksa().getValueAt(view.getTabelPeriksa().getSelectedRow(), 5).toString();
            Anggota anggota = AnggotaDao.getAnggota(con, kode_a);
            Petugas petugas = PetugasDao.getPetugas(con, kode_b);
            periksa = PeriksaDao.getPeriksa(con, kode_ang);
            if (periksa != null) {
                view.getTxtKodePeriksa().setText(periksa.getKodePeriksa());
                view.getTxtKodePasien().setText(periksa.getKodePasien());
                view.getTxtNamaPasien().setText(anggota.getNama());
                view.getTxtKodePetugas().setText(periksa.getKodePetugas());
                view.getTxtNamaPetugas().setText(petugas.getNama());
                Keluhan keluhan = keluhandao.getKeluhan(con,periksa.getKodeKeluhan());
                ListKeluhan babi1 = ListKeluhanDao.getListKeluhan(con,keluhan.getKodeList());
                view.getTxtKodeKeluhan().setText(babi1.getKodeList());
                view.getTxtNamaKeluhan().setText(babi1.getKeluhan());
                
                try{
                    ListKeluhan b2 = ListKeluhanDao.getListKeluhan(con,keluhan.getKodeList1());
                    view.getTxtKodeKeluhan2().setText(b2.getKodeList());
                    view.getTxtNamaKeluhan2().setText(b2.getKeluhan());
                }
                catch (Exception e){
                    view.getTxtKodeKeluhan2().setText("");
                    view.getTxtNamaKeluhan2().setText("");
                }
                try{
                    ListKeluhan b3 = ListKeluhanDao.getListKeluhan(con,keluhan.getKodeList2());
                    view.getTxtKodeKeluhan3().setText(b3.getKodeList());
                    view.getTxtNamaKeluhan3().setText(b3.getKeluhan());
                }
                catch (Exception e){
                    view.getTxtKodeKeluhan3().setText("");
                    view.getTxtNamaKeluhan3().setText("");
                }
                
                
                AmbilObat ambil = ambilobatdao.getObat(con,periksa.getKodeObat());
                view.getTxtObat().setText(ambil.getObat());
                Obat obat1 = ObatDao.getObat(con, ambil.getObat());
                view.getTxtNama().setText(obat1.getNama());
                
                try{
                    view.getTxtObat1().setText(ambil.getObat1());
                    Obat obat2 = ObatDao.getObat(con, ambil.getObat1());
                    view.getTxtNama1().setText(obat2.getNama());
                }
                catch (Exception e){
                    view.getTxtObat1().setText("");
                    view.getTxtNama1().setText("");
                }
                
                try{
                    view.getTxtObat2().setText(ambil.getObat2());
                    Obat obat3 = ObatDao.getObat(con, ambil.getObat2());
                    view.getTxtNama2().setText(obat3.getNama());
                }
                catch (Exception e){
                    view.getTxtObat2().setText("");
                    view.getTxtNama2().setText("");
                }
                
                
                
                
                //view.getTxtNamaKeluhan().setText(listkeluhandao.getListKeluhan(con,kode_ke).getKeluhan());
                view.getTxtDiagnosa().setText(kode_k);
                
            } else {
                javax.swing.JOptionPane.showMessageDialog(view, "Data Tidak Ada"+ kode_ang+"/"+kode_pe+"/"+kode_ke+"/");
                clearForm();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void previewRekamMedis() {
        HashMap parameter = new HashMap();
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport("report/RekamMedis2.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.print(ex.toString());
            //Logger.getLogger(formlaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*public void previewTahunInventaris() {
        HashMap parameter = new HashMap();
        parameter.put("tahun", formLaporanInventaris.getCboTahun().getSelectedItem().toString());
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport("report/inventaris_tahun.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.print(ex.toString());
            //Logger.getLogger(formlaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    public void insert(){
        //System.out.println("AAAAAAAA"+view.getTxtKodeKeluhan().getText());
        //Keluhan keluhan;
        Keluhan keluhan = new Keluhan();
        AmbilObat ambilobat = new AmbilObat();
        ObatDao obatdao = new ObatDao();
        try{
            //keluhan.setKodeKeluhan("1");
            System.out.println("A");
            keluhan.setKodeList(view.getTxtKodeKeluhan().getText());
            System.out.println("B");
            keluhan.setKodeList1(view.getTxtKodeKeluhan2().getText());
            System.out.println("C");
            keluhan.setKodeList2(view.getTxtKodeKeluhan3().getText());
            System.out.println("D");
            //ambilobat.setKodeAmbilObat("1");
            ambilobat.setObat(view.getTxtObat().getText());
            System.out.println("A");
            ambilobat.setObat1(view.getTxtObat1().getText());
            System.out.println("B");
            ambilobat.setObat2(view.getTxtObat2().getText());
            System.out.println("C");
            ambilobat.setNama(Integer.parseInt(view.getTxtNama().getText()));
            System.out.println("D");
            try{
                ambilobat.setNama1(Integer.parseInt(view.getTxtNama1().getText()));
                System.out.println("A");
            }catch(Exception e){
                ambilobat.setNama1(0);
                //System.out.println("A");
            }
            try{
                ambilobat.setNama2(Integer.parseInt(view.getTxtNama2().getText()));
                System.out.println("A");
            }catch(Exception e){
                ambilobat.setNama1(0);
                //System.out.println("A");
            }
            
            try{
               System.out.print(111111111);
               obatdao.updateObat(con,view.getTxtObat().getText(),Integer.parseInt(view.getTxtNama().getText()));
               System.out.print(22222222);
               obatdao.updateObat(con,view.getTxtObat1().getText(),Integer.parseInt(view.getTxtNama1().getText()));
               System.out.print(3333333);
               obatdao.updateObat(con,view.getTxtObat2().getText(),Integer.parseInt(view.getTxtNama2().getText()));
            }catch(Exception e){
                System.out.print(e);
            }
            
        }catch(Exception e){
            System.out.print(e);
        }
        System.out.println("A");
        periksa = new Periksa();
        periksa.setKodePeriksa(view.getTxtKodePeriksa().getText());
        periksa.setKodePasien(view.getTxtKodePasien().getText());
        periksa.setKodePetugas(view.getTxtKodePetugas().getText());
        periksa.setDiagnosa(view.getTxtDiagnosa().getText());
        System.out.println("B");
        
        
        try {
            System.out.println("C");
            keluhandao.insert(con, keluhan);
            System.out.println("D");
            ambilobatdao.insert(con,ambilobat);
            System.out.println("E");
            periksa.setKodeKeluhan(keluhandao.getKodeKeluhan(con));
            System.out.println("F");
            periksa.setKodeObat(ambilobatdao.getKodeObat(con));
            System.out.println("G");
            PeriksaDao.insert(con, periksa);
            System.out.println("H");
            JOptionPane.showMessageDialog(view, "Entri Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error "+ex.getMessage()); 
        }
        viewTable();
    }
    
//    public void update() {
//       Keluhan keluhan = new Keluhan();
//        AmbilObat ambilobat = new AmbilObat();
//        ObatDao obatdao = new ObatDao();
//        try{
//            //keluhan.setKodeKeluhan("1");
//            System.out.println("A");
//            keluhan.setKodeList(view.getTxtKodeKeluhan().getText());
//            System.out.println("B");
//            keluhan.setKodeList1(view.getTxtKodeKeluhan2().getText());
//            System.out.println("C");
//            keluhan.setKodeList2(view.getTxtKodeKeluhan3().getText());
//            System.out.println("D");
//            //ambilobat.setKodeAmbilObat("1");
//            ambilobat.setObat(view.getTxtObat().getText());
//            System.out.println("A");
//            ambilobat.setObat1(view.getTxtObat1().getText());
//            System.out.println("B");
//            ambilobat.setObat2(view.getTxtObat2().getText());
//            System.out.println("C");
//            ambilobat.setNama(Integer.parseInt(view.getTxtNama().getText()));
//            System.out.println("D");
//            try{
//                ambilobat.setNama1(Integer.parseInt(view.getTxtNama1().getText()));
//                System.out.println("A");
//            }catch(Exception e){
//                ambilobat.setNama1(0);
//                //System.out.println("A");
//            }
//            try{
//                ambilobat.setNama2(Integer.parseInt(view.getTxtNama2().getText()));
//                System.out.println("A");
//            }catch(Exception e){
//                ambilobat.setNama1(0);
//                //System.out.println("A");
//            }
//            
//            try{
//               System.out.print(111111111);
//               obatdao.updateObat(con,view.getTxtObat().getText(),Integer.parseInt(view.getTxtNama().getText()));
//               System.out.print(22222222);
//               obatdao.updateObat(con,view.getTxtObat1().getText(),Integer.parseInt(view.getTxtNama1().getText()));
//               System.out.print(3333333);
//               obatdao.updateObat(con,view.getTxtObat2().getText(),Integer.parseInt(view.getTxtNama2().getText()));
//            }catch(Exception e){
//                System.out.print(e);
//            }
//            
//        }catch(Exception e){
//            System.out.print(e);
//        }
//        System.out.println("A");
//        periksa = new Periksa();
//        periksa.setKodePeriksa(view.getTxtKodePeriksa().getText());
//        periksa.setKodePasien(view.getTxtKodePasien().getText());
//        periksa.setKodePetugas(view.getTxtKodePetugas().getText());
//        periksa.setDiagnosa(view.getTxtDiagnosa().getText());
//        System.out.println("B");
//        
//        
//        try {
//            System.out.println("C");
//            keluhandao.insert(con, keluhan);
//            System.out.println("D");
//            ambilobatdao.insert(con,ambilobat);
//            System.out.println("E");
//            periksa.setKodeKeluhan(keluhandao.getKodeKeluhan(con));
//            System.out.println("F");
//            periksa.setKodeObat(ambilobatdao.getKodeObat(con));
//            System.out.println("G");
//            PeriksaDao.insert(con, periksa);
//            System.out.println("H");
//            JOptionPane.showMessageDialog(view, "Entri Data Ok");
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(view, "Error "+ex.getMessage()); 
//        }
//        viewTable();
//    }
    
    public void delete(){
        try {
            Periksa periksa = PeriksaDao.getPeriksa(con, view.getTxtKodePeriksa().getText());
            
            PeriksaDao.delete(con, periksa);
            JOptionPane.showMessageDialog(view, "Delete Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error " + ex.getMessage());
        }
    }
}
