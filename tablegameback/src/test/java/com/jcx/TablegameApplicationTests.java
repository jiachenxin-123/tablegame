package com.jcx;

import com.jcx.entity.Game;
import com.jcx.entity.Log;
import com.jcx.service.GameService;
import com.jcx.service.LogService;
import com.jcx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class TablegameApplicationTests {

    @Autowired
    private LogService logService;

    @Test
    void contextLoads() throws ParseException {
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("account","12345678");

        List<Log> logs = logService.listByMap(hashMap);
        for (Log log:
             logs) {
            System.out.println(log.getStart());
        }
    }
}
