package com.kc.base.utils;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	/**
	 * 根据字符串获取键值对
	 * @param conditions
	 	* name=123&code=3|sex=1
		*name=123|code=3&sex=1
		*name=123&code=3&sex=1
		*name=123|code=3|sex=1
	 * @return map<String,String>
	 */
	public static Map<String, String> getMap(String conditions){
		Map<String, String> ret =null;
		if(conditions!=null&&!"".equals(conditions)){
			 ret = new IdentityHashMap<String, String>();
			String[] f=conditions.split("&|\\|");
			for (int i = 0; i < f.length; i++) {
				String[] s=f[i].split("=");
				ret.put(s[0],s[1]);
			}
		}
		return ret;
	}
	/**
	 * 根据字符串获取键值对
	 * @param conditions
	 	* name=123&code=3|sex=1
		*name=123|code=3&sex=1
		*name=123&code=3&sex=1
		*name=123|code=3|sex=1
	 * @return map<String,String>
	 */
	public static List<String> getPramList(String conditions){
		List<String> ret =null;
		if(conditions!=null&&!"".equals(conditions)){
			 ret = new ArrayList<String>();
			String[] f=conditions.split("&|\\|");
			for (int i = 0; i < f.length; i++) {
				String[] s=f[i].split("=");
				if(s.length>2){
					ret.add(s[0]);
				}
			}
		}
		return ret;
	}
	public static String trimStr(String str){
		return str.replaceAll("\n|\r|\t", "");
	}
	
	public static String replaceStr(String source, String oldString,
			String newString) {
		if ((oldString == null) || (oldString.length() == 0)) {
			return source;
		}
		if (source == null) {
			return "";
		}
		if (newString == null) {
			newString = "";
		}
		int posStart = 0;
		int pos = source.indexOf(oldString, posStart);
		if (pos == -1) {
			return source;
		}
		StringBuffer output = new StringBuffer();
		int lengthOfSource = source.length();
		int lengthOfOld = oldString.length();
		while (pos >= 0) {
			output.append(source.substring(posStart, pos));
			output.append(newString);
			posStart = pos + lengthOfOld;
			pos = source.indexOf(oldString, posStart);
		}
		if (posStart < lengthOfSource) {
			output.append(source.substring(posStart));
		}
		return output.toString();
	}
	
	public static String toUnEncodedXml(String s)
	  {
	    if (s == null) {
	      return "";
	    }
	    s = replaceStr(s, "&lt;", "<");
	    s = replaceStr(s, "&gt;", ">");
	    s = replaceStr(s, "&quot;", "\"");
	    s = replaceStr(s, "&apos;", "'");
	    s = replaceStr(s, "&amp;", "&");
	    return s;
	  }
	
	public static String null2String(String paramString)
	  {
	    return paramString == null ? "" : paramString;
	  }
	
	public static String formatDateStr(String str){
		return str == null ? str : str.replace("-", "");
	}
	
	public static String format18zero(String param){
		if(param == null || "".equals(param)){
			return param;
		}else {
			try {
				int i =  Integer.parseInt(param);
				String str = "000000000000000000";
				String formatstr = str.substring(0, 18-param.length())+param;
				return formatstr;
			} catch (NumberFormatException e) {
				e.printStackTrace();
				return param;
			}
			
		}
	}
	
	public static String format10zero(String param){
		if(param == null || "".equals(param)){
			return param;
		}else {
			try {
				int i =  Integer.parseInt(param);
				String str = "0000000000";
				String formatstr = str.substring(0, 10-param.length())+param;
				return formatstr;
			} catch (NumberFormatException e) {
				e.printStackTrace();
				return param;
			}
			
		}
	}
	
	public static String formatSpace(String str){
		if(str == null){
			return str;
		}else {
			Pattern pattern = Pattern.compile("\\s+");
			Matcher m = pattern.matcher(str);
			return m.replaceAll(" ");
		}
	}
}
