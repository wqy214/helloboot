package cn.hello.boot.dao;

import cn.hello.boot.domain.UserRole;
import cn.hello.boot.domain.UserRoleQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleDao {
    int countByExample(UserRoleQuery example);

    int deleteByExample(UserRoleQuery example);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByExample(UserRoleQuery example);

    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleQuery example);

    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleQuery example);
}