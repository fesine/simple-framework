package com.fesine.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/9
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/9
 */
@Data
public class HeadLine {

    private Long lineId;

    private String lineName;

    private String lineLink;

    private String lineImg;

    private Integer priority;

    private Integer enableStatus;

    private Date createTime;

    private Date lastEditTime;
}
