package com.whole.night.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whole.night.entity.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceMapper extends BaseMapper<Resource> {
}
