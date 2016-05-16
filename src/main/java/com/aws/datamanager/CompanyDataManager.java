/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.datamanager;

import com.aws.connection.AwsConnection;
import com.aws.model.CompanyModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Siddharaj Atodaria
 */
public class CompanyDataManager {

    public static String insertCompanyDataManager(CompanyModel cmodel) {

        try {
            Connection conn = AwsConnection.getConnection();
            Statement stmt = null;
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            StringBuilder sqlQuery = new StringBuilder();
            sqlQuery.append(" INSERT INTO companies (");
            sqlQuery.append("url,submittedby,privateorpublic,");
            sqlQuery.append("ftes,capitalraised,country,");
            sqlQuery.append("city,name,\"Public Exchange\",");
            sqlQuery.append("\"Sector\",\"Industries\",\"Practice Areas\",\"Reporting Period\",");
            sqlQuery.append("\"State\",\"Region\",founded) ");
            sqlQuery.append("VALUES (");
            sqlQuery.append("'"+cmodel.getUrl()+"',");
            sqlQuery.append("'"+cmodel.getSubmittedby() +"',");
            sqlQuery.append("'"+cmodel.getPrivateorpublic() + "',");
            sqlQuery.append(cmodel.getFtes() + ",");
            sqlQuery.append(cmodel.getCapitalraised() + ",");
            sqlQuery.append("'"+cmodel.getCountry() + "',");
            sqlQuery.append("'"+cmodel.getCity() + "',");
            sqlQuery.append("'"+cmodel.getName() + "',");
            sqlQuery.append("'"+cmodel.getPublic_exchange() + "',");
            sqlQuery.append("'"+cmodel.getSector() + "',");
            sqlQuery.append("'"+cmodel.getIndustries() + "',");
            sqlQuery.append("'"+cmodel.getPractice_areas() + "',");
            sqlQuery.append("'"+cmodel.getReporting_period() + "',");
            sqlQuery.append("'"+cmodel.getState() + "',");
            sqlQuery.append("'"+cmodel.getRegion() + "',");
            sqlQuery.append("'"+cmodel.getFounded() +"');");
            
            System.out.println("----sqlQuery----"+sqlQuery);
            stmt.executeUpdate(sqlQuery.toString());
            stmt.close();
            conn.commit();
            conn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CompanyDataManager.class.getName()).log(Level.SEVERE, null, ex);
            return ex.toString();
        } catch (SQLException sqlex) {
            Logger.getLogger(CompanyDataManager.class.getName()).log(Level.SEVERE, null, sqlex);
            return sqlex.toString();
        }
        return "Records created successfully";

    }
}
