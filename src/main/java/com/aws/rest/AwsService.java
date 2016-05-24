/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.rest;

import com.aws.manager.CompanyManager;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
    public Response createFinancialData(@HeaderParam("finstr") String finstr) throws ParseException, SQLException, ClassNotFoundException {
        return Response.status(201).entity(CompanyManager.insertFinancialRecManager(finstr)).build();
    }

}
