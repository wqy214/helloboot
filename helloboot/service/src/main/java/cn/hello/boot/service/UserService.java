package cn.hello.boot.service;


import cn.hello.boot.domain.User;

public interface UserService {

    User findByName(String userName);
}
