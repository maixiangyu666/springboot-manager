package com.kc.base.bean;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author fyt
 *
 */
public class ParseXml extends BaseBean{ 
    private Document document;  
     
    public ParseXml(String xml) throws DocumentException {      
    	SAXReader saxReader = new SAXReader();
		document = saxReader.read(new StringReader(xml));
    }   
     
    private void load(String filePath){
        File file = new File(filePath);
        if (file.exists()) {
            SAXReader saxReader = new SAXReader();
            try {
                document = saxReader.read(file);
            } catch (DocumentException e) {     
            	writeLog("文件加载异常：" + filePath);               
            }
        } else{
           writeLog("文件不存在 : " + filePath);
        }           
    }   
     
    public Element getElementObject(String elementPath) {
        return (Element) document.selectSingleNode(elementPath);
    }   
    public Map<String, String> getElementMap(String elementPath) {
        return getChildrenInfoByElement((Element) document.selectSingleNode(elementPath));
    } 
    @SuppressWarnings("unchecked")
    public List<Element> getElementObjects(String elementPath) {
        return document.selectNodes(elementPath);
    }
    public List<Map<String, String>> getChildrenInfoByElement(String elementPath){
        List<Element> e = document.selectNodes(elementPath);
        List<Map<String, String>> ret = new ArrayList<Map<String,String>>();
        for (Element ele : e) {
        	ret.add(getChildrenInfoByElement(ele));
        }
        return ret;
    }
    @SuppressWarnings("unchecked")
    public Map<String, String> getChildrenInfoByElement(Element element){
    	if(element==null){
    		return null;
    	}
        Map<String, String> map = new HashMap<String, String>();
        List<Element> children = element.elements();
        for (Element e : children) {
        	writeLog(e.getName()+"："+e.getText());
            map.put(e.getName(), e.getText());
        }
        return map;
    }
     
    public boolean isExist(String elementPath){
        boolean flag = false;
        Element element = this.getElementObject(elementPath);
        if(element != null) flag = true;
        return flag;
    }
 
    public String getElementText(String elementPath) {
        Element element = this.getElementObject(elementPath);
        if(element != null){
            return element.getText().trim();
        }else{
            return null;
        }       
    }
//     
//    public static void main(String[] args) {
//         
//        ParseXml px = new ParseXml("config/TestBaidu.xml");
//        List<Element> elements = px.getElementObjects("/*/testUI");
//         
//    }
     public List<Map<String, String>> getTwoChildrenElement(String elementPath1,String elementPath2){
    	 List<Map<String, String>> req = new ArrayList<Map<String,String>>();
    	 List<Element> list = document.selectNodes(elementPath1);
			for (Element el : list) {
				List<Element> el2 =  el.selectNodes(elementPath2);
				for (Element element : el2) {
					List<Element> ems = element.elements();
					Map<String, String> map = new HashMap<String, String>();
					for (Element element2 : ems) {
						map.put(element2.getName(), element2.getText());
						System.out.println(element2.getName()+":"+ element2.getText());
					}
					req.add(map);
				}
			}
			return req;
     }
}