package com.xiaohuang.mapper;

import com.xiaohuang.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohuang.pojo.Recipe;
import com.xiaohuang.vo.MenuQurey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author changle
* @description 针对表【c_menu】的数据库操作Mapper
* @createDate 2023-12-06 03:11:41
* @Entity com.xiaohuang.pojo.Menu
*/
public interface MenuMapper extends BaseMapper<Menu> {

    int insertMenuForRecipe(@Param("recipes") List<Recipe> recipes);

    int setStatus();

    List<Menu> getMenuList(MenuQurey menuQurey);

    Long getCount(MenuQurey menuQurey);

    Menu getMenuById(Integer id);

    List<Recipe> getRecipeNotMenu();

    int deletemenuByIds(String ids);

    List<Integer> getmids();
}




