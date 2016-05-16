/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.connection;

import com.aws.manager.CompanyManager;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Siddharaj Atodaria
 */
public class TestCompanyInsert {

    public static void main(String[] args) throws ParseException {
        String jsonStr =  "{ \"url\" : \"www.test.com\", \"submittedby\" : \"\", \"privateorpublic\" : \"\", \"ftes\" : \"34\", \"capitalraised\" : \"0\", \"country\" : \"\", \"city\" : \"\", \"name\" : \"\", \"Public Exchange\" : \"\", \"Sector\" : \"\", \"Industries\" : \"\", \"Practice Areas\" : \"\", \"Reporting Period\" : \"\", \"State\" : \"\", \"Region\" : \"\", \"founded\" : \"1234\" }";
        System.out.println(""+CompanyManager.insertCompanyManager(jsonStr));
    }

}
