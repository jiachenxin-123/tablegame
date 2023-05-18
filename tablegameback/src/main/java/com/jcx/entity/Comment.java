package com.jcx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Comment {
    @TableId(type = IdType.AUTO)
    private int id;
    private String useraccount;
    private String username;
    private String comment;
    private int star;
}
