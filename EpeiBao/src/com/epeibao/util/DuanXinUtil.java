package com.epeibao.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class DuanXinUtil{
	// 智能匹配模版发送接口的http地址
	private static String URI_SEND_SMS = "https://sms.yunpian.com/v2/sms/single_send.json";
	// 编码格式。发送编码格式统一用UTF-8
	private static String ENCODING = "UTF-8";
	//发送方apikey
	private static String apikey = "43e5afe4424eb92fcfd16cb6ce727f40";
	 
	static long tpl_id = 1;
	
/*	public static void main(String[] args) {
		try {
			String verificateCode = Integer.toString(new Random().nextInt(899999) + 100000);
			tplSendSms("13947238027");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
//	public static String sendDuanXin(String telephone) throws IOException {
//
//		String verificateCode = "";
//			long tpl_id = 1;
//			verificateCode = new Random().nextInt(899999) + 100000 + "";
//			
//			String codeValue = URLEncoder.encode(verificateCode, ENCODING);
//
//			String tpl_value = "#code#=" + codeValue + "&#company#=医院平台";
//
//			DuanXinUtil.tplSendSms(apikey, tpl_id, tpl_value,
//					telephone);
//		
//		return verificateCode;
//		
//	}

	public static String tplSendSms(String mobile) throws IOException {
	String verificateCode = Integer.toString(new Random().nextInt(899999) + 100000);
		
	String text = "【易源健康】您的验证码是"+verificateCode;
	Map<String, String> params = new HashMap<String, String>();
	params.put("apikey", apikey);
	params.put("text", text);
	params.put("mobile", mobile);
	post(URI_SEND_SMS, params);
	return verificateCode;
	    }
	
//	public static String sendSms(String apikey, String text, String mobile) throws IOException {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("apikey", apikey);
//        params.put("text", text);
//        params.put("mobile", mobile);
//        return post(URI_SEND_SMS, params);
//    }

	
		
    public static String post(String url, Map<String, String> paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }
}