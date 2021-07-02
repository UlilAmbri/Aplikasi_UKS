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
public class User {
    private int id_user;
    private String username;
    private String password;
    private String akses;
    
    public int getIdUser(){
        return id_user;
    }
    
    public void setIdUser(int id_user ){
        this.id_user = id_user;
    }
    
     public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getAkses(){
        return akses;
    }
    
    public void setAkses(String akses){
        this.akses = akses;
    }

}
