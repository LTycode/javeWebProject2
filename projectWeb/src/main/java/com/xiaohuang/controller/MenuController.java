package com.xiaohuang.controller;


import com.xiaohuang.pojo.Menu;
import com.xiaohuang.pojo.Recipe;
import com.xiaohuang.service.MenuService;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.MenuQurey;
import com.xiaohuang.vo.RecipeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @GetMapping("")
    public String toMenuListUI()
    {
        return "menu/menuList";
    }
    @GetMapping("addmenu")
    public String toAddMenuUI()
    {
        return "menu/addMenu";
    }


    @GetMapping("addmenuList")
    @ResponseBody
    public Result addmenuList(RecipeQuery recipeQuery)
    {
        Result result=menuService.getRecipeNotMenu(recipeQuery);
        return result;
    }

    @GetMapping("menulist")
    @ResponseBody
    public Result MenuList(MenuQurey menuQurey)
    {
        System.out.println("menuQurey = " + menuQurey);
        Result result=menuService.getMenuList(menuQurey);
        System.out.println("result = " + result);
        return result;
    }

    /**
     * var url = ctxPath + "menu/creatmenu" + idArr.join(",");
     * @param ids 根据选择的食谱id生成对应的菜单
     * @return
     */
    @PostMapping("/{ids}")
    @ResponseBody
    public Result createMenuByIds(@PathVariable("ids") String ids)
    {
        Result result= menuService.createMenuByIds(ids);

        return result;
    }


    @PostMapping("deleteByIds/{ids}")
    @ResponseBody
    public Result deletemenuByIds(@PathVariable("ids") String ids)
    {
        Result result= menuService.deletemenuByIds(ids);

        return result;
    }


    @PostMapping("addmenuByIds/{ids}")
    @ResponseBody
    public Result addmenuByIds(@PathVariable("ids") String ids)
    {
        Result result= menuService.addMenuByIds(ids);

        return result;
    }






    @GetMapping("/{id}")
    public String getMenuById(@PathVariable("id") Integer id, Model model){
        Menu menu = menuService.getMenuById(id);
        model.addAttribute("menu",menu);
        return "order/joinOrder";
    }
}
