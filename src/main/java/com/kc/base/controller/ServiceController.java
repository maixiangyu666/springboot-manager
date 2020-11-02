
package com.kc.base.controller;


import com.kc.base.bean.BaseBean;
import com.kc.base.bean.Response;
import com.kc.base.utils.DateUtils;
import com.kc.project.service.MdmLogService;
import com.kc.project.service.SysServiceService;
import com.kc.project.service.UserServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/mdmServices")
public class ServiceController extends BaseBean {

	@Resource(name = "sysServiceService")
	private SysServiceService sysServiceService;
	
	@Resource(name = "mdmLogService")
	private MdmLogService mdmLogService;
	
	@Resource(name = "userServiceService")
	private UserServiceService userServiceService;


    @RequestMapping(value = "/{serviceCode}", method = {RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody
    Response server(@RequestParam("token") String token, @PathVariable String serviceCode, @RequestBody String requestBody, HttpServletRequest request) {
        writeLog("serviceCode:"+serviceCode);
        writeLog("requestBody:"+requestBody);
        Response rep=null;
        String serviceid=null;
        String stime= DateUtils.getNowTime("yyyy-MM-dd HH:mm:ss.SSS");





      return  null;
     }
	

}
