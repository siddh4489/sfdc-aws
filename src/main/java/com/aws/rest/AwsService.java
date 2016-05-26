/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.rest;

import com.aws.manager.CompanyManager;
import com.aws.manager.FinancialManager;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Siddharaj Atodaria
 */
@Path("/aws")
public class AwsService {

    @POST
    @Path("/company")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCompany(@HeaderParam("cmpstr") String cmpstr) throws ParseException, SQLException, ClassNotFoundException {
        return Response.status(201).entity(CompanyManager.insertCompanyManager(cmpstr)).build();
    }
    
    
    @POST
    @Path("/financial")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFinancialData(@HeaderParam("finstr") String finstr,@HeaderParam("sfid") String sfid) throws ParseException, SQLException, ClassNotFoundException {
        return Response.status(201).entity(FinancialManager.insertFinancialRecManager(finstr,sfid)).build();
    }
    
    @POST
    @Path("/test")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response test(@HeaderParam("test") String test) throws ParseException, SQLException, ClassNotFoundException {
        return Response.status(201).entity("Welcome "+test).build();
    }
    
    @GET
    @Path("/test2")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test2(@HeaderParam("test2") String test2) throws ParseException, SQLException, ClassNotFoundException {
        return Response.status(201).entity("Welcome "+test2).build();
    }

}
