package cn.pealipala.vhr.mapper;

import cn.pealipala.vhr.model.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getMenusByHrId(Integer id);

    List<Menu> getAllMenusWithRole();

    List<Menu> getMenuWithChildren();

    List<Integer> getRoleByID(Integer rid);

    void deleteByRid(Integer rid);

    Integer insertByRid(@Param("rid") Integer rid,@Param("mids") Integer[] mids);
}