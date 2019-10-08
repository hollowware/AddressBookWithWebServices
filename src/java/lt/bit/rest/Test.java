/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import lt.bit.data.Person;

@Path("/test")
public class Test {
    
    @GET  // this method returns Person, Jersey converts it to Jason file
    public Person test() {
        Person p = new Person();
        p.setFirstName("Vardas");
        p.setLastName("Pavarde");
        return p;
    }
}
