package com.yujin.springboot.template;

import com.yujin.springboot.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("th")
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "thymeleaf-aaaa");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center(ModelMap map) {
        return "thymeleaf/center/center";
    }

    @RequestMapping("test")
    public String test(ModelMap map) {

        try {
            User u = new User();
            u.setName("zhangsan");
            u.setAge(23);
            u.setBirthday("2018-11-19");
            u.setDesc("<font color='green'><b>hello</b></font>");
            map.addAttribute("user", u);

            List<User> userList = new ArrayList();
            User zhangsan = new User();
            zhangsan.setName("张三");
            zhangsan.setAge(20);
            zhangsan.setBirthday("2018-11-01");
            userList.add(zhangsan);
            User lisi = new User();
            lisi.setName("李四");
            lisi.setAge(10);
            lisi.setBirthday("2018-11-02");
            userList.add(lisi);
            User wangwu = new User();
            wangwu.setName("王五");
            wangwu.setAge(30);
            wangwu.setBirthday("2018-11-03");
            userList.add(wangwu);
            User zhaoliu = new User();
            zhaoliu.setName("赵六");
            zhaoliu.setAge(18);
            zhaoliu.setBirthday("2018-11-04");
            userList.add(zhaoliu);
            map.addAttribute("userList", userList);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "thymeleaf/test";
    }

    @PostMapping("postform")
    public String postForm(User u) {
        System.out.println(u.getName());
        return "redirect:/th/test";
    }

    @RequestMapping("showerror")
    public String showError(User u) {
        int a = 1/0;
        return "redirect:/th/test";
    }
}
