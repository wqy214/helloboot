package cn.hello.world.dao;

import cn.hello.world.domain.RolePermission;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionDao {

    int deleteByPrimaryKey(RolePermission key);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

}