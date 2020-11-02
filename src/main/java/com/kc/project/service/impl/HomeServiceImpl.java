package com.kc.project.service.impl;

import com.kc.project.entity.SysDept;
import com.kc.project.entity.SysUser;
import com.kc.project.service.DeptService;
import com.kc.project.service.HomeService;
import com.kc.project.service.PermissionService;
import com.kc.project.service.UserService;
import com.kc.project.vo.resp.HomeRespVO;
import com.kc.project.vo.resp.PermissionRespNode;
import com.kc.project.vo.resp.UserInfoRespVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页
 *
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Resource
    private UserService userService;
    @Resource
    private DeptService deptService;
    @Resource
    private PermissionService permissionService;

    @Override
    public HomeRespVO getHomeInfo(String userId) {


        SysUser sysUser = userService.getById(userId);
        UserInfoRespVO vo = new UserInfoRespVO();

        if (sysUser != null) {
            BeanUtils.copyProperties(sysUser, vo);
            SysDept sysDept = deptService.getById(sysUser.getDeptId());
            if (sysDept != null) {
                vo.setDeptId(sysDept.getId());
                vo.setDeptName(sysDept.getName());
            }
        }

        List<PermissionRespNode> menus = permissionService.permissionTreeList(userId);

        HomeRespVO respVO = new HomeRespVO();
        respVO.setMenus(menus);
        respVO.setUserInfo(vo);

        return respVO;
    }
}
