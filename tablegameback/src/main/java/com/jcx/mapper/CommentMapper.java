package com.jcx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jcx.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
