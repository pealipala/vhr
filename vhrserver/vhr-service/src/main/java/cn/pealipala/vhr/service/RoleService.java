package cn.pealipala.vhr.service;

import cn.pealipala.vhr.mapper.RoleMapper;
import cn.pealipala.vhr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/5 19:48
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public Integer insertRole(Role role) {
        if (!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        return roleMapper.insert(role);
    }

    public Integer deleteRoleById(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }
}
