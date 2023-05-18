package com.jcx.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Game {
    private int id;
    private String name;
    private float time;
    private float price;
    private int min;
    private int max;
    private String text;
}
