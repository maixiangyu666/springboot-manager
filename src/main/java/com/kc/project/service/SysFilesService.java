package com.kc.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.project.common.utils.DataResult;
import com.kc.project.entity.SysFilesEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文件上传 服务类
 *
 */
public interface SysFilesService extends IService<SysFilesEntity> {

    DataResult saveFile(MultipartFile file);

    void removeByIdsAndFiles(List<String> ids);
}

