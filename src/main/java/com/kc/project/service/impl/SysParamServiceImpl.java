package com.kc.project.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kc.project.mapper.SysParamMapper;
import com.kc.project.entity.SysParamEntity;
import com.kc.project.service.SysParamService;


@Service("sysParamService")
public class SysParamServiceImpl extends ServiceImpl<SysParamMapper, SysParamEntity> implements SysParamService {


}