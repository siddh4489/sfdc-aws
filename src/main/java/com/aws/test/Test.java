/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.test;

import com.aws.connection.AwsConnection;
import com.aws.manager.CompanyManager;
import com.aws.manager.FinancialManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Siddharaj Atodaria
 */
public class Test {

    public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException {
       // String s1="{ \"sfdcid\" : \"555\",\"url\" : \"www.test.com\", \"submittedby\" : \"test\", \"privateorpublic\" : \"test\", \"ftes\" : \"3\", \"capitalraised\" : \"4\", \"country\" : \"test\", \"city\" : \"test\", \"name\" : \"test\", \"Public Exchange\" : \"test\", \"Sector\" : \"test\", \"Industries\" : \"test\", \"Practice Areas\" : \"test\", \"Reporting Period\" : \"test\", \"State\" : \"test\", \"Region\" : \"test\", \"founded\" : \"1989\" }";

      //  System.out.println("--result---"+CompanyManager.insertCompanyManager(s1));
        
        
        String jsonstr ="{\"sfid\":\"12345\",\"year_0\":\"2015\",\"qtr_0\":\"Q1\",\"rev_0\":\"1\",\"cog_0\":\"1\",\"gross_0\":\"1\",\"cash_0\":\"1\",\"inv_0\":\"1\",\"rec_0\":\"1\",\"fet_0\":\"1\",\"ltv_0\":\"1\",\"cac_0\":\"1\",\"ltvac_0\":\"3\",\"year_1\":\"2015\",\"qtr_1\":\"Q1\",\"rev_1\":\"2\",\"cog_1\":\"2\",\"gross_1\":\"2\",\"cash_1\":\"2\",\"inv_1\":\"2\",\"rec_1\":\"2\",\"fet_1\":\"2\",\"ltv_1\":\"2\",\"cac_1\":\"2\",\"ltvac_1\":\"4\",\"year_2\":\"2015\",\"qtr_2\":\"Q1\",\"rev_2\":\"3\",\"cog_2\":\"3\",\"gross_2\":\"3\",\"cash_2\":\"3\",\"inv_2\":\"3\",\"rec_2\":\"3\",\"fet_2\":\"3\",\"ltv_2\":\"3\",\"cac_2\":\"3\",\"ltvac_2\":\"5\",\"year_3\":\"2015\",\"qtr_3\":\"Q1\",\"rev_3\":\"4\",\"cog_3\":\"4\",\"gross_3\":\"4\",\"cash_3\":\"4\",\"inv_3\":\"4\",\"rec_3\":\"4\",\"fet_3\":\"4\",\"ltv_3\":\"4\",\"cac_3\":\"4\",\"ltvac_3\":\"6\",\"year_4\":\"2015\",\"qtr_4\":\"Q1\",\"rev_4\":\"5\",\"cog_4\":\"5\",\"gross_4\":\"5\",\"cash_4\":\"5\",\"inv_4\":\"5\",\"rec_4\":\"5\",\"fet_4\":\"5\",\"ltv_4\":\"5\",\"cac_4\":\"5\",\"ltvac_4\":\"7\",\"year_5\":\"2015\",\"qtr_5\":\"Q1\",\"rev_5\":\"6\",\"cog_5\":\"6\",\"gross_5\":\"6\",\"cash_5\":\"6\",\"inv_5\":\"6\",\"rec_5\":\"6\",\"fet_5\":\"6\",\"ltv_5\":\"6\",\"cac_5\":\"678\",\"ltvac_5\":\"8\",\"year_6\":\"2015\",\"qtr_6\":\"Q1\",\"rev_6\":\"7\",\"cog_6\":\"7\",\"gross_6\":\"7\",\"cash_6\":\"7\",\"inv_6\":\"7\",\"rec_6\":\"7\",\"fet_6\":\"7\",\"ltv_6\":\"7\",\"cac_6\":\"1\",\"ltvac_6\":\"1\",\"year_7\":\"2015\",\"qtr_7\":\"Q1\",\"rev_7\":\"8\",\"cog_7\":\"8\",\"gross_7\":\"8\",\"cash_7\":\"8\",\"inv_7\":\"8\",\"rec_7\":\"8\",\"fet_7\":\"8\",\"ltv_7\":\"8\",\"cac_7\":\"2\",\"ltvac_7\":\"2\"}";
        //String cmp ="{ \"sfdcid\" : \"1234544444\",\"url\" : \"www.test.com\", \"submittedby\" : \"test\", \"privateorpublic\" : \"test\", \"ftes\" : \"11\", \"capitalraised\" : \"11\", \"country\" : \"test\", \"city\" : \"test\", \"name\" : \"test\", \"Public Exchange\" : \"test\", \"Sector\" : \"test\", \"Industries\" : \"test\", \"Practice Areas\" : \"test\", \"Reporting Period\" : \"test\", \"State\" : \"test\", \"Region\" : \"test\", \"founded\" : \"1989\" }";
        String jsonstr1="{\"year_0\":\"2015\",\"qtr_0\":\"Q1\",\"rev_0\":\"\",\"cog_0\":\"\",\"gross_0\":\"\",\"cash_0\":\"\",\"inv_0\":\"\",\"rec_0\":\"\",\"fet_0\":\"\",\"ltv_0\":\"\",\"cac_0\":\"\",\"ltvac_0\":\"\",\"year_1\":\"2015\",\"qtr_1\":\"Q1\",\"rev_1\":\"\",\"cog_1\":\"\",\"gross_1\":\"\",\"cash_1\":\"\",\"inv_1\":\"\",\"rec_1\":\"\",\"fet_1\":\"\",\"ltv_1\":\"\",\"cac_1\":\"\",\"ltvac_1\":\"\",\"year_2\":\"2015\",\"qtr_2\":\"Q1\",\"rev_2\":\"\",\"cog_2\":\"\",\"gross_2\":\"\",\"cash_2\":\"\",\"inv_2\":\"\",\"rec_2\":\"\",\"fet_2\":\"\",\"ltv_2\":\"\",\"cac_2\":\"\",\"ltvac_2\":\"\",\"year_3\":\"2015\",\"qtr_3\":\"Q1\",\"rev_3\":\"\",\"cog_3\":\"\",\"gross_3\":\"\",\"cash_3\":\"\",\"inv_3\":\"\",\"rec_3\":\"\",\"fet_3\":\"\",\"ltv_3\":\"\",\"cac_3\":\"\",\"ltvac_3\":\"\",\"year_4\":\"2015\",\"qtr_4\":\"Q1\",\"rev_4\":\"\",\"cog_4\":\"\",\"gross_4\":\"\",\"cash_4\":\"\",\"inv_4\":\"\",\"rec_4\":\"\",\"fet_4\":\"\",\"ltv_4\":\"\",\"cac_4\":\"\",\"ltvac_4\":\"\",\"year_5\":\"2015\",\"qtr_5\":\"Q1\",\"rev_5\":\"\",\"cog_5\":\"\",\"gross_5\":\"\",\"cash_5\":\"\",\"inv_5\":\"\",\"rec_5\":\"\",\"fet_5\":\"\",\"ltv_5\":\"\",\"cac_5\":\"\",\"ltvac_5\":\"\",\"year_6\":\"2015\",\"qtr_6\":\"Q1\",\"rev_6\":\"\",\"cog_6\":\"\",\"gross_6\":\"\",\"cash_6\":\"\",\"inv_6\":\"\",\"rec_6\":\"\",\"fet_6\":\"\",\"ltv_6\":\"\",\"cac_6\":\"\",\"ltvac_6\":\"\",\"year_7\":\"2015\",\"qtr_7\":\"Q1\",\"rev_7\":\"\",\"cog_7\":\"\",\"gross_7\":\"\",\"cash_7\":\"\",\"inv_7\":\"\",\"rec_7\":\"\",\"fet_7\":\"\",\"ltv_7\":\"\",\"cac_7\":\"\",\"ltvac_7\":\"\"}";
        System.out.println("---"+FinancialManager.insertFinancialRecManager(jsonstr1,"12314546"));
        //System.out.println("---"+CompanyManager.insertCompanyManager(cmp));
       // Connection conn = AwsConnection.getConnection();
       // Statement stmt = null;
       // stmt = conn.createStatement();
       // ResultSet rs = stmt.executeQuery("Describe table companies");
       // while (rs.next()) {
       //     System.out.println("---"+rs.getArray(1));
       //  }

    }
}
