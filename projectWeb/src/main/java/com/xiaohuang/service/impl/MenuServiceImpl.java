package com.xiaohuang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohuang.mapper.HistoricalmenuMapper;
import com.xiaohuang.mapper.RecipeMapper;
import com.xiaohuang.pojo.Menu;
import com.xiaohuang.pojo.Recipe;
import com.xiaohuang.service.MenuService;
import com.xiaohuang.mapper.MenuMapper;
import com.xiaohuang.service.RecipeService;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.MenuQurey;
import com.xiaohuang.vo.RecipeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.SourceVersion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
* @author changle
* @description 针对表【c_menu】的数据库操作Service实现
* @createDate 2023-12-06 03:11:41
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RecipeMapper recipeMapper;
    @Autowired
    private HistoricalmenuMapper historicalmenuMapper;
    @Override
    public Result createMenuByIds(String ids) {
        //1.根据id获得这些id的食品
       List<Recipe> recipes= recipeMapper.getMenuByIds(ids);
       //将菜单的status为1的放入历史菜单中
        //2.1 获取菜单status为1的的mid
        List<Integer> mids=menuMapper.getmids();
        if(!mids.isEmpty())
        {
            //2.2将菜单status为1的的mid插入到历史菜单表中
            //创建时间
            LocalDate localDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String creatime = localDate.format(formatter);
            int count= historicalmenuMapper.insertBymenu(mids,creatime);
        }

       //将以前菜单的status都置为0
       int i1=menuMapper.setStatus();
       //把要生成菜单的菜品放到菜单表中
       int i=menuMapper.insertMenuForRecipe(recipes);

        return Result.success("成功生成");
    }

    @Override
    public Result getMenuList(MenuQurey menuQurey) {
        List<Menu> menus =menuMapper.getMenuList(menuQurey);


        System.out.println("recipes = " + menus);
        Long count = menuMapper.getCount(menuQurey);

        return Result.success(menus,count);
    }

    @Override
    public Menu getMenuById(Integer id) {
        Menu menu=menuMapper.getMenuById(id);
        System.out.println("menu = " + menu);
        return menu;
    }

    @Override
    public Result getRecipeNotMenu(RecipeQuery recipeQuery) {
        //获取在食谱中没有添加到菜单的菜品信息
        List<Recipe> recipes=menuMapper.getRecipeNotMenu();
        if(recipes.isEmpty())
        {
            //如果没有菜品可添加的话
            return Result.success(null,0L);
        }else{
            //如果还有菜品可以添加
            int count =recipes.size();
            return Result.success(recipes, (long) count);
        }
    }

    @Override
    public Result addMenuByIds(String ids) {
        List<Recipe> recipes= recipeMapper.getMenuByIds(ids);

        int i=menuMapper.insertMenuForRecipe(recipes);
        System.out.println("i = " + i);

        return Result.success("成功添加");
    }

    @Override
    public Result deletemenuByIds(String ids) {
        int i=menuMapper.deletemenuByIds(ids);
        if(i!=0)
        {
            return Result.success("删除成功");
        }else{
            return Result.success("没有");
        }

    }


}




