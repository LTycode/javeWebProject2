package com.xiaohuang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName c_user
 */
@TableName(value ="c_user")
@Data
public class User implements Serializable {
    private Integer uid;

    private String nickName;

    private String username;

    private String password;

    private String phone;

    private Integer role;

    private static final long serialVersionUID = 1L;
}