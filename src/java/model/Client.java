package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class define a Client.
 * 
 * @author Nicolas SIBAUD
 */
@XmlRootElement
public class Client {
    
    /**
     * The client's ID.
     */
    private int id;
    
   /**
    * The client's firstname.
    */
    private String firstname;
   
    /**
    * The client's lastname.
    */
    private String lastname;
   
   /**
    * Client's default constructor.
    */
    public Client() {
    }
    
    
    /**
     * MUTATORS 
     */
    
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

   
    
   
}
