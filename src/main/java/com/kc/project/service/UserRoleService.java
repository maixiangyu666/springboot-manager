package com.kc.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.project.entity.SysUserRole;
import com.kc.project.vo.req.UserRoleOperationReqVO;

import java.util.List;

/**
 * 用户角色 服务类
 *
 */
public interface UserRoleService  extends IService<SysUserRole> {

    List<String> getRoleIdsByUserId(String userId);

    void addUserRoleInfo(UserRoleOperationReqVO vo);

    List<String> getUserIdsByRoleId(String roleId);
}
