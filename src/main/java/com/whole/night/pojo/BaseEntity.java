package com.whole.night.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    protected Long id;
    @TableField(fill = FieldFill.INSERT)   //在被插入时该字段会被自动填充，填充策略需要被编写才能生效
    protected Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)   //在被插入或更新时该字段会被自动填充，填充策略需要被编写才能生效
    protected Date gmtModify;

}
