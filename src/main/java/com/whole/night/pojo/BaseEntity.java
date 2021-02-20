package com.whole.night.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    protected Long id;
    protected Date gmt_create;
    protected Date gmt_modify;

}
