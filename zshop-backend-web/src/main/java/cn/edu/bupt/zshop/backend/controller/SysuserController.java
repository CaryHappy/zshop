package cn.edu.bupt.zshop.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author： Cary Chen
 * Date： 2018-11-04 下午 7:54
 * Description： <描述>
 */
@Controller
@RequestMapping("/backend/sysuser")
public class SysuserController {

    @RequestMapping("/login")
    public String login(){
        //实现登录

        return "main";
    }
}
