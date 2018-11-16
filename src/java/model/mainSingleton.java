/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nicolas SIBAUD
 */
public class mainSingleton {
    public static mainSingleton instance = null;
    private ListeClient listeClients = new ListeClient();
    
    public static mainSingleton getInstance()
    {
        if(instance == null)
        {
            instance = new mainSingleton();
        }
        return instance;
    }
    
    private mainSingleton()
    {  
    }
    
    public ListeClient getListeClient()
    {
        return this.listeClients;
    }
}
