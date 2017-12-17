package cn.hello.world.dao;

import cn.hello.world.domain.Permission;
import cn.hello.world.domain.PermissionQuery;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface PermissionDao {
    int countByExample(PermissionQuery example);

    int deleteByExample(PermissionQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionQuery example);

    Permission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionQuery example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionQuery example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    Set<Permission> findPermissionsByRoleId(Long roleId);
}