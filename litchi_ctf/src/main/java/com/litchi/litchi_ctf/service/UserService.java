package com.litchi.litchi_ctf.service;

import com.litchi.litchi_ctf.pojo.Rank;
import com.litchi.litchi_ctf.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public User getLoginUser(String studentId);
    public User getUserByid(Integer id);
    public Integer insertUser(User user);
    public int getUserNumber();

}
