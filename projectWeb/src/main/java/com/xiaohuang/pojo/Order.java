package com.xiaohuang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * @TableName c_order
 */
@TableName(value ="c_order")
@Data
public class Order implements Serializable {
    private Integer oid;

    private String oname;

    private String ounit;

    private String ocount;

    private Double oprice;

    private Double osomeprice;

    private String ostatus;

    private static final long serialVersionUID = 1L;
}