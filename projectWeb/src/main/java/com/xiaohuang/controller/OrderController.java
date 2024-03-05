package com.xiaohuang.controller;

import com.xiaohuang.pojo.Menu;
import com.xiaohuang.pojo.Recipe;
import com.xiaohuang.service.OrderService;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.MenuQurey;
import com.xiaohuang.vo.OrderQuery;
import com.xiaohuang.vo.RecipeQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping("")
    @ResponseBody
    public Result<Object> joinOrder(Menu menu,@Param("odcount") Integer odcount){
        System.out.println("menu = " + menu);
        System.out.println("mcount = " + odcount);
        int i=orderService.joinOrder(menu,odcount);

        return Result.success("添加订单成功！");
    }

    @GetMapping("orderui")
    public String toOrderListUI()
    {
        return "order/orderList";
    }


    @GetMapping("addorderUi")
    public String toAddOrderListUI()
    {
        return "order/orderAdd";
    }
    @GetMapping("myOrderList")
    @ResponseBody
    public Result myOrderList(OrderQuery orderQuery)
    {
        System.out.println("menuQurey = " + orderQuery);
        Result result=orderService.getOrderList(orderQuery);
        System.out.println("result = " + result);
        return result;
    }

    /**
     * 更新订单，由id和修改后的数量，调整点餐表的数量以及价格
     * @param id 改订餐表的食物id
     * @param count 修改后的数量
     * @return
     */
    @PostMapping("/{id}/{count}")
    @ResponseBody
    public Result updateOrderByIds(@PathVariable("id") String id,@PathVariable("count") Integer count)
    {
        Result result= orderService.updateOrderByIdAndCount(id,count);
        return result;
    }

    @PostMapping("/{ids}")
    @ResponseBody
    public Result deleteOrderById(@PathVariable("id") String id)
    {
        Result result= orderService.deleteOrderById(id);
        return result;
    }

    @GetMapping("addorderList")
    @ResponseBody
    public Result addorderList(MenuQurey menuQurey)
    {
        Result result=orderService.addorderList(menuQurey);
        return result;
    }


    @PostMapping("deleteOrderByIds/{ids}")
    @ResponseBody
    public Result deleteOrderByIds(@PathVariable("ids") String ids)
    {
        Result result= orderService.deleteOrderByIds(ids);

        return result;
    }
}
