package cn.hello.world.service.impl;


import cn.hello.world.dao.PermissionDao;
import cn.hello.world.dao.RoleDao;
import cn.hello.world.dao.UserDao;
import cn.hello.world.dao.UserRoleDao;
import cn.hello.world.domain.*;
import cn.hello.world.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.ArrayUtils;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;



    @Override
    public User findByName(String username) {

        User user = userDao.findbyUsername(username);
        return user;
    }

    @Override
    public PageBean pageQuery(PageBean pageBean) {
        UserQuery userQuery = new UserQuery();
        pageBean.setTotalCount(userDao.countByExample(userQuery));
        userQuery.setPageNo(pageBean.getPage());
        userQuery.setPageSize(pageBean.getSize());
        List<User> users = userDao.selectByExample(userQuery);
        pageBean.setData(users);
        return pageBean;
    }

    @Override
    public void save(User user) {
        userDao.insert(user);

        Long[] roleIds = user.getRoleIds();
        if (!ArrayUtils.isEmpty(roleIds)) {
            for (Long roleId : roleIds) {
                UserRole userRole = new UserRole(user.getId(), roleId);
                userRoleDao.insert(userRole);
            }
        }

    }


}
