package com.aso.qe.framework.api.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ASOJson {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();

        try {     
            Object obj = parser.parse(new FileReader("ASOJson.json"));

            JSONObject jsonObject =  (JSONObject) obj;

            String recordSetTotal = (String) jsonObject.get("recordSetTotal");
            System.out.println(recordSetTotal);

            String recordSetCount = (String) jsonObject.get("recordSetCount");
            System.out.println(recordSetCount);
            
            
            JSONArray sortByInfo = (JSONArray) jsonObject.get("sortByInfo");
            System.out.println("SIZE::"+sortByInfo.size());
            for (Object sortByInfoObj : sortByInfo) {
                JSONObject sortBy = (JSONObject) sortByInfoObj;
                String strName = (String) sortBy.get("name");
                System.out.println("Name::::" + strName);

                String id = (String) sortBy.get("id");
                System.out.println("id::::" + id);
                
                String selectedProperty = (String) sortBy.get("selectedProperty");
                System.out.println("selectedProperty::::" + selectedProperty);
            }
            
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            JSONArray productinfo = (JSONArray) jsonObject.get("productinfo");
            System.out.println("SIZE::"+productinfo.size());
            for (Object productinfoObj : productinfo) {
                JSONObject productinf = (JSONObject) productinfoObj;
                String strName = (String) productinf.get("name");
                System.out.println("Name::::" + strName);

                String id = (String) productinf.get("id");
                System.out.println("id::::" + id);
                
                
                JSONObject defaultSkuPrice1 = (JSONObject) productinf.get("defaultSkuPrice");
                System.out.println("minPriceRange::::" + defaultSkuPrice1.get("minPriceRange"));
                
              
                
            }
            
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    

	}

}
