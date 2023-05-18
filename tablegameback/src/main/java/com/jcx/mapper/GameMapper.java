package com.jcx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jcx.entity.Game;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GameMapper extends BaseMapper<Game> {
}
