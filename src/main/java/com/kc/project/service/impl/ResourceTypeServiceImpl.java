package com.kc.project.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kc.project.mapper.ResourceTypeMapper;
import com.kc.project.entity.ResourceTypeEntity;
import com.kc.project.service.ResourceTypeService;


@Service("resourceTypeService")
public class ResourceTypeServiceImpl extends ServiceImpl<ResourceTypeMapper, ResourceTypeEntity> implements ResourceTypeService {


}