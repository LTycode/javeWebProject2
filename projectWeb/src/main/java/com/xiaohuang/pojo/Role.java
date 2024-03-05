package com.xiaohuang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName c_role
 */
@TableName(value ="c_role")
@Data
public class Role implements Serializable {
    private Integer rid;

    private String rname;

    private static final long serialVersionUID = 1L;
}