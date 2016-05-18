/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.connection;

import com.aws.utility.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Siddharaj Atodaria
 */
public class AwsConnection {

    public static Connection getConnection() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://financial.caie2001o45n.us-west-2.rds.amazonaws.com:5432/financial","financial","ERL6neX8e8fZHFabrnUN");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
