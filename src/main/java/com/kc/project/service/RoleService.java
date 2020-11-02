package com.kc.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.project.entity.SysRole;

import java.util.List;

/**
 * 角色
 *
 */
public interface RoleService  extends IService<SysRole> {

    SysRole addRole(SysRole vo);

    void updateRole(SysRole vo);

    SysRole detailInfo(String id);

    void deletedRole(String id);

    List<SysRole> getRoleInfoByUserId(String userId);

    List<String> getRoleNames(String userId);

    List<SysRole> selectAllRoles();

}
