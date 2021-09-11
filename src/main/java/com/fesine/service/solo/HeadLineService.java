package com.fesine.service.solo;

import com.fesine.entity.bo.HeadLine;
import com.fesine.entity.dto.Result;

import java.util.List;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/11
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/11
 */
public interface HeadLineService {

    Result<Boolean> addHeadLine(HeadLine headLine);

    Result<Boolean> removeHeadLine(int headLineId);

    Result<Boolean> modifyHeadLine(HeadLine headLine);

    Result<HeadLine> queryHeadLineById(int headLineId);

    Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize);
}
