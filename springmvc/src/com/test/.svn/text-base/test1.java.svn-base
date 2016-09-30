package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class test1 {

	public static void main(String[] args) {
		
	
        String json="[{'name':'huangbiao','age':15},{'name':'liumei','age':14}]";  
        JSONArray jsonarray = JSONArray.parseArray(json);
        System.out.println(jsonarray);  
        List list = (List)JSONArray.toJSON(jsonarray);
        System.out.println(list.get(0).toString());
        System.out.println(list.get(1).toString());
        Iterator it = list.iterator();
        while(it.hasNext()){  
        	System.out.println(1);
        	System.out.println(it.next());
        }  
	}  
    

}
