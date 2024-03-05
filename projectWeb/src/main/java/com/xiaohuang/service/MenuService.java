package com.xiaohuang.service;

import com.xiaohuang.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.MenuQurey;
import com.xiaohuang.vo.RecipeQuery;

/**
* @author changle
* @description 针对表【c_menu】的数据库操作Service
* @createDate 2023-12-06 03:11:41
*/
public interface MenuService extends IService<Menu> {

    Result createMenuByIds(String ids);

    Result getMenuList(MenuQurey menuQurey);

    Menu getMenuById(Integer id);

    Result getRecipeNotMenu(RecipeQuery recipeQuery);


    Result addMenuByIds(String ids);

    Result deletemenuByIds(String ids);
}
