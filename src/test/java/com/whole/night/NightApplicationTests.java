package com.whole.night;

import com.whole.night.entity.Resource;
import com.whole.night.mapper.ResourceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        resource.setAuthor("dxr");
        resource.setUrl("http://baidu.com");
        //参数是一个wrapper
        int insert = resourceMapper.insert(resource);//插入数据的返回值是受影响的行数
        //插入成功后id会通过雪花算法自动填入
    }

    @Test
    void select() {  //条件查询
        Map<String,Object> map = new HashMap();
        map.put("author","lsy");   //查询author为lsy并且url等于http://www.baidu.com的数据
        map.put("url","http://www.baidu.com");
        List<Resource> resources = resourceMapper.selectByMap(map);//通过map集合指定条件进行查询
        resources.forEach(System.out::print);
    }
}
