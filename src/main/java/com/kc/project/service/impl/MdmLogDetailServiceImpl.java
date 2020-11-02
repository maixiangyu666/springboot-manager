package com.kc.project.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kc.project.mapper.MdmLogDetailMapper;
import com.kc.project.entity.MdmLogDetail;
import com.kc.project.service.MdmLogDetailService;


@Service("mdmLogDetailService")
public class MdmLogDetailServiceImpl extends ServiceImpl<MdmLogDetailMapper, MdmLogDetail> implements MdmLogDetailService {


}