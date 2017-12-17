package cn.hello.world.dao;

import cn.hello.world.domain.Role;
import cn.hello.world.domain.RoleQuery;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface RoleDao {
    int countByExample(RoleQuery example);

    int deleteByExample(RoleQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleQuery example);

    Role selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleQuery example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleQuery example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    Set<Role> findRolesByUserId(Long userId);

    void saveUserRole(Long userId, Integer roleId);

    void insertUserRole(Long userId, Integer roleId);
}