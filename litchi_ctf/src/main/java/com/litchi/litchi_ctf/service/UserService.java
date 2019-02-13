package com.litchi.litchi_ctf.service;

import com.litchi.litchi_ctf.pojo.User;


public interface UserService {
    User getUserById(Integer id);
    Integer insertUser(User user);
    Integer getUserNumber();

}
