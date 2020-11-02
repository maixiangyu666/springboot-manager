package com.kc.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.project.entity.SysDept;
import com.kc.project.vo.resp.DeptRespNodeVO;

import java.util.List;

/**
 * 部门
 *
 */
public interface DeptService extends IService<SysDept> {

    SysDept addDept(SysDept vo);

    void updateDept(SysDept vo);

    void deleted(String id);

    List<DeptRespNodeVO> deptTreeList(String deptId);

    List<SysDept> selectAll();
}
