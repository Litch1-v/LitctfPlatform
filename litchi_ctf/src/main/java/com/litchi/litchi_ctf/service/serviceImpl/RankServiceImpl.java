package com.litchi.litchi_ctf.service.serviceImpl;


import com.litchi.litchi_ctf.mapper.Rankmapper;
import com.litchi.litchi_ctf.mapper.Usermapper;
import com.litchi.litchi_ctf.pojo.Rank;
import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service(value = "RankService")
public class RankServiceImpl implements RankService{
    @Autowired
    private Usermapper usermapper;
    @Autowired
    private Rankmapper rankmapper;
    @Override
    public void freshRank(Rank rank){
        //已经做出来题目的同学
        rank.setRankList(rankmapper.getRanklist());
        for (int i=0;i<rank.getRankList().length;i++){
            rank.getRankMap().put(rank.getRankList()[i],i+1);
        }
    }
    @Override
    public int getUserRankByUid(int uid, Rank rank) {
        freshRank(rank);
        if (rank.getRankMap().get(uid)==null){
            return rank.getRankList().length+1;
        }
        else {return rank.getRankMap().get(uid);}
    }

    @Override
    public List<User> getUserRank(Rank rank) {
        List<User> userList=new LinkedList<>();
        freshRank(rank);
        for (int i=0;i<rank.getRankList().length;i++){
            userList.add(usermapper.findUserById(rank.getRankList()[i]));
        }
        return userList;
    }
}
