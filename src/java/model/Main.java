/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nicol
 */
public class Main {
    public static void main (String [] args){
        Client c = new Client();
        c.setFirstname("lkjlk");
        c.setLastname("dddd");
        c.setId(1);
        
        mainSingleton.getInstance().getListeClient().ajouterClientDansListe(c);
        
        mainSingleton.getInstance().getListeClient().modifierClient(1, "nbi", "hkjhjk");
        
        System.out.println(c);              
        
        
    }
    
}
