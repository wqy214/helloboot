package cn.hello.boot.service.impl;


import cn.hello.boot.dao.UserDao;
import cn.hello.boot.domain.User;
import cn.hello.boot.domain.UserQuery;
import cn.hello.boot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String userName, String password) {

        UserQuery userQuery = new UserQuery();
        userQuery.createCriteria().andUserNameEqualTo(userName).andPswdEqualTo(password);
        List<User> users = userDao.selectByExample(userQuery);


        return users.get(0);
    }
}
