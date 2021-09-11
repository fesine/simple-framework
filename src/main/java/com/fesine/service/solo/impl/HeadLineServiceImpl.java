package com.fesine.service.solo.impl;

import com.fesine.entity.bo.HeadLine;
import com.fesine.entity.dto.Result;
import com.fesine.service.solo.HeadLineService;

import java.util.List;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/11
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/11
 */
public class HeadLineServiceImpl implements HeadLineService {
    @Override
    public Result<Boolean> addHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<Boolean> removeHeadLine(int headLineId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<HeadLine> queryHeadLineById(int headLineId) {
        return null;
    }

    @Override
    public Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex,
                                                int pageSize) {
        return null;
    }
}
