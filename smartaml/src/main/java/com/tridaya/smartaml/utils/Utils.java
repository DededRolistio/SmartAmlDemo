/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tridaya.smartaml.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/**
 *
 * @author Yusuf Hasta
 */
public class Utils {
    
    public List<String> listArray (Map<String,Object> obj){
        
        JSONObject object = new JSONObject(obj);
        System.out.println("object :" + object);
        Iterator<String> keys= obj.keySet().iterator();
        List<String> paramList = new ArrayList<String>();
        String valueString = "";
        try{
        List<String> itemsToAdd = new ArrayList<String>();
            while (keys.hasNext()) {
                String keyValue = (String)keys.next();
                valueString = object.getString(keyValue);
                itemsToAdd.add(valueString);
            }
            paramList.addAll(itemsToAdd);
            System.out.println("paramList ::"+paramList);
        }catch(Exception ex){
             ex.printStackTrace();
        }
        return paramList;
    }
}
