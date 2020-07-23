package cn.pealipala.vhr.controller.config;

import cn.pealipala.vhr.model.Menu;
import cn.pealipala.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/6/28 21:26
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/menu")
    public List<Menu> getMenusByHrId(){
        return menuService.getMenusByHrId();
    }

}
