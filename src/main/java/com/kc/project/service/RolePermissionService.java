package com.kc.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.project.entity.SysRolePermission;
import com.kc.project.vo.req.RolePermissionOperationReqVO;

/**
 * 角色权限关联
 *

 */
public interface RolePermissionService extends IService<SysRolePermission> {

    void addRolePermission(RolePermissionOperationReqVO vo);
}
