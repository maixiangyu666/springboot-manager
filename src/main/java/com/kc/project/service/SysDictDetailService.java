package com.kc.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.project.entity.SysDictDetailEntity;

/**
 * 数据字典 服务类
 *
 */
public interface SysDictDetailService extends IService<SysDictDetailEntity> {

    IPage<SysDictDetailEntity> listByPage(Page<SysDictDetailEntity> page, String dictId);
}

