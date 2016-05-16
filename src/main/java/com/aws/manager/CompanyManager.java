/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.manager;


import com.aws.datamanager.CompanyDataManager;
import com.aws.model.CompanyModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Siddharaj Atodaria
 */
public class CompanyManager {

    public static String insertCompanyManager(String companyData) throws ParseException {
        CompanyModel comObj=new CompanyModel();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(companyData);
        comObj.setUrl((String) json.get("url"));
        comObj.setSubmittedby((String) json.get("submittedby"));
        comObj.setPrivateorpublic((String)json.get("privateorpublic"));
        comObj.setFtes((Integer)json.get("ftes"));
        comObj.setCapitalraised((Integer)json.get("capitalraised"));
        comObj.setCountry((String)json.get("country"));
        comObj.setCity((String)json.get("city"));
        comObj.setName((String)json.get("name"));
        comObj.setPublic_exchange((String)json.get("Public Exchange"));
        comObj.setSector((String)json.get("Sector"));
        comObj.setIndustries((String)json.get("Industries"));
        comObj.setPractice_areas((String)json.get("Practice Areas"));
        comObj.setReporting_period((String)json.get("Reporting Period"));
        comObj.setState((String)json.get("State"));
        comObj.setRegion((String)json.get("Region"));
        comObj.setFounded((String)json.get("founded"));
        return CompanyDataManager.insertCompanyDataManager(comObj);
    }

}
