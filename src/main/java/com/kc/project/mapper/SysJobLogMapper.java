package com.kc.project.mapper;

import com.kc.project.entity.SysJobLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志、 Mapper
 * @author mxy
 * @email ${email}
 * @date 2020-10-19 09:28:13
 */
@Mapper
public interface SysJobLogMapper extends BaseMapper<SysJobLogEntity> {
	
}
