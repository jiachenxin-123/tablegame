package com.jcx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jcx.mapper.GameMapper;
import com.jcx.entity.Game;
import com.jcx.service.GameService;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl extends ServiceImpl<GameMapper, Game> implements GameService {
}
