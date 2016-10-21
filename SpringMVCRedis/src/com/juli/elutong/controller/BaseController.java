package com.juli.elutong.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseController {

	public String add(String code, String msg, String json) {
		return "{\"code\":\"" + code + "\",\"msg\":\"" + msg + "\",\"data\":"
				+ json + "}";
	}

	public String getJson(String code, String msg, String json) {
		return "{\"error_code\": \"" + code + "\",\"msg\":\"" + msg
				+ "\",\"data\": {\"model\":" + json + " }}";
		// "{\"code\":\""+code+"\",\"msg\":\""+msg+"\",\"data\":"+json+"}";
	}

	protected boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	protected boolean isMessyCode(String strName) {
		Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
		Matcher m = p.matcher(strName);
		String after = m.replaceAll("");
		String temp = after.replaceAll("\\p{P}", "");
		char[] ch = temp.trim().toCharArray();
		float chLength = 0;
		float count = 0;
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (!Character.isLetterOrDigit(c)) {
				if (!isChinese(c)) {
					count = count + 1;
				}
				chLength++;
			}
		}
		float result = count / chLength;
		if (result > 0.4) {
			return true;
		} else {
			return false;
		}
	}

	public String isMessy(String zifu) throws UnsupportedEncodingException {
		if (zifu != null) {
			if (isMessyCode(zifu)) {
				zifu = new String(zifu.getBytes("ISO-8859-1"), "UTF-8");
				return zifu;
			}
			return zifu;
		} else {
			return zifu;
		}
	}
}
