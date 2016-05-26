/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.manager;


import com.aws.datamanager.CompanyDataManager;
import com.aws.model.CompanyModel;
import java.sql.SQLException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Siddharaj Atodaria
 */
public class CompanyManager {

    public static String insertCompanyManager(String companyData) throws ParseException, SQLException, ClassNotFoundException {
        CompanyModel comObj=new CompanyModel();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(companyData);
        comObj.setSfdcId(((String) json.get("sfdcid")!=null?(String) json.get("sfdcid"):""));
        comObj.setUrl(((String) json.get("url")!=null?(String) json.get("url"):""));
        comObj.setSubmittedby(((String) json.get("submittedby")!=null?(String) json.get("submittedby"):""));
        comObj.setPrivateorpublic(((String)json.get("privateorpublic")!=null?(String)json.get("privateorpublic"):""));
        comObj.setFtes(((String)json.get("ftes")!=null?(String)json.get("ftes"):"0"));
        comObj.setCapitalraised(((String)json.get("capitalraised")!=null?(String)json.get("capitalraised"):"0"));
        comObj.setCountry(((String)json.get("country")!=null?(String)json.get("country"):""));
        comObj.setCity(((String)json.get("city")!=null?(String)json.get("city"):""));
        comObj.setName(((String)json.get("name")!=null?(String)json.get("name"):""));
        comObj.setPublic_exchange(((String)json.get("Public Exchange")!=null?(String)json.get("Public Exchange"):""));
        comObj.setSector((String)json.get("Sector")!=null?(String)json.get("Sector"):"");
        comObj.setIndustries(((String)json.get("Industries")!=null?(String)json.get("Industries"):""));
        comObj.setPractice_areas(((String)json.get("Practice Areas")!=null?(String)json.get("Practice Areas"):""));
        comObj.setReporting_period(((String)json.get("Reporting Period")!=null?(String)json.get("Reporting Period"):""));
        comObj.setState(((String)json.get("State")!=null?(String)json.get("State"):""));
        comObj.setRegion(((String)json.get("Region")!=null?(String)json.get("Region"):""));
        comObj.setFounded(((String)json.get("founded")!=null?(String)json.get("founded"):"0"));
        return CompanyDataManager.companyProcessBypass(comObj);
    }

}
