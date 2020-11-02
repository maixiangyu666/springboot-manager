package com.kc.base.utils;

import net.sf.json.JSONObject;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.Map;


public class JsonUtil {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(JsonParser.Feature.INTERN_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.CANONICALIZE_FIELD_NAMES, true);
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    public static String encode(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonGenerationException e) {
          //logger.error("encode(Object)", e); //$NON-NLS-1$
        } catch (JsonMappingException e) {
          //logger.error("encode(Object)", e); //$NON-NLS-1$
        } catch (IOException e) {
          //logger.error("encode(Object)", e); //$NON-NLS-1$
        }
        return null;
    }

    /**
     * 将json string反序列化成对象
     *
     * @param json
     * @param valueType
     * @return
     * @throws Exception 
     */
    public static <T> T decode(String json, Class<T> valueType) throws Exception {
        try {
            return objectMapper.readValue(json, valueType);
        } catch (JsonParseException e) {
        	e.printStackTrace();
        	throw e;
          //logger.error("decode(String, Class<T>)", e);
        } catch (JsonMappingException e) {
        	e.printStackTrace();
        	throw e;
          //logger.error("decode(String, Class<T>)", e);
        } catch (IOException e) {
        	e.printStackTrace();
        	throw e;
          //logger.error("decode(String, Class<T>)", e);
        }
    }

    /**
     * 将json array反序列化为对象
     *
     * @param json
     * @param
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T decode(String json, TypeReference<T> typeReference) {
        try {
            return (T) objectMapper.readValue(json, typeReference);
        } catch (JsonParseException e) {
          //logger.error("decode(String, JsonTypeReference<T>)", e);
        } catch (JsonMappingException e) {
          //logger.error("decode(String, JsonTypeReference<T>)", e);
        } catch (IOException e) {
          //logger.error("decode(String, JsonTypeReference<T>)", e);
        }
        return null;
    }
    public static Map<String, String> decode(String json,String path){
    	String[] p=path.split(".");
    	
    	return null;
    }
    /**
	 * 格式化
	 * @param jsonStr
	 * @return
	 * @author   lizhgb
	 * @Date   2015-10-14 下午1:17:35
	 */
    public static String formatJson(String jsonStr) {
        if (null == jsonStr || "".equals(jsonStr)) return "";
        StringBuilder sb = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        for (int i = 0; i < jsonStr.length(); i++) {
            last = current;
            current = jsonStr.charAt(i);
            switch (current) {
                case '{':
                case '[':
                    sb.append(current);
                    sb.append('\n');
                    indent++;
                    addIndentBlank(sb, indent);
                    break;
                case '}':
                case ']':
                    sb.append('\n');
                    indent--;
                    addIndentBlank(sb, indent);
                    sb.append(current);
                    break;
                case ',':
                    sb.append(current);
                    if (last != '\\') {
                        sb.append('\n');
                        addIndentBlank(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }

        return sb.toString();
    }

    /**
     * 添加space
     * @param sb
     * @param indent
     * @author   lizhgb
     * @Date   2015-10-14 上午10:38:04
     */
    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append('\t');
        }
    }
    
    /**
     * 从一个JSON 对象格式字符串中得到指定key对应的value(JSON格式字符串)值
     *      
     * @param jsonString json串
     * @param key JSON格式键值对中的key
     * @return String JSON格式字符串
     */
    public static String getNodeValue(String jsonString, String key) {
        return JSONObject.fromObject(jsonString).get(key).toString();
    }

}
