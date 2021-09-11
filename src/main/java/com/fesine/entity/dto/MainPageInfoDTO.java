package com.fesine.entity.dto;

import com.fesine.entity.bo.HeadLine;
import com.fesine.entity.bo.ShopCategory;
import lombok.Data;

import java.util.List;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/11
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/11
 */
@Data
public class MainPageInfoDTO {

    private List<HeadLine> headLineList;

    private List<ShopCategory> shopCategoryList;
}
