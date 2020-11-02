package com.kc.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kc.project.entity.PlatformEntity;
import com.kc.project.mapper.PlatformMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kc.project.mapper.ResourceMapper;
import com.kc.project.entity.ResourceEntity;
import com.kc.project.service.ResourceService;

import javax.annotation.Resource;
import java.util.*;


@Service("resourceService")
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, ResourceEntity> implements ResourceService {

    @Resource
    private ResourceMapper resourceMapper;
    @Resource
    private PlatformMapper platformMapper;

    @Override
    public List<ResourceEntity> selResourceByTypeId(String TypeId) {
        List<ResourceEntity> resourceEntities = resourceMapper.selResourceByTypeId(TypeId);
        return resourceEntities;
    }

    @Override
    public List<ResourceEntity> selPlatTypes(List<ResourceEntity> resources) {
        QueryWrapper queryWrapper=new QueryWrapper();
        List<PlatformEntity> list=new ArrayList<>();
        for (ResourceEntity resource : resources){
            list= platformMapper.listPlats(resource.getId());
            String str = extractName(list);
            resource.setPlatTypes(str);
        }
        return resources;
    }

    @Override
    public ResourceEntity selResourceDetail(String resourceId) {
        ResourceEntity  resource= resourceMapper.selResourceDetail(resourceId);
        List<PlatformEntity> platformEntities = resourceMapper.selPlatsById(resource.getId());
        resource.setPlatformEntitys(platformEntities);
        return resource;
    }


    private String extractName(List<PlatformEntity> plats){
        Set<String> set =new HashSet();
        plats.forEach(p->set.add(p.getPlattypename()));
        StringBuilder builder=new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String str = it.next();
            builder.append(" "+str);
        }
        return builder.toString();
    }

}