package rest;


import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import model.Client;
import model.ListeClient;
import model.mainSingleton;

/**
 * REST Web Service
 *
 * @author Nicolas SIBAUD
 */
@Path("/rest")
public class GenericResource {
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of rest.GenericResource for a Client.
     * 
     * @param id the client's id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/consulterClient/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public String consulterClient(
            @PathParam("id") int id
    )
    {
        Client c  = mainSingleton.getInstance().getListeClient().consulterClient(id);
        return "<informations>"
                + "<id>" + c.getId() + "</id>"
                + "<nom>" + c.getLastname() + "</nom>"
                + "<prenom>" + c.getFirstname() + "</prenom>"
                + "</informations>";
    }
    
    /**
     * Get all Clients from listeClient.
     * 
     * @return all informations of all clients
     */
    @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_XML)
    public ListeClient getAll()
    {
        return mainSingleton.getInstance().getListeClient();
    }
    
    @POST
    @Path("create")
    public String create(Client c)
    {
        if(mainSingleton.getInstance().getListeClient().ajouterClientDansListe(c))
        {
            return "<create>Insertion OK. Recapitulatif : " + 
                    "\n"+this.consulterClient(c.getId()) + "</create>";   
        }
        return "<create>Probleme lors de l'ajout du client</create>";
    }
    
    @POST
    @Path("update")
    @Produces(MediaType.APPLICATION_XML)
    
    public String update(
            @QueryParam("id") int id,
            @QueryParam("first") String firstname,
            @QueryParam("last") String lastname)
    {
        if(mainSingleton.getInstance().getListeClient().modifierClient(id, firstname, lastname))
        {
            return "<update>UPDATE IS OK</update>";
        }
        return "<update>Probleme lors de l'update</update>";
    }
    
    @DELETE
    @Path("delete")
    @Produces(MediaType.APPLICATION_XML)
    public String delete(@QueryParam("id") int id)
    {
        if(mainSingleton.getInstance().getListeClient().supprimerClient(id))
        {
            return "<infoSupr>Supression effectué</infoSupr>";
        }
        return "Problème lors de la supression";
    }
    
    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
