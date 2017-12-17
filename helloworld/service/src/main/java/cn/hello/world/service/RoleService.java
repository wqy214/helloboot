package cn.hello.world.service;

import cn.hello.world.domain.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Set<Role> findRolesByUserId(Long userId);
    List<Role> findAll();

    void saveUserRoles(Long userId, Integer[] roleIds);
}
