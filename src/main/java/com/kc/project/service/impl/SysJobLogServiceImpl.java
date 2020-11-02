package com.kc.project.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kc.project.mapper.SysJobLogMapper;
import com.kc.project.entity.SysJobLogEntity;
import com.kc.project.service.SysJobLogService;

/**
 * 定时任务 服务类
 *

 */
@Service("sysJobLogService")
public class SysJobLogServiceImpl extends ServiceImpl<SysJobLogMapper, SysJobLogEntity> implements SysJobLogService {


}