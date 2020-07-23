package cn.pealipala.vhr.controller.system.basic;

import cn.pealipala.vhr.model.Menu;
import cn.pealipala.vhr.model.RespBean;
import cn.pealipala.vhr.model.Role;
import cn.pealipala.vhr.service.MenuService;
import cn.pealipala.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/5 19:23
 */
@RestController
@RequestMapping("/system/basic/permission")
public class PermissionController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    public List<Menu> getMenuWithChildren(){
        return menuService.getMenuWithChildren();
    }

    @GetMapping("/mid/{rid}")
    public List<Integer> getRoleByID(@PathVariable("rid") Integer rid){
        return menuService.getRoleByID(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid,Integer[] mids){
        if (menuService.updateMenuRole(rid,mids)){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @PostMapping("/role")
    public RespBean insertRole(@RequestBody Role role){
        if (roleService.insertRole(role)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.ok("添加失败");
    }

    @DeleteMapping("/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid){
        if (roleService.deleteRoleById(rid) == 1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
