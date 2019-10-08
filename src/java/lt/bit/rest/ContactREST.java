/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import lt.bit.data.Address;
import lt.bit.data.Contact;
import lt.bit.db.DB;

@Path("person/{personId}/contact")
public class ContactREST {
    
    @Context
    private HttpServletRequest request;
    
    @GET
    public List<Contact> contactList (@PathParam("personId") Integer personId) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        return DB.getPersonContacts(personId, em);
    }
    
    @GET
    @Path("{id}")
    public Contact getContact(@PathParam("id") Integer id) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        return DB.getContactById(id, em);
    }
    
    @POST
    public Contact addContact(@PathParam("personId") Integer personId, Contact c) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        return DB.addContact(personId, c, em);
    }
    
    @PUT
    @Path("{id}")
    public Contact updateContact(@PathParam("id") Integer id, Contact c) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        c.setId(id);
        return DB.updateContact(c, em);
    }
    
    @DELETE
    @Path("{id}")
    public void deleteContact(@PathParam("id") Integer id) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        DB.deleteContact(id, em);
    }
}
