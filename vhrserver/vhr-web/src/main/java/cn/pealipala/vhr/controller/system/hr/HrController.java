package cn.pealipala.vhr.controller.system.hr;

import cn.pealipala.vhr.model.Hr;
import cn.pealipala.vhr.model.RespBean;
import cn.pealipala.vhr.model.Role;
import cn.pealipala.vhr.service.HrService;
import cn.pealipala.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/12 14:41
 */
@RestController
@RequestMapping("/system/hr")
public class HrController {

    @Autowired
    private HrService hrService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords) {
        return hrService.getAllHrs(keywords);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRole(Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id){
        if (hrService.deleteHrById(id)==1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
