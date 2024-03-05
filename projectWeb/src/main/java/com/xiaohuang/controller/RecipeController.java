package com.xiaohuang.controller;


import com.xiaohuang.pojo.Recipe;
import com.xiaohuang.service.RecipeService;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.RecipeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("recipe")
public class RecipeController {


    @Autowired
    private RecipeService recipeService;


    /**
     *  "title": "食谱管理",
     *           "href": ""
     *  点击食谱管理跳转到这里
     * @return 返回html页面
     */
    @GetMapping("")
    public String toRecipeListUI()
    {
        return "recipe/recipeList";
    }

    /**
     *  url:  ctxPath + 'recipe/recipelist' //数据接口
     *  遍历食谱并分页
     * @param recipeQuery
     * @return
     */
    @GetMapping("recipelist")
    @ResponseBody
    public Result recipeList(RecipeQuery recipeQuery)
    {
       Result result=recipeService.getRecipeList(recipeQuery);
        System.out.println("result = " + result);
       return result;
    }

    /**
     * var url = ctxPath + "recipe/add";
     * @param recipe 新增的食谱的信息
     * @return 返回是否添加成功
     */
    @PostMapping("add")
    @ResponseBody
    public Result addRecipe(Recipe recipe)
    {
        Result result=recipeService.addRecipe(recipe);
        return result;
    }


    /**
     *   content: ctxPath  + 'recipe/addRecipeUi'
     *   点击新增，添加食谱跳转
     * @return 跳转到添加页面
     */
    @GetMapping("addRecipeUi")
    public String addRecipeUi()
    {
        return "recipe/recipeAdd";
    }

    /**
     * var url = ctxPath + "recipe/" + idArr.join(",");
     * @param ids 要删除的数据的id
     * @return  是否删除成功
     */
    @PostMapping("/{ids}")
    @ResponseBody
    public Result deleteRecipeByIds(@PathVariable("ids") String ids)
    {
        Result result= recipeService.deleteRecipeByIds(ids);
       return result;
    }


    /**
     * content: ctxPath  + 'recipe/' + data.reid
     * 根据id编辑当前id的食谱
     * @param id 返回的id
     * @param model
     * @return 跳转到编辑页面
     */
    @GetMapping("/{id}")
    public String getRecipeById(@PathVariable("id") Integer id,Model model){
        Recipe recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe",recipe);
        return "recipe/recipeEdit";
    }

    /**
     * var url = ctxPath + "recipe";
     * 编辑表单提交按钮
     * @param recipe
     * @return
     */
    @RequestMapping("")
    @ResponseBody
    public Result<Object> updateRecipe(Recipe recipe){
        recipeService.updateRecipe(recipe);
        return Result.success("员工信息修改成功！");
    }


}
