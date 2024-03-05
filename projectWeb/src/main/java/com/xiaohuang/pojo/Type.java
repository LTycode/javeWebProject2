package com.xiaohuang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName c_type
 */
@TableName(value ="c_type")
@Data
public class Type implements Serializable {
    private Integer tid;

    private String tname;

    private static final long serialVersionUID = 1L;
}