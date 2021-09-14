package com.fesine.service.combine.impl;

import com.fesine.entity.bo.HeadLine;
import com.fesine.entity.bo.ShopCategory;
import com.fesine.entity.dto.MainPageInfoDTO;
import com.fesine.entity.dto.Result;
import com.fesine.service.combine.HeadLineShopCategoryCombineService;
import com.fesine.service.solo.HeadLineService;
import com.fesine.service.solo.ShopCategoryService;
import org.simpleframework.core.annotation.Service;

import java.util.List;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/12
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/12
 */
@Service
public class HeadLineShopCategoryCombineServiceImpl implements HeadLineShopCategoryCombineService {

    private HeadLineService headLineService;

    private ShopCategoryService shopCategoryService;

    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {
        //1、获取头条列表
        HeadLine headLineCondition = new HeadLine();
        headLineCondition.setEnableStatus(1);
        Result<List<HeadLine>> headLineResult = headLineService.queryHeadLine(headLineCondition, 1,
                4);
        //2、获取店铺类别列表
        ShopCategory shopCategoryCondition = new ShopCategory();
        Result<List<ShopCategory>> shopCategoryResult =
                shopCategoryService.queryShopCategory(shopCategoryCondition, 1, 100);
        //3、合并两者并返回
        Result<MainPageInfoDTO> result = mergeMainPageInfoResult(headLineResult, shopCategoryResult);
        return result;
    }

    private Result<MainPageInfoDTO> mergeMainPageInfoResult(Result<List<HeadLine>> headLineResult, Result<List<ShopCategory>> shopCategoryResult) {
        return null;
    }
}
