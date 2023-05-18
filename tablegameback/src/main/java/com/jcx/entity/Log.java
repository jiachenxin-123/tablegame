package com.jcx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class Log {
    @TableId(type = IdType.AUTO)
    private int id;
    private String account;
    private String gamename;
    private String roomname;
    private float duration;
    private String start;
    private float money;
}
