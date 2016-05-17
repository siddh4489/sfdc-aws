/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.utility;

import com.aws.model.ConnectionModel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Siddharaj Atodaria
 */
public class Properties {

    public static ConnectionModel getProperties() {

        ConnectionModel condetailObj = new ConnectionModel();
        java.util.Properties prop = new java.util.Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("config.properties");
            prop.load(input);

            condetailObj.setHosturl(prop.getProperty("hostfullurl"));
            condetailObj.setUsername(prop.getProperty("username"));
            condetailObj.setPassword(prop.getProperty("password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return condetailObj;
    }

}
