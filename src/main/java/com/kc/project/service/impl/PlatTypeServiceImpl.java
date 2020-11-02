package com.kc.project.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kc.project.mapper.PlatTypeMapper;
import com.kc.project.entity.PlatTypeEntity;
import com.kc.project.service.PlatTypeService;


@Service("platTypeService")
public class PlatTypeServiceImpl extends ServiceImpl<PlatTypeMapper, PlatTypeEntity> implements PlatTypeService {


}