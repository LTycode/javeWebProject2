package com.xiaohuang.vo;

import com.xiaohuang.utils.Page;
import lombok.Data;

@Data
public class OrderQuery extends Page {
    private String oname;
    private Integer ostatus=1;
    private Double minPrice;
    private Double maxPrice;
}
