package com.fesine.service.combine;

import com.fesine.entity.dto.MainPageInfoDTO;
import com.fesine.entity.dto.Result;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/11
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/11
 */
public interface HeadLineShopCategoryCombineService {

    Result<MainPageInfoDTO> getMainPageInfo();
}
