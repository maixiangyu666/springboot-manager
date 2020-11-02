package com.kc.project.mapper;

import com.kc.project.entity.PlatformEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 平台及其URL
 * 
 * @author mxy
 * @email ${email}
 * @date 2020-10-17 17:50:09
 */
@Mapper
public interface PlatformMapper extends BaseMapper<PlatformEntity> {

    public List<PlatformEntity> listPlats(String resourceid);
	
}
