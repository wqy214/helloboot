package cn.hello.world.service.impl;


import cn.hello.world.dao.PermissionDao;
import cn.hello.world.dao.RoleDao;
import cn.hello.world.dao.UserDao;
import cn.hello.world.domain.*;
import cn.hello.world.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;



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
    }


}
