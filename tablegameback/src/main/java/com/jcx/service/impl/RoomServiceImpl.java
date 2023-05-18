package com.jcx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jcx.mapper.RoomMapper;
import com.jcx.entity.Room;
import com.jcx.service.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
}
