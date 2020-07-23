package cn.pealipala.vhr.service;

import cn.pealipala.vhr.mapper.MenuMapper;
import cn.pealipala.vhr.model.Hr;
import cn.pealipala.vhr.model.Menu;
import cn.pealipala.vhr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/6/28 21:30
 */
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> getMenusByHrId() {
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

//    @Cacheable
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    public List<Menu> getMenuWithChildren() {
        return menuMapper.getMenuWithChildren();
    }

    public List<Integer> getRoleByID(Integer rid) {
        return menuMapper.getRoleByID(rid);
    }

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menuMapper.deleteByRid(rid);
        if(mids.length == 0||mids == null){
            return true;
        }
        return menuMapper.insertByRid(rid,mids)==mids.length;
    }


}
