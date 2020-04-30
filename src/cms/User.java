/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms;


public class User {
  
   
    String username;
    int password ;
    boolean isAdmin,isActive;

    public User(String username, int password, boolean isAdmin, boolean isActive) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isActive = isActive;
    }
    
    
    
    
}
