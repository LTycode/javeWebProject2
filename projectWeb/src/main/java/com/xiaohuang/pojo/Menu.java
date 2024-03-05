package com.xiaohuang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * @TableName c_menu
 */
@TableName(value ="c_menu")
@Data
public class Menu implements Serializable {
    private Integer mid;

    private String mname;

    private String mtype;

    private String mphoto;

    private String mnuit;

    private Double mprice;

    private String mstatus;

    private static final long serialVersionUID = 1L;
}