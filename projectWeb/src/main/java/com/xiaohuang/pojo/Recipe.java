package com.xiaohuang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * @TableName c_recipe
 */
@TableName(value ="c_recipe")
@Data
public class Recipe implements Serializable {
    private Integer reid;

    private String rename;

    private String rephoto;

    private BigDecimal reprice;

    private String reinstructions;

    private String retype;

    private String reunit;

    private static final long serialVersionUID = 1L;
}