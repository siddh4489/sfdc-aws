/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.datamanager;

import com.aws.connection.AwsConnection;
import com.aws.model.CompanyModel;
import com.aws.model.FinancialModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public static String companyProcessBypass(CompanyModel cmodeModel) throws SQLException, ClassNotFoundException {
        Connection conn = AwsConnection.getConnection();
        String result;
        if (checkRecord(conn, cmodeModel.getSfdcId())) {
            result = updateCompanyDataManager(conn, cmodeModel);
        } else {
            result = insertCompanyDataManager(conn, cmodeModel);
        }

        return result;
    }

    public static String insertCompanyDataManager(Connection conn, CompanyModel cmodel) {

        try {
            Statement stmt = null;
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            StringBuilder sqlQuery = new StringBuilder();
            sqlQuery.append(" INSERT INTO companies (");
            sqlQuery.append("sfid,url,submittedby,privateorpublic,");
            sqlQuery.append("ftes,capitalraised,country,");
            sqlQuery.append("city,name,\"Public Exchange\",");
            sqlQuery.append("\"Sector\",\"Industries\",\"Practice Areas\",\"Reporting Period\",");
            sqlQuery.append("\"State\",\"Region\",founded) ");
            sqlQuery.append("VALUES (");
            sqlQuery.append("'" + cmodel.getSfdcId() + "',");
            sqlQuery.append("'" + cmodel.getUrl() + "',");
            sqlQuery.append("'" + cmodel.getSubmittedby() + "',");
            sqlQuery.append("'" + cmodel.getPrivateorpublic() + "',");
            sqlQuery.append(cmodel.getFtes() + ",");
            sqlQuery.append(cmodel.getCapitalraised() + ",");
            sqlQuery.append("'" + cmodel.getCountry() + "',");
            sqlQuery.append("'" + cmodel.getCity() + "',");
            sqlQuery.append("'" + cmodel.getName() + "',");
            sqlQuery.append("'" + cmodel.getPublic_exchange() + "',");
            sqlQuery.append("'" + cmodel.getSector() + "',");
            sqlQuery.append("'" + cmodel.getIndustries() + "',");
            sqlQuery.append("'" + cmodel.getPractice_areas() + "',");
            sqlQuery.append("'" + cmodel.getReporting_period() + "',");
            sqlQuery.append("'" + cmodel.getState() + "',");
            sqlQuery.append("'" + cmodel.getRegion() + "',");
            sqlQuery.append("'" + cmodel.getFounded() + "');");
            stmt.executeUpdate(sqlQuery.toString());
            stmt.close();
            conn.commit();
            conn.close();

        } catch (SQLException sqlex) {
            Logger.getLogger(CompanyDataManager.class.getName()).log(Level.SEVERE, null, sqlex);
            return sqlex.toString();
        }
        return "Records created successfully";

    }
    
    public static String insertFinancialDataManager(FinancialModel fmodel) throws ClassNotFoundException {

        try {
            Connection conn = AwsConnection.getConnection();
            Statement stmt = null;
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            StringBuilder sqlQuery = new StringBuilder();
            for(int j=0;j<fmodel.getFinlst().size();j++){
            stmt = conn.createStatement();
            sqlQuery = new StringBuilder();    
            System.out.println(j+"---Year----"+fmodel.getFinlst().get(j).year);
            System.out.println(j+"---Qtr----"+fmodel.getFinlst().get(j).qtr);
            System.out.println(j+"---rev----"+fmodel.getFinlst().get(j).rev);
            System.out.println(j+"---cog----"+fmodel.getFinlst().get(j).cog);
            System.out.println(j+"---gross----"+fmodel.getFinlst().get(j).gross);
            System.out.println(j+"---cash----"+fmodel.getFinlst().get(j).cash);
            System.out.println(j+"---inv----"+fmodel.getFinlst().get(j).inv);
            System.out.println(j+"---rec----"+fmodel.getFinlst().get(j).rec);
            System.out.println(j+"---fet----"+fmodel.getFinlst().get(j).fet);
            System.out.println(j+"---ltv----"+fmodel.getFinlst().get(j).ltv);
            System.out.println(j+"---cac----"+fmodel.getFinlst().get(j).cac);
            System.out.println(j+"---ltvac----"+fmodel.getFinlst().get(j).ltvac);
            sqlQuery.append("insert into reports (");
            sqlQuery.append("\"Year\",\"Quarter\",\"Total Revenue Value\",\"Cost of Revenue Value\",");
            sqlQuery.append("\"Gross Profit Value\",\"Cash & Equivalents Value\",\"Short Term Investments Value\",\"Net Receivables Value\",");
            sqlQuery.append("\"Revenue per FTE Value\",\"LTV/CAC Value\",sfid) ");
            sqlQuery.append("VALUES (");
            sqlQuery.append(fmodel.getFinlst().get(j).year + ",");
            sqlQuery.append("'" + fmodel.getFinlst().get(j).qtr + "',");
            sqlQuery.append(fmodel.getFinlst().get(j).rev + ",");
            sqlQuery.append(fmodel.getFinlst().get(j).cog + ",");
            sqlQuery.append(fmodel.getFinlst().get(j).gross + ",");
            sqlQuery.append(fmodel.getFinlst().get(j).cash+ ",");
            sqlQuery.append(fmodel.getFinlst().get(j).inv + ",");
            sqlQuery.append(fmodel.getFinlst().get(j).rec+ ",");
            sqlQuery.append(fmodel.getFinlst().get(j).fet + ",");
            sqlQuery.append(fmodel.getFinlst().get(j).ltvac+ ",");
            sqlQuery.append("'" + fmodel.getFinlst().get(j).sfid + "');");
            System.out.println("----------------------------------------");
            stmt.executeUpdate(sqlQuery.toString());
            stmt.close();
        }


            
           
            conn.commit();
            conn.close();

        } catch (SQLException sqlex) {
            Logger.getLogger(CompanyDataManager.class.getName()).log(Level.SEVERE, null, sqlex);
            return sqlex.toString();
        }
        return "Financial Data created successfully";

    }

    public static String updateCompanyDataManager(Connection conn, CompanyModel cmodel) {

        try {

            conn.setAutoCommit(false);
            StringBuilder sqlQuery = new StringBuilder();
            sqlQuery.append(" UPDATE companies SET ");
            sqlQuery.append("url = ?,submittedby = ?,privateorpublic = ?,");
            sqlQuery.append("ftes = ?,capitalraised = ?,country = ?,");
            sqlQuery.append("city = ?,name = ?,\"Public Exchange\" = ? ,");
            sqlQuery.append("\"Sector\" = ?,\"Industries\" = ?,\"Practice Areas\" = ?,\"Reporting Period\" = ?,");
            sqlQuery.append("\"State\" = ?,\"Region\" = ?,founded = ? WHERE sfid = ?");
            PreparedStatement ps = conn.prepareStatement(sqlQuery.toString());
            ps.setString(1, cmodel.getUrl());
            ps.setString(2, cmodel.getSubmittedby());
            ps.setString(3, cmodel.getPrivateorpublic());
            ps.setInt(4, Integer.valueOf(cmodel.getFtes()));
            ps.setInt(5, Integer.valueOf(cmodel.getCapitalraised()));
            ps.setString(6, cmodel.getCountry());
            ps.setString(7, cmodel.getCity());
            ps.setString(8, cmodel.getName());
            ps.setString(9, cmodel.getPublic_exchange());
            ps.setString(10, cmodel.getSector());
            ps.setString(11, cmodel.getIndustries());
            ps.setString(12, cmodel.getPractice_areas());
            ps.setString(13, cmodel.getReporting_period());
            ps.setString(14, cmodel.getState());
            ps.setString(15, cmodel.getRegion());
            ps.setInt(16, Integer.valueOf(cmodel.getFounded()));
            ps.setString(17, cmodel.getSfdcId());
            ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (SQLException sqlex) {
            Logger.getLogger(CompanyDataManager.class.getName()).log(Level.SEVERE, null, sqlex);
            return sqlex.toString();
        }
        return "Records Updated successfully";

    }

    public static boolean checkRecord(Connection conn, String sfdcId) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean flag = false;
        pst = conn.prepareStatement("SELECT * FROM companies WHERE sfid='" + sfdcId + "'");
        rs = pst.executeQuery();
        if (rs.next()) {
            flag = true;
        }
        return flag;
    }
}
