package com.kc.project.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kc.project.mapper.MdmLogMapper;
import com.kc.project.entity.MdmLog;
import com.kc.project.service.MdmLogService;


@Service("mdmLogService")
public class MdmLogServiceImpl extends ServiceImpl<MdmLogMapper, MdmLog> implements MdmLogService {


}