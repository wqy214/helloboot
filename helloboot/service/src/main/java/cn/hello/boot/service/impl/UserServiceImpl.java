package cn.hello.boot.service.impl;


import cn.hello.boot.domain.User;
import cn.hello.boot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findByName(String userName) {
        return null;
    }
}
