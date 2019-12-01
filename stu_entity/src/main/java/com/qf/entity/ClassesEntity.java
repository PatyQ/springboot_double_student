package com.qf.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("classes")
public class ClassesEntity extends BaseEntity{

//    与数据库相同可不加
    @TableField("cname")
    private String cname;

    private Integer cnum;

}
