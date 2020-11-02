package com.kc.project.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kc.project.mapper.PlatformMapper;
import com.kc.project.entity.PlatformEntity;
import com.kc.project.service.PlatformService;


@Service("platformService")
public class PlatformServiceImpl extends ServiceImpl<PlatformMapper, PlatformEntity> implements PlatformService {


}