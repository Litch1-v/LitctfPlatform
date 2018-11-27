package com.litchi.litchi_ctf.mapper;


import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.SolveService;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * 用户dao，使用mybatis
 */

@Mapper
public interface Usermapper {
    @Select("Select * from user where username=#{username}")
    public User findUserByusername(String username);
    @Select("Select * from user where uid=#{uid}")
    @Results({
            @Result(column = "uid",property = "uid"),
            @Result(column = "uid",property = "solvedWebChallenges",many = @Many(select = "com.litchi.litchi_ctf.mapper.Solvemapper.SelectWebSolvedByUser")),
            @Result(column = "uid",property = "solvedNumber",one = @One(select = "com.litchi.litchi_ctf.mapper.Solvemapper.SelectCountSolvedByUser"))
    })
    public User findUserById(Integer uid);
    @Insert("Insert into user(username,true_name,password,class_number,email) values (#{username},#{trueName},#{password},#{classNumber}" +
            ",#{email})")
    public Integer insertUser(User user);
    @Select("SELECT count(uid) FROM user")
    public int SelectUserNumber();
}
