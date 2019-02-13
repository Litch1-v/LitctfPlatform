package com.litchi.litchi_ctf.service.serviceImpl;


import com.litchi.litchi_ctf.mapper.Solvemapper;
import com.litchi.litchi_ctf.mapper.Usermapper;
import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.UserService;
import com.litchi.litchi_ctf.util.TypeChallengeResultHandler;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "UserService")
public class UserServiceImpl implements UserService{
    @Autowired
    private Usermapper usermapper;
    @Autowired
    private Solvemapper solvemapper;
    /**
     *
     * @param id
     * @return 完整的user信息，包括其各种类型的题目的解题情况
     */
    @Override
    public User getUserById(Integer id) {
        User user=usermapper.getUserById(id);
        ResultHandler resultHandler=new TypeChallengeResultHandler();
        solvemapper.listTypeGroupSolvedByUserId(id,resultHandler);
        Map<Integer, List<Integer>> typeSolvedChallenges=((TypeChallengeResultHandler) resultHandler).getResults();
        user.setSolvedChallenge(typeSolvedChallenges);
        return user;
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
    public Integer getUserNumber() {
        return usermapper.SelectUserNumber();
    }




}
