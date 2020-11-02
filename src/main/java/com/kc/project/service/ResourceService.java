package com.kc.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.project.entity.ResourceEntity;

import java.util.List;

/**
 * 资源
 *
 * @author mxy
 * @email ${email}
 * @date 2020-10-17 16:17:41
 */
public interface ResourceService extends IService<ResourceEntity> {

    public List<ResourceEntity> selResourceByTypeId(String TypeId);


    public List<ResourceEntity> selPlatTypes(List<ResourceEntity> resource);


    public ResourceEntity  selResourceDetail(String resourceId);



}

