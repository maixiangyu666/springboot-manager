package com.kc.project.service;

import com.kc.project.vo.resp.HomeRespVO;

/**
 * 首页
 *
 */
public interface HomeService {

    HomeRespVO getHomeInfo(String userId);
}
