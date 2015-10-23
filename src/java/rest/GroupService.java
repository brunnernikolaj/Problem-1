/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.GroupInfo;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import util.WebScraper;

/**
 * REST Web Service
 *
 * @author Nikolaj
 */
@Path("group")
public class GroupService {

    @Context
    private UriInfo context;

    private WebScraper scraper = new WebScraper();
    Gson gson;

    /**
     * Creates a new instance of GenericResource
     */
    public GroupService() {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .create();
    }

    /**
     * Retrieves representation of an instance of rest.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public Response getGroups() throws IOException, InterruptedException, ExecutionException {
        List<GroupInfo> data = scraper.scrapeData();
        
        CacheControl cc = new CacheControl();
        cc.setMaxAge(3600);
        cc.setPrivate(true);

        ResponseBuilder builder = Response.ok(gson.toJson(data));
        builder.cacheControl(cc);
        return builder.build();

       
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
