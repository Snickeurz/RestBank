package model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class define a collection of client.
 * 
 * @author Nicolas SIBAUD
 */
@XmlRootElement
public class ListeClient {
    /**
     * A collection of Client.
     */
    @XmlElement(name="clients")
    private List<Client> clients = new ArrayList<>();

    public ListeClient() {
    }
    /**
     * Add a client into the ArrayList of Client.
     * 
     * @param c an isntance of Client
     * @return true if the client is added, else return false
     */
    public boolean ajouterClientDansListe(Client c)
    {
        return clients.add(c);
    }
    
    /**
     * Update a Client in ArrayList.
     * 
     * @param id the client's id to search
     * @param firstname the new client's firstname
     * @param lastname the new client's lastname
     * @return true if update is ok else return false
     */
    public boolean modifierClient(int id, String firstname, String lastname)
    {
        Client c = consulterClient(id);
        if(c == null){
            return false;
        }
        System.out.println("modelfgfdg");
        c.setFirstname(firstname);
        c.setLastname(lastname);
       return true;
    }
    
    /**
     * Get a Client contained in ArrayList.
     * 
     * @param id the client's id
     * @return a Client
     */
    public Client consulterClient(int id)
    {
        for(Client c : clients)
        {
            if(c.getId()== id)
            {
                return c;
            }
        }
        return null;
    }
    
    /**
     * Get informations from all Clients from ArrayList.
     * 
     * @return Client's information
     */
    /*public List<Client> consulterListeClient()
    {
        return this.clients;
    }*/
    
    /**
     * Delete a Client in ArrayList.
     * 
     * @param id the client's id
     * @return true if the Client is successfully removed from list, else return false
     */
    public boolean supprimerClient(int id)
    {
        Client c = this.consulterClient(id);
        if(c!=null)
        {
            this.clients.remove(c);
            return true;
        }
        return false;
    }
}
