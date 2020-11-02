package com.kc.base.utils;


import com.kc.base.bean.CommException;
import com.kc.base.bean.ParseXml;
import com.kc.base.bean.Request;

import com.kc.base.exception.MdmException;

import com.kc.project.entity.SysUser;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.dom4j.DocumentException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * web工具类
 * @author fyt
 *
 */
public class WebUtils
{
	public static Request getReqBean(String requestbody, HttpServletRequest req) throws Exception{
		if(requestbody==null||"".equals(requestbody.trim())){
			return new Request();
		}
		String contenttype=req.getHeader("Content-Type");
		String accept=req.getHeader("accept");
		if(accept!=null&&accept.indexOf("application/xml")>=0){
			accept="xml";
		}else{
			accept="json";
		}
		Request rp=new Request();
		rp.setReturnType(accept);
		if(contenttype!=null&&contenttype.indexOf("application/xml")>=0){
			rp=getReqBeanByXml(requestbody);
		}else if(contenttype!=null&&contenttype.indexOf("application/json")>=0)
		{
			rp=getReqBeanByJson(requestbody);
		}else{
			throw new MdmException(CommException.PARAM_HTTP_CONTENT_TYPE_CODE,CommException.PARAM_HTTPCONTENT_TYPE_MSG);
		}
		return rp;
	}
	public static Request getReqBeanByXml(String requestbody) throws Exception{
		Request pb = null; 
		try {
			ParseXml px = new ParseXml(requestbody);
			pb = new Request();
			System.out.println("query xml");
			pb.setQuery(px.getElementMap("/request/query"));
			System.out.println("head xml");
			System.out.println(px.getElementText("/request/head"));
			pb.setHead(px.getElementMap("/request/head"));
			System.out.println("bodys xml");
			System.out.println(px.getElementText("/request/bodys/body"));
			pb.setBodys(px.getChildrenInfoByElement("/request/bodys/body"));
			
			pb.setHeadothers(px.getChildrenInfoByElement("/request/headothers/headother"));
			
			pb.setOthers(px.getTwoChildrenElement("/request/bodys/body", "pricebodys/price"));
			
			pb.setMdmUser(new SysUser(px.getElementText("/request/syscode"),px.getElementText("/request/username"),px.getElementText("/request/password")));
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new MdmException(CommException.PARAM_XML_CODE,CommException.PARAM_XML_MSG+"("+e.getMessage()+")");
		} catch (Exception e){
			e.printStackTrace();
			throw new MdmException(CommException.PARAM_XML_PARSE_CODE,CommException.PARAM_XML_PARSE_MSG);
		}
		 return pb;
	}
	public static Request getReqBeanByJson(String requestbody) throws Exception{
		Request pb = null; 
		try {
			Map<String, Object> result = JsonUtil.decode(requestbody, Map.class);
			pb= new  Request();
			System.out.println("query json");
			System.out.println(result.get("query"));
			if(result.get("query")!=null){
				pb.setQuery((Map<String, String>) result.get("query"));
			}
			System.out.println("head json");
			System.out.println(result.get("head"));
			if(result.get("head")!=null){
				pb.setHead((Map<String, String>) result.get("head"));
			}
			System.out.println("body json");
			System.out.println(result.get("bodys"));
			
			if(result.get("headothers")!=null){
				List<Map<String, String>> headotherlist = (List<Map<String, String>>) result.get("headothers");
				pb.setHeadothers(headotherlist);
			}
			
			if(result.get("bodys")!=null){
				List<Map<String, String>> otherlist = new ArrayList<Map<String,String>>();
				List<Map<String, Object>> ll = (List<Map<String, Object>>)result.get("bodys");
				for (int i = 0; i < ll.size(); i++) {
					List<Map<String, String>> lm = (List<Map<String, String>>) ll.get(i).get("pricebodys");
					if(lm != null){
						for (int j = 0; j < lm.size(); j++) {
							otherlist.add(lm.get(j));
						}
					}
				}
				pb.setOthers(otherlist);
				
				List<Map<String, String>> bodylist = (List<Map<String, String>>) result.get("bodys");
				for (int i = 0; i < bodylist.size(); i++) {
					bodylist.get(i).remove("pricebodys");
				}
				pb.setBodys(bodylist);
				
			}
			if(result.get("syscode")!=null){
				pb.setMdmUser(new SysUser(result.get("syscode").toString(),result.get("username").toString(),result.get("password").toString()));
			}
		}catch(JsonParseException e){ 
			e.printStackTrace();
			throw new MdmException(CommException.PARAM_JSON_CODE,CommException.PARAM_JSON_MSG+"("+e.getMessage()+")");
		}catch(JsonMappingException e){ 
			e.printStackTrace();
			throw new MdmException(CommException.PARAM_JSON_CODE,CommException.PARAM_JSON_MSG+"("+e.getMessage()+")");
		}catch(IOException e){ 
			e.printStackTrace();
			throw new MdmException(CommException.PARAM_JSON_CODE,CommException.PARAM_JSON_MSG+"("+e.getMessage()+")");
		}catch (Exception e){
			e.printStackTrace();
			throw new MdmException(CommException.PARAM_JSON_PARSE_CODE,CommException.PARAM_JSON_PARSE_MSG);
		}
		 return pb;
	}
	
	public static String getIpAddr(HttpServletRequest request) {
	     String ipAddress = null;    
	     //ipAddress = this.getRequest().getRemoteAddr();    
	     ipAddress = request.getHeader("x-forwarded-for");    
	     if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {    
	      ipAddress = request.getHeader("Proxy-Client-IP");    
	     }   
	     if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {    
	         ipAddress = request.getHeader("WL-Proxy-Client-IP");    
	     }   
	     if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {    
	      ipAddress = request.getRemoteAddr();    
	     }
	     return ipAddress;     
	  }   
}
