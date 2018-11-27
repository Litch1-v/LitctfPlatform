package com.litchi.litchi_ctf.service.serviceImpl;


import com.litchi.litchi_ctf.mapper.Usermapper;
import com.litchi.litchi_ctf.pojo.Rank;
import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "UserService")
public class UserServiceImpl implements UserService{
    @Autowired
    private Usermapper usermapper;

    @Override
    public User getLoginUser(String studentId) {
        return usermapper.findUserByusername(studentId);
    }

    @Override
    public User getUserByid(Integer id) {
        return usermapper.findUserById(id);
    }

    /**
     * @param user 插入的用户
     * @return 改变的行数
     */
    @Override
    public Integer insertUser(User user) {
        return usermapper.insertUser(user);
    }

    @Override
    public int getUserNumber() {
        return usermapper.SelectUserNumber();
    }




}
