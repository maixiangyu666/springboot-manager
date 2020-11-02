package com.kc.project.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kc.project.mapper.UserServiceMapper;
import com.kc.project.entity.UserService;
import com.kc.project.service.UserServiceService;


@Service("userServiceService")
public class UserServiceServiceImpl extends ServiceImpl<UserServiceMapper, UserService> implements UserServiceService {


}