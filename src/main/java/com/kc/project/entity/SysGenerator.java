package com.kc.project.entity;

import java.util.Date;
import java.io.Serializable;

import com.kc.project.vo.req.PageReqVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 代码生成
 *
 * @date 2020年3月18日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysGenerator extends PageReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tableName;

    private Date createTime;

    private String tableComment;

}
