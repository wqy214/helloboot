package cn.hello.world.service.impl;

import cn.hello.world.dao.PermissionDao;
import cn.hello.world.domain.Permission;
import cn.hello.world.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;


    @Override
    public Set<Permission> findPermissionsByRoleId(Long roleId) {
        Set<Permission> permissions = permissionDao.findPermissionsByRoleId(roleId);
        return permissions;
    }
}
