package cn.hello.world.dao;

import cn.hello.world.domain.UserRole;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleDao {


    int deleteByPrimaryKey(UserRole key);

    int insert(UserRole record);

    int insertSelective(UserRole record);


}