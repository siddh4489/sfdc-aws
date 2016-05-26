/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.datamanager;

import com.aws.connection.AwsConnection;
import com.aws.model.FinancialModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Siddharaj Atodaria
 */
public class FinancialDataManager {

    public static String insertFinancialDataManager(FinancialModel fmodel) throws ClassNotFoundException, SQLException {

        try {
            Connection conn = AwsConnection.getConnection();
            Statement stmt = null;
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            StringBuilder sqlQuery = new StringBuilder();
            for (int j = 0; j < fmodel.getFinlst().size(); j++) {
                stmt = conn.createStatement();
                sqlQuery = new StringBuilder();
                sqlQuery.append("insert into reports (");
                sqlQuery.append("\"Year\",\"Quarter\",\"Total Revenue Value\",\"Cost of Revenue Value\",");
                sqlQuery.append("\"Gross Profit Value\",\"Cash & Equivalents Value\",\"Short Term Investments Value\",\"Net Receivables Value\",");
                sqlQuery.append("\"Revenue per FTE Value\",\"LTV/CAC Value\",sfid) ");
                sqlQuery.append("VALUES (");
                sqlQuery.append(fmodel.getFinlst().get(j).year + ",");
                sqlQuery.append("'" + fmodel.getFinlst().get(j).qtr + "',");
                sqlQuery.append(((!"".equals(fmodel.getFinlst().get(j).rev) && fmodel.getFinlst().get(j).rev!=null)?fmodel.getFinlst().get(j).rev:0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getFinlst().get(j).cog) && fmodel.getFinlst().get(j).cog!=null)?fmodel.getFinlst().get(j).cog:0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getFinlst().get(j).gross) && fmodel.getFinlst().get(j).gross!=null)?fmodel.getFinlst().get(j).gross:0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getFinlst().get(j).cash) && fmodel.getFinlst().get(j).cash!=null)?fmodel.getFinlst().get(j).cash:0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getFinlst().get(j).inv) && fmodel.getFinlst().get(j).inv!=null)?fmodel.getFinlst().get(j).inv:0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getFinlst().get(j).rec) && fmodel.getFinlst().get(j).rec!=null)?fmodel.getFinlst().get(j).rec:0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getFinlst().get(j).fet) && fmodel.getFinlst().get(j).fet!=null)?fmodel.getFinlst().get(j).fet:0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getFinlst().get(j).ltvac) && fmodel.getFinlst().get(j).ltvac!=null)?fmodel.getFinlst().get(j).ltvac:0) + ",");
                sqlQuery.append("'" + fmodel.getFinlst().get(j).sfid + "');");
                System.out.println("---sqlQuery----"+sqlQuery);
                stmt.executeUpdate(sqlQuery.toString());
                stmt.close();
                }
            
            conn.commit();
            conn.close();

        } catch (SQLException sqlex) {
            System.out.println("---sqlex----"+sqlex);
            Logger.getLogger(CompanyDataManager.class.getName()).log(Level.SEVERE, null, sqlex);
            return sqlex.toString();
        }
        return "Financial Data created successfully";

    }

}
