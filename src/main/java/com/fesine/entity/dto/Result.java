package com.fesine.entity.dto;

import lombok.Data;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/11
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/11
 */
@Data
public class Result<T> {

    /**
     * 本次请求结果的状态码，200表示成功
     */
    private int code;

    /**
     * 本次请求结果的消息
     */
    private String msg;

    /**
     * 本次请求返回的结果集
     */
    private T data;
}
