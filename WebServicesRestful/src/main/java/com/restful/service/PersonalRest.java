
package com.restful.service;


import com.restful.entidades.Personal;
import com.restful.session.PersonalFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Personal")
public class PersonalRest{
    
    @EJB
    
    private PersonalFacade personalFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Personal> findall(){
        return personalFacade.findAll();
    }
    
    // TRAER UN ID ESPECIFICO
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Personal findByIaD(@PathParam("id") Integer id){
        return personalFacade.find(id);
    }
    //POST insertar elemento
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public void create (Personal p){
        personalFacade.create(p);
    }
    
    //Delete borrar elemento
    
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id){
        personalFacade.remove(personalFacade.find(id));
        return Response.ok("Dato eliminado correcctamente").build();
        
    }
    
    
    //actulizar
    @PUT
    @Produces({MediaType.APPLICATION_JSON})   
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, Personal p){
        
        p.setId(id);
        personalFacade.edit(p);
        
    }
    

    
    
    
    
}
