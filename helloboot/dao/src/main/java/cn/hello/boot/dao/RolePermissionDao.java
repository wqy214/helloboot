package cn.hello.boot.dao;

import cn.hello.boot.domain.RolePermission;
import cn.hello.boot.domain.RolePermissionQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionDao {
    int countByExample(RolePermissionQuery example);

    int deleteByExample(RolePermissionQuery example);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    List<RolePermission> selectByExample(RolePermissionQuery example);

    int updateByExampleSelective(@Param("record") RolePermission record, @Param("example") RolePermissionQuery example);

    int updateByExample(@Param("record") RolePermission record, @Param("example") RolePermissionQuery example);
}