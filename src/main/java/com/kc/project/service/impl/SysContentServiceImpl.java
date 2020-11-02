package com.kc.project.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kc.project.mapper.SysContentMapper;
import com.kc.project.entity.SysContentEntity;
import com.kc.project.service.SysContentService;

/**
 * 内容 服务类
 *
 */
@Service("sysContentService")
public class SysContentServiceImpl extends ServiceImpl<SysContentMapper, SysContentEntity> implements SysContentService {


}