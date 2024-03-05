package com.xiaohuang.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @TableName c_orderform
 */
@NoArgsConstructor
@AllArgsConstructor
@TableName(value ="c_orderform")
@Data
public class Orderform implements Serializable {
    private Integer ofid;

    private Integer oid;

   private Integer uid;


    private String creatime;

    private Double odmomey;

    private static final long serialVersionUID = 1L;

    public Orderform(Integer oid, Integer uid, String creatime, Double odmomey) {
        this.oid = oid;
        this.uid = uid;
        this.creatime = creatime;
        this.odmomey = odmomey;
    }
}