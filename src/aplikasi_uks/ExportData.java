/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_uks;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author User
 */
public class ExportData {
    FormExport view;
    Connection con;
    
    public ExportData(FormExport view) {
         try {
            this.view = view;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
            Clear();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    public void Clear(){
        view.getTxtExport().setText("");
    }

    public void inventaris(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/uks","root","");
            Statement statement = con.createStatement();
            FileOutputStream fileOut;
            fileOut = new FileOutputStream("D:\\Laporan Aplikasi UKS\\Laporan Data Inventaris\\Inventaris.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Sheet 0");
            Row row1 = worksheet.createRow((short)0);
            row1.createCell(0).setCellValue("kode inventaris");
            row1.createCell(1).setCellValue("tahun") ;
            row1.createCell(2).setCellValue("nama");
            row1.createCell(3).setCellValue("jumlah");
            row1.createCell(4).setCellValue("sumber");
            row1.createCell(5).setCellValue("keterangan");
            Row row2 ;
            ResultSet rs = statement.executeQuery("SELECT kode_inventaris,tahun,nama,jml,sumber,keterangan FROM t_inventaris ");
            while(rs.next()){
                int a = rs.getRow();
                row2 = worksheet.createRow((short)a);
                row2.createCell(0).setCellValue(rs.getString(1));
                row2.createCell(1).setCellValue(rs.getString(2));
                row2.createCell(2).setCellValue(rs.getString(3));
                row2.createCell(3).setCellValue(rs.getString(4));
                row2.createCell(4).setCellValue(rs.getString(5));
                row2.createCell(5).setCellValue(rs.getString(6));
                }
                workbook.write(fileOut);
                fileOut.flush();
                fileOut.close();
                rs.close();
                statement.close();
                con.close();
                JOptionPane.showMessageDialog(null,"Export Berhasil ! File Tersimpan Di Folder");
            }catch(ClassNotFoundException e){
                System.out.println(e);
            }catch(SQLException ex){
                System.out.println(ex);
            }catch(IOException ioe){
                System.out.println(ioe);
        }//JOptionPane.showMessageDialog(null,"Clear !");
    }
    
    public void pasien(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/uks","root","");
            Statement statement = con.createStatement();
            FileOutputStream fileOut;
            fileOut = new FileOutputStream("D:\\Laporan Aplikasi UKS\\Laporan Data Pasien\\Pasien.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Sheet 0");
            Row row1 = worksheet.createRow((short)0);
            row1.createCell(0).setCellValue("kode pasien") ;
            row1.createCell(1).setCellValue("nama");
            row1.createCell(2).setCellValue("status");
            row1.createCell(3).setCellValue("nis/nip");
            row1.createCell(4).setCellValue("tempat");
            row1.createCell(5).setCellValue("tanggal");
            row1.createCell(6).setCellValue("jenis kelamin");
            row1.createCell(7).setCellValue("no");
            row1.createCell(8).setCellValue("alamat");
            row1.createCell(9).setCellValue("golongan");
            row1.createCell(10).setCellValue("alergi");
            Row row2 ;
            ResultSet rs = statement.executeQuery("SELECT kode_pasien,nama,status,nis_nip,tempat,tgl,jekel,no,alamat,gol,alergi FROM t_pasien ");
            while(rs.next()){
                int a = rs.getRow();
                row2 = worksheet.createRow((short)a);
                row2.createCell(0).setCellValue(rs.getString(1));
                row2.createCell(1).setCellValue(rs.getString(2));
                row2.createCell(2).setCellValue(rs.getString(3));
                row2.createCell(3).setCellValue(rs.getString(4));
                row2.createCell(4).setCellValue(rs.getString(5));
                row2.createCell(5).setCellValue(rs.getString(6));
                row2.createCell(6).setCellValue(rs.getString(7));
                row2.createCell(7).setCellValue(rs.getString(8));
                row2.createCell(8).setCellValue(rs.getString(9));
                row2.createCell(9).setCellValue(rs.getString(10));
                row2.createCell(10).setCellValue(rs.getString(11));
                }
                workbook.write(fileOut);
                fileOut.flush();
                fileOut.close();
                rs.close();
                statement.close();
                con.close();
                JOptionPane.showMessageDialog(null,"Export Berhasil ! File Tersimpan Di Folder");
            }catch(ClassNotFoundException e){
                System.out.println(e);
            }catch(SQLException ex){
                System.out.println(ex);
            }catch(IOException ioe){
                System.out.println(ioe);
        }//JOptionPane.showMessageDialog(null,"Clear !");
    }
    public void petugas(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/uks","root","");
            Statement statement = con.createStatement();
            FileOutputStream fileOut;
            fileOut = new FileOutputStream("D:\\Laporan Aplikasi UKS\\Laporan Data Petugas\\Petugas.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Sheet 0");
            Row row1 = worksheet.createRow((short)0);
            row1.createCell(0).setCellValue("kode petugas") ;
            row1.createCell(1).setCellValue("nama");
            row1.createCell(2).setCellValue("alamat");
            row1.createCell(3).setCellValue("jenis kelmain");
            row1.createCell(4).setCellValue("no hp");
            Row row2 ;
            ResultSet rs = statement.executeQuery("SELECT kode_petugas,nama,alamat,jekel,no_hp FROM t_petugas ");
            while(rs.next()){
                int a = rs.getRow();
                row2 = worksheet.createRow((short)a);
                row2.createCell(0).setCellValue(rs.getString(1));
                row2.createCell(1).setCellValue(rs.getString(2));
                row2.createCell(2).setCellValue(rs.getString(3));
                row2.createCell(3).setCellValue(rs.getString(4));
                row2.createCell(4).setCellValue(rs.getString(5));
                }
                workbook.write(fileOut);
                fileOut.flush();
                fileOut.close();
                rs.close();
                statement.close();
                con.close();
                JOptionPane.showMessageDialog(null,"Export Berhasil ! File Tersimpan Di Folder");
            }catch(ClassNotFoundException e){
                System.out.println(e);
            }catch(SQLException ex){
                System.out.println(ex);
            }catch(IOException ioe){
                System.out.println(ioe);
        }//JOptionPane.showMessageDialog(null,"Clear !");
    }
    public void rekammedis(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/uks","root","");
            Statement statement = con.createStatement();
            FileOutputStream fileOut;
            fileOut = new FileOutputStream("D:\\Laporan Aplikasi UKS\\Laporan Data Rekam Medis\\RekamMedis.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Sheet 0");
            Row row2 = worksheet.createRow((short)0);
            row2.createCell(0).setCellValue("kode periksa") ;
            row2.createCell(1).setCellValue("keluhan 1");
            row2.createCell(2).setCellValue("keluhan 2");
            row2.createCell(3).setCellValue("keluhan 3");
            row2.createCell(4).setCellValue("obat 1");
            row2.createCell(5).setCellValue("obat 2");
            row2.createCell(6).setCellValue("obat 3");
//            row2.createCell(3).setCellValue("kode pasien");
//            row2.createCell(4).setCellValue("kode petugas");
            row2.createCell(7).setCellValue("diagnosa");
            Row row3 ;
            ResultSet rs = statement.executeQuery("SELECT kode_periksa, "
                    + "t_keluhan.kode_list, t_keluhan.kode_list_1, t_keluhan.kode_list_2, "
                    + "t_ambilobat.obat, t_ambilobat.obat1, t_ambilobat.obat2 ,"
                    + "diagnosa FROM t_pemeriksaan join t_keluhan using (kode_keluhan) join t_ambilobat using (kode_ambilobat)");
            while(rs.next()){
                int a = rs.getRow();
                row3 = worksheet.createRow((short)a);
                row3.createCell(0).setCellValue(rs.getString(1));
                row3.createCell(1).setCellValue(rs.getString(2));
                row3.createCell(2).setCellValue(rs.getString(3));
                row3.createCell(3).setCellValue(rs.getString(4));
                row3.createCell(4).setCellValue(rs.getString(5));
                row3.createCell(5).setCellValue(rs.getString(6));
                row3.createCell(6).setCellValue(rs.getString(7));
                row3.createCell(7).setCellValue(rs.getString(8));
                }
                workbook.write(fileOut);
                fileOut.flush();
                fileOut.close();
                rs.close();
                statement.close();
                con.close();
                JOptionPane.showMessageDialog(null,"Export Berhasil ! File Tersimpan Di Folder");
            }catch(ClassNotFoundException e){
                System.out.println(e);
            }catch(SQLException ex){
                System.out.println(ex);
            }catch(IOException ioe){
                System.out.println(ioe);
        }
        //JOptionPane.showMessageDialog(null,"Clear !");
    }
 
    
    public void viewTable1(){
        try {
            DefaultTableModel tabelModel =
                    (DefaultTableModel) view.getTabelExport().getModel();
            tabelModel.setRowCount(0);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/uks","root","");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM t_inventaris");
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
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void viewTable2(){
        try {
            DefaultTableModel tabelModel =
                    (DefaultTableModel) view.getTabelExport().getModel();
            tabelModel.setRowCount(0);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/uks","root","");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM t_pasien");
            while(rs.next()){
                Object[] data={
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11)
                };
                tabelModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void viewTable3(){
        try {
            DefaultTableModel tabelModel =
                    (DefaultTableModel) view.getTabelExport().getModel();
            tabelModel.setRowCount(0);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/uks","root","");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM t_petugas");
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
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void viewTable4(){
        try {
            DefaultTableModel tabelModel =
                    (DefaultTableModel) view.getTabelExport().getModel();
            tabelModel.setRowCount(0);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/uks","root","");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT kode_periksa, "
                    + "t_keluhan.kode_list, t_keluhan.kode_list_1, t_keluhan.kode_list_2, "
                    + "t_ambilobat.obat, t_ambilobat.obat1, t_ambilobat.obat2 ,"
                    + "diagnosa FROM t_pemeriksaan join t_keluhan using (kode_keluhan) join t_ambilobat using (kode_ambilobat)");
            while(rs.next()){
                Object[] data={
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
                };
                tabelModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
