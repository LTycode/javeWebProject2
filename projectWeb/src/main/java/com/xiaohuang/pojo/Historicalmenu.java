package com.xiaohuang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName c_historicalmenu
 */
@TableName(value ="c_historicalmenu")
@Data
public class Historicalmenu implements Serializable {
    private Integer hmid;

    private Integer mid;

    private String hmcreatetime;

    private static final long serialVersionUID = 1L;
}