/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.connection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Siddharaj Atodaria
 */
public class TestParser {
    public static void main(String[] args) throws ParseException {
               String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(input);
        System.out.println("--"+json.get("singer"));
    }
    
}
