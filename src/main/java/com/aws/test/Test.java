/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.test;

import com.aws.connection.AwsConnection;
import com.aws.manager.CompanyManager;
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
        String s1="{ \"sfdcid\" : \"123456467\",\"url\" : \"www.test.com\", \"submittedby\" : \"test\", \"privateorpublic\" : \"test\", \"ftes\" : \"3\", \"capitalraised\" : \"4\", \"country\" : \"test\", \"city\" : \"test\", \"name\" : \"test\", \"Public Exchange\" : \"test\", \"Sector\" : \"test\", \"Industries\" : \"test\", \"Practice Areas\" : \"test\", \"Reporting Period\" : \"test\", \"State\" : \"test\", \"Region\" : \"test\", \"founded\" : \"1989\" }";

        System.out.println("--result---"+CompanyManager.insertCompanyManager(s1));
       // Connection conn = AwsConnection.getConnection();
       // Statement stmt = null;
       // stmt = conn.createStatement();
       // ResultSet rs = stmt.executeQuery("Describe table companies");
       // while (rs.next()) {
       //     System.out.println("---"+rs.getArray(1));
       //  }

    }
}
