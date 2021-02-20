package com.whole.night;

import com.whole.night.entity.Resource;
import com.whole.night.mapper.ResourceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class NightApplicationTests {

    @Autowired
    private ResourceMapper resourceMapper;

    @Test
    void selectList() {
        //参数是一个wrapper
        List<Resource> resources = resourceMapper.selectList(null);  //wrapper条件为空查询全部
        resources.forEach(System.out::print);
    }

    @Test
    void insert() {
        Resource resource = new Resource();
        resource.setAuthor("lsy");
        resource.setGmt_create(new Date(System.currentTimeMillis()));
        resource.setUrl("http://baidu.com");
        //参数是一个wrapper
        int insert = resourceMapper.insert(resource);//插入数据的返回值是受影响的行数
        //插入成功后id会通过雪花算法自动填入
    }

}
