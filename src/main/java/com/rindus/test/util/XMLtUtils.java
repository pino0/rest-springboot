package com.rindus.test.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.util.List;

public class XMLtUtils {

    private XMLtUtils(){
    }

    public static String objectToXml(Object obj, String name){
        String xml = "";
        JSONObject json = new JSONObject(obj.toString());

        try{
            xml = XML.toString(json,name);
        }catch (JSONException je){
            System.err.println("An error occurred converting json object to XML");
            je.printStackTrace();
        }

        return xml;
    }

    public static String listObjectsToXml(List<Object> objs, String name){
        String json;
        String xml = "";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            json = objectMapper.writeValueAsString(objs);
            xml = XML.toString(json,name);
        }catch (JsonProcessingException jpe){
            System.err.println("An error occurred getting json list objects.");
            jpe.printStackTrace();
        }catch (JSONException je){
            System.err.println("An error occurred converting json list objects to XML");
            je.printStackTrace();
        }

        return xml;
    }
}
