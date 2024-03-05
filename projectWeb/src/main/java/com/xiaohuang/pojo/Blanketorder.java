package com.xiaohuang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName c_blanketorder
 */
@TableName(value ="c_blanketorder")
@Data
public class Blanketorder implements Serializable {
    private Integer bid;

    private String bname;

    private String bcount;

    private String bcreatime;

    private static final long serialVersionUID = 1L;
}