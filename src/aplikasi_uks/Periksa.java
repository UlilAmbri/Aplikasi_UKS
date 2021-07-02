/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_uks;

/**
 *
 * @author User
 */
public class Periksa {
    private String kode_periksa;
    private String kode_pasien;
    private String kode_petugas;
    private String kode_keluhan;
    private String diagnosa;
    private String kode_obat;
    
    public String getKodePeriksa(){
        return kode_periksa;
    }
    
    public void setKodePeriksa(String kode_periksa){
        this.kode_periksa = kode_periksa;
    }
    
    public String getKodePasien(){
        return kode_pasien;
    }
    
    public void setKodePasien(String kode_pasien){
        this.kode_pasien = kode_pasien;
    }
    
    public String getKodePetugas(){
        return kode_petugas;
    }
    
    public void setKodePetugas(String kode_petugas){
        this.kode_petugas = kode_petugas;
    }
    
    public String getKodeKeluhan(){
        return kode_keluhan;
    }
    
    public void setKodeKeluhan(String kode_keluhan){
        this.kode_keluhan = kode_keluhan;
    }
    
    public String getDiagnosa(){
        return diagnosa;
    }
    
    public void setDiagnosa(String diagnosa){
        this.diagnosa = diagnosa;
    }
    
    public String getKodeObat(){
        return kode_obat;
    }
    
    public void setKodeObat(String kode_obat){
        this.kode_obat = kode_obat;
    }
    
}
