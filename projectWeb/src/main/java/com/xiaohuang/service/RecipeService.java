package com.xiaohuang.service;

import com.xiaohuang.pojo.Recipe;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.RecipeQuery;

import java.util.List;

/**
* @author changle
* @description 针对表【c_recipe】的数据库操作Service
* @createDate 2023-12-06 03:11:41
*/
public interface RecipeService extends IService<Recipe> {

    Result getRecipeList(RecipeQuery recipeQuery);

    Result addRecipe(Recipe recipe);

    Result deleteRecipeByIds(String ids);

    Recipe getRecipeById(Integer id);

    void updateRecipe(Recipe recipe);
}
