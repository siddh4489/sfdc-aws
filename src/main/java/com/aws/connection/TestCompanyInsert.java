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
        String jsonStr =  "{ \"url\" : \"www.test.com\", \"submittedby\" : \"test\", \"privateorpublic\" : \"test\", \"ftes\" : \"3\", \"capitalraised\" : \"3\", \"country\" : \"test\", \"city\" : \"test\", \"name\" : \"test\", \"Public Exchange\" : \"test\", \"Sector\" : \"test\", \"Industries\" : \"test\", \"Practice Areas\" : \"test\", \"Reporting Period\" : \"test\", \"State\" : \"test\", \"Region\" : \"test\", \"founded\" : \"1989\" }";
        System.out.println(""+CompanyManager.insertCompanyManager(jsonStr));
    }

}
