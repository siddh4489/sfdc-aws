/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.test;

import com.aws.manager.FinancialManager;
import java.sql.SQLException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Siddharaj Atodaria
 */
public class TestFinancial {

    public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException {
        String jsonstr = "{\"sfid\":\"12345\",\"year_0\":\"2015\",\"qtr_0\":\"Q1\",\"rev_0\":\"1\",\"cog_0\":\"1\",\"gross_0\":\"1\",\"cash_0\":\"1\",\"inv_0\":\"1\",\"rec_0\":\"1\",\"fet_0\":\"1\",\"ltv_0\":\"1\",\"cac_0\":\"1\",\"ltvac_0\":\"3\",\"year_1\":\"2015\",\"qtr_1\":\"Q1\",\"rev_1\":\"2\",\"cog_1\":\"2\",\"gross_1\":\"2\",\"cash_1\":\"2\",\"inv_1\":\"2\",\"rec_1\":\"2\",\"fet_1\":\"2\",\"ltv_1\":\"2\",\"cac_1\":\"2\",\"ltvac_1\":\"4\",\"year_2\":\"2015\",\"qtr_2\":\"Q1\",\"rev_2\":\"3\",\"cog_2\":\"3\",\"gross_2\":\"3\",\"cash_2\":\"3\",\"inv_2\":\"3\",\"rec_2\":\"3\",\"fet_2\":\"3\",\"ltv_2\":\"3\",\"cac_2\":\"3\",\"ltvac_2\":\"5\",\"year_3\":\"2015\",\"qtr_3\":\"Q1\",\"rev_3\":\"4\",\"cog_3\":\"4\",\"gross_3\":\"4\",\"cash_3\":\"4\",\"inv_3\":\"4\",\"rec_3\":\"4\",\"fet_3\":\"4\",\"ltv_3\":\"4\",\"cac_3\":\"4\",\"ltvac_3\":\"6\",\"year_4\":\"2015\",\"qtr_4\":\"Q1\",\"rev_4\":\"5\",\"cog_4\":\"5\",\"gross_4\":\"5\",\"cash_4\":\"5\",\"inv_4\":\"5\",\"rec_4\":\"5\",\"fet_4\":\"5\",\"ltv_4\":\"5\",\"cac_4\":\"5\",\"ltvac_4\":\"7\",\"year_5\":\"2015\",\"qtr_5\":\"Q1\",\"rev_5\":\"6\",\"cog_5\":\"6\",\"gross_5\":\"6\",\"cash_5\":\"6\",\"inv_5\":\"6\",\"rec_5\":\"6\",\"fet_5\":\"6\",\"ltv_5\":\"6\",\"cac_5\":\"678\",\"ltvac_5\":\"8\",\"year_6\":\"2015\",\"qtr_6\":\"Q1\",\"rev_6\":\"7\",\"cog_6\":\"7\",\"gross_6\":\"7\",\"cash_6\":\"7\",\"inv_6\":\"7\",\"rec_6\":\"7\",\"fet_6\":\"7\",\"ltv_6\":\"7\",\"cac_6\":\"1\",\"ltvac_6\":\"1\",\"year_7\":\"2015\",\"qtr_7\":\"Q1\",\"rev_7\":\"8\",\"cog_7\":\"8\",\"gross_7\":\"8\",\"cash_7\":\"8\",\"inv_7\":\"8\",\"rec_7\":\"8\",\"fet_7\":\"8\",\"ltv_7\":\"8\",\"cac_7\":\"2\",\"ltvac_7\":\"2\"}";
        System.out.println("---" + FinancialManager.insertFinancialRecManager(jsonstr,"12323"));
    }
}
