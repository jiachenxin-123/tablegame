package com.jcx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jcx.mapper.LogMapper;
import com.jcx.entity.Log;
import com.jcx.service.LogService;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {
}
