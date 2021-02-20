package com.whole.night.entity;
import com.whole.night.pojo.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource extends BaseEntity {   //数据库实体Resource

    private Long hits;
    private Long collect;
    private String author;
    private String category;
    private String url;

}
