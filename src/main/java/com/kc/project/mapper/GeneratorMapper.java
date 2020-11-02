package com.kc.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kc.project.entity.SysGenerator;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 代码生成 Mapper
 * @author mxy
 * @email ${email}
 * @date 2020-4-25 09:28:13
 */
public interface GeneratorMapper extends BaseMapper<SysGenerator> {

    IPage<SysGenerator> selectAllTables(Page<SysGenerator> page, @Param(value = "vo") SysGenerator vo);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}
