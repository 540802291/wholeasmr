package com.whole.night.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
 * lsy
 * 2020-2-21
 * 该处理器用于配置对象字段自动填充策略
 */
@Slf4j
@Component //加入到Spring容器中
public class AutoFillHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {  //插入时的填充策略
        log.info("insert fill");
        this.setFieldValByName("gmtCreate",new Date(),metaObject);
        this.setFieldValByName("gmtModify",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {   //更新时的填充策略
        log.info("update fill");
        this.setFieldValByName("gmtModify",new Date(),metaObject);
    }
}
