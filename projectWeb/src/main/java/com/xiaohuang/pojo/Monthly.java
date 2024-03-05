package com.xiaohuang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * @TableName c_monthly
 */
@TableName(value ="c_monthly")
@Data
public class Monthly implements Serializable {
    private Integer msid;

    private Integer uid;

    private String name;

    private String creatime;

    private String unit;

    private String count;

    private Double price;

    private Double someprice;

    private Double sumprice;

    private static final long serialVersionUID = 1L;
}