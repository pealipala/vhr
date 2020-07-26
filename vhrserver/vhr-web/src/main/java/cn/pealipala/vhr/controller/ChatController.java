package cn.pealipala.vhr.controller;

import cn.pealipala.vhr.model.Hr;
import cn.pealipala.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/26 12:52
 */
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private HrService hrService;

    @GetMapping("/hrs")
    public List<Hr> getAllHrExceptCurrentHr(){
        return hrService.getAllHrExceptCurrentHr();
    }
}
