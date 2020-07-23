package cn.pealipala.vhr.controller;

import cn.pealipala.vhr.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/6/20 19:13
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("请先登录");
    }
}
