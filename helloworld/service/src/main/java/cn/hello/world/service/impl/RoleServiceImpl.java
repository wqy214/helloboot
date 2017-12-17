package cn.hello.world.service.impl;

import cn.hello.world.dao.RoleDao;
import cn.hello.world.domain.Role;
import cn.hello.world.domain.RoleQuery;
import cn.hello.world.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public Set<Role> findRolesByUserId(Long userId) {

        Set<Role> roles = roleDao.findRolesByUserId(userId);
        return roles;
    }

    @Override
    public List<Role> findAll() {
        return roleDao.selectByExample(new RoleQuery());
    }

    @Override
    public void saveUserRoles(Long userId, Integer[] roleIds) {

        for (Integer roleId : roleIds) {

            roleDao.insertUserRole(userId, roleId);
        }
    }
}
