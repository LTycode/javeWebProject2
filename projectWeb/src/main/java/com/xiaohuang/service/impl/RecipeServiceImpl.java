package com.xiaohuang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohuang.pojo.Recipe;
import com.xiaohuang.service.RecipeService;
import com.xiaohuang.mapper.RecipeMapper;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.RecipeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.SourceVersion;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author changle
* @description 针对表【c_recipe】的数据库操作Service实现
* @createDate 2023-12-06 03:11:41
*/
@Service
public class RecipeServiceImpl extends ServiceImpl<RecipeMapper, Recipe>
    implements RecipeService{

    @Autowired
    private RecipeMapper recipeMapper;
    @Override
    public Result getRecipeList(RecipeQuery recipeQuery) {

        List<Recipe> recipes =recipeMapper.getRecipeList(recipeQuery);
        System.out.println("recipes = " + recipes);
        Long count = recipeMapper.getCount(recipeQuery);

        return Result.success(recipes,count);
    }

    @Override
    public Result addRecipe(Recipe recipe) {
        int insert = recipeMapper.addRecipe(recipe);
        return Result.success("添加成功");
    }

    @Override
    public Result deleteRecipeByIds(String ids) {
       recipeMapper.deleteRecipeByIds(ids);
        return Result.success("删除成功");
    }

    @Override
    public Recipe getRecipeById(Integer id) {

        Recipe recipe = recipeMapper.getRecipeById(id);
        return recipe;
    }

    @Override
    public void updateRecipe(Recipe recipe) {

        recipeMapper.updateRecipe(recipe);

    }


}




