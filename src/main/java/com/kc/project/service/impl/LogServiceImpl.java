package com.kc.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.project.entity.SysLog;
import com.kc.project.mapper.SysLogMapper;
import com.kc.project.service.LogService;
import org.springframework.stereotype.Service;

/**
 * 系统日志
 *
 */
@Service
public class LogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements LogService {
}
