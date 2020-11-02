package com.kc.project.mapper;

import com.kc.project.entity.PlatformEntity;
import com.kc.project.entity.ResourceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 资源
 * 
 * @author mxy
 * @email ${email}
 * @date 2020-10-17 16:17:41
 */
@Mapper
public interface ResourceMapper extends BaseMapper<ResourceEntity> {

    public List<ResourceEntity> selResourceByTypeId(String TypeId);

    public ResourceEntity  selResourceDetail(String resourceId);


    public List<PlatformEntity> selPlatsById(String resourceId);



	
}
