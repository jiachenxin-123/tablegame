package com.jcx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jcx.entity.Comment;
import com.jcx.mapper.CommentMapper;
import com.jcx.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
}
