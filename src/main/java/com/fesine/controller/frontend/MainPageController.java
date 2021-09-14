package com.fesine.controller.frontend;

import com.fesine.entity.dto.MainPageInfoDTO;
import com.fesine.entity.dto.Result;
import com.fesine.service.combine.HeadLineShopCategoryCombineService;
import org.simpleframework.core.annotation.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/12
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/12
 */
@Controller
public class MainPageController {

    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;

    public Result<MainPageInfoDTO>  getMainPageInfo(HttpServletRequest req, HttpServletResponse resp){
        Result<MainPageInfoDTO> mainPageInfo = headLineShopCategoryCombineService.getMainPageInfo();
        return mainPageInfo;
    }

}
