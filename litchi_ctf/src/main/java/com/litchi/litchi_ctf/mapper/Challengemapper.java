package com.litchi.litchi_ctf.mapper;

import com.litchi.litchi_ctf.pojo.Challenge;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface Challengemapper {
    @Select("Select * From challenge where type=#{type}")
    public List<Challenge> listChallengesByType(int type);
    @Select("Select * From challenge where cid=#{cid}")
    public Challenge getChallengeById(int cid);
    @Select("Select * From challenge")
    public List<Challenge> listAllChallenges();
    @Update("UPDATE challenge set title=#{title},flag=#{flag},description=#{description},link=#{link} WHERE cid=#{cid}")
    public int updateChallenge(Challenge challenge);
    @Delete("DELETE  FROM challenge where cid =#{cid}")
    public int deleteChallengeById(int cid);
    @Insert("Insert into challenge(title,flag,description,link,type) values (#{title},#{flag},#{description},#{link},#{type})")
    public int insertChallenge(Challenge challenge);
    @Select("SELECT count(*) from challenge")
    public int countChallengesNumber();
}
