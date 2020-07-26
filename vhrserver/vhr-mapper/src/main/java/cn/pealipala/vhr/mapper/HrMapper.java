package cn.pealipala.vhr.mapper;

import cn.pealipala.vhr.model.Hr;
import cn.pealipala.vhr.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);

    List<Role> getHrRolesById(Integer id);

    List<Hr> getAllHrs(@Param("id") Integer id,@Param("keywords") String keywords);

    List<Hr> getAllHrExceptCurrentHr(Integer id);
}