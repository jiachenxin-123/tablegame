package com.jcx.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Room {
    private int id;
    private String name;
    private int min;
    private int max;
    private int state;
}
