package com.kc.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.project.entity.SysPermission;
import com.kc.project.vo.resp.PermissionRespNode;

import java.util.List;
import java.util.Set;

/**
 * 菜单权限
 *
 */
public interface PermissionService extends IService<SysPermission> {

    List<SysPermission> getPermission(String userId);

    void deleted(String permissionId);

    List<SysPermission> selectAll();

    Set<String> getPermissionsByUserId(String userId);

    List<PermissionRespNode> permissionTreeList(String userId);

    List<PermissionRespNode> selectAllByTree();

    List<PermissionRespNode> selectAllMenuByTree(String permissionId);

}
