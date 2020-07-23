package cn.pealipala.vhr.controller.test;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/6/20 17:48
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/employee/basic/hello")
    public String hello2(){
        return "/employee/basic/hello";
    }

    @GetMapping("/system/init/hello")
    public String hello3(){
        return "/system/init/hello";
    }



}
