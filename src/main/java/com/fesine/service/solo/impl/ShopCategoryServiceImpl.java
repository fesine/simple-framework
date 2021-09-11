package com.fesine.service.solo.impl;

import com.fesine.entity.bo.ShopCategory;
import com.fesine.entity.dto.Result;
import com.fesine.service.solo.ShopCategoryService;

import java.util.List;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/11
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/11
 */
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Override
    public Result<Boolean> addShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<Boolean> removeShopCategory(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<ShopCategory> queryShopCategoryById(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition,
                                                        int pageIndex, int pageSize) {
        return null;
    }
}
