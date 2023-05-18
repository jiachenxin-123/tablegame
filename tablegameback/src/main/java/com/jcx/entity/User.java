package com.jcx.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    @TableId("account")
    private String account;
    private String name;
    private String password;
    private String sex;
    private String phone;
    private int role = 0;

    public boolean isEmpty() {
        if (this.account.isEmpty() || this.name.isEmpty() || this.password.isEmpty() || this.sex.isEmpty() || this.phone.isEmpty())
            return true;
        return false;
    }
}
