package com.xiaohuang.vo;

import com.xiaohuang.utils.Page;
import lombok.Data;

@Data
public class RecipeQuery extends Page {
    private String rename;
    private Double minPrice;
    private Double maxPrice;
}
