package com.whole.night.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String openid;
    private String nick;
    private String gender;
    private String avatar;
    @TableField(fill = FieldFill.INSERT)   //在被插入时该字段会被自动填充，填充策略需要被编写才能生效
    protected Date gmtCreate;

}
