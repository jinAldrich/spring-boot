package com.yujin.springboot.user;

import com.yujin.springboot.pojo.JSONResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

//@RestController = @RestController + @ResponseBody
//@Controller
@RestController
@RequestMapping("/user")
public class UserController {

//    @ResponseBody
    @RequestMapping("/getUser")
    public User getUser() {
        User u = new User();
        u.setName("lisi");
        u.setAge(10);
        u.setPwd("1234567");
        u.setBrithday(new Date());
        u.setDesc("测试");
        return u;
    }

    //    @ResponseBody
    @RequestMapping("/getUserJson")
    public JSONResult getUserJson() {
        User u = new User();
        u.setName("lisi");
        u.setAge(10);
        u.setPwd("1234567");
        u.setBrithday(new Date());
//        u.setDesc("");
        return JSONResult.ok(u);
    }
}
