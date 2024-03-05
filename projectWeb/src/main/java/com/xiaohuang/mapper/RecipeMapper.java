package com.xiaohuang.mapper;

import com.xiaohuang.pojo.Recipe;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohuang.vo.RecipeQuery;

import java.util.List;

/**
* @author changle
* @description 针对表【c_recipe】的数据库操作Mapper
* @createDate 2023-12-06 03:11:41
* @Entity com.xiaohuang.pojo.Recipe
*/
public interface RecipeMapper extends BaseMapper<Recipe> {

    List<Recipe> queryAll();

    List<Recipe> getRecipeList(RecipeQuery recipeQuery);

    Long getCount(RecipeQuery recipeQuery);

    int addRecipe(Recipe recipe);

    void deleteRecipeByIds(String ids);




    void updateRecipe(Recipe recipe);

    Recipe getRecipeById(Integer id);

    List<Recipe> getMenuByIds(String ids);
}




