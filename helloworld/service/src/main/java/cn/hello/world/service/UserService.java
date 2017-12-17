package cn.hello.world.service;


import cn.hello.world.domain.PageBean;
import cn.hello.world.domain.Permission;
import cn.hello.world.domain.Role;
import cn.hello.world.domain.User;

import java.util.Set;

public interface UserService {

    User findByName(String userName);


    PageBean pageQuery(PageBean pageBean);

    void save(User user);
}
