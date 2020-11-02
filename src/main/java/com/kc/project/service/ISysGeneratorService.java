package com.kc.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kc.project.entity.SysGenerator;

/**
 * 代码生成
 *

 */
public interface ISysGeneratorService {


    IPage<SysGenerator> selectAllTables(Page<SysGenerator> page, SysGenerator vo);

    byte[] generatorCode(String[] split);
}
