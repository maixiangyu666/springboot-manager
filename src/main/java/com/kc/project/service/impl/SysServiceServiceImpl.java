package com.kc.project.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kc.project.mapper.SysServiceMapper;
import com.kc.project.entity.SysServiceEntity;
import com.kc.project.service.SysServiceService;


@Service("sysServiceService")
public class SysServiceServiceImpl extends ServiceImpl<SysServiceMapper, SysServiceEntity> implements SysServiceService {


}