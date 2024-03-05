package com.xiaohuang.vo;

import com.xiaohuang.utils.Page;
import lombok.Data;

@Data
public class MenuQurey extends Page {
    private String mname;
    private Integer mstatus=1;
    private Double minPrice;
    private Double maxPrice;
}
