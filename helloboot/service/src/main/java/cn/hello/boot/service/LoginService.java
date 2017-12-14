package cn.hello.boot.service;


import cn.hello.boot.domain.User;

public interface LoginService {

    User login(String userName, String password);


}
