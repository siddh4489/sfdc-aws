/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.manager;

import com.aws.datamanager.FinancialDataManager;
import com.aws.model.Financial;
import com.aws.model.FinancialModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Siddharaj Atodaria
 */
public class FinancialManager {

    public static String insertFinancialRecManager(String finData,String sfid) throws ParseException, SQLException, ClassNotFoundException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(finData);

        FinancialModel finObj = new FinancialModel();
        List<Financial> finList = new ArrayList<Financial>();
        Financial fobj = new Financial();
        for (int i = 0; i < 8; i++) {
            fobj = new Financial();
            fobj.setSfid(sfid);
            fobj.setYear((String) json.get("year_" + i));
            fobj.setQtr((String) json.get("qtr_" + i));
            fobj.setRev((String) json.get("rev_" + i));
            fobj.setCog((String) json.get("cog_" + i));
            fobj.setGross((String) json.get("gross_" + i));
            fobj.setCash((String) json.get("cash_" + i));
            fobj.setInv((String) json.get("inv_" + i));
            fobj.setRec((String) json.get("rec_" + i));
            fobj.setFet((String) json.get("fet_" + i));
            fobj.setLtv((String) json.get("ltv_" + i));
            fobj.setCac((String) json.get("cac_" + i));
            fobj.setLtvac((String) json.get("ltvac_" + i));
            finList.add(fobj);
        }
        finObj.setFinlst(finList);
        return FinancialDataManager.insertFinancialDataManager(finObj);
    }

}
