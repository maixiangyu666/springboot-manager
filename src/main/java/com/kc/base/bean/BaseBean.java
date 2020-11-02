package com.kc.base.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Author: Ma
 * @Date:2020-10-19 10:18
 */
public class BaseBean {



    public void writeLog(Object paramObject)
    {
        writeLog(super.getClass().getName(), paramObject);
    }



    public void writeLog(String paramString, Object paramObject) {
        Log localLog = LogFactory.getLog(paramString);
        if (paramObject instanceof Exception)
            localLog.error(paramString, (Exception)paramObject);
        else
            localLog.error(paramObject);
    }
}
