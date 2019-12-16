package org.tickets.germes.app.rest.service;

import java.util.Arrays;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cities")
public class CityResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> findCities() {
        return Arrays.asList("Moscow", "Tver");
    }

    @GET
    @Path("/hi")
    public String getHiGreeting() {
        return "hi";
    }
}
