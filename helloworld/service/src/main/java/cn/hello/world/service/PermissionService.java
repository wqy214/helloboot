package cn.hello.world.service;

import cn.hello.world.domain.Permission;

import java.util.Set;

public interface PermissionService {
    Set<Permission> findPermissionsByRoleId(Long id);
}
