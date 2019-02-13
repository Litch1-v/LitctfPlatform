package com.litchi.litchi_ctf.service.serviceImpl;


import com.litchi.litchi_ctf.mapper.Challengemapper;
import com.litchi.litchi_ctf.mapper.Rankmapper;
import com.litchi.litchi_ctf.mapper.Usermapper;
import com.litchi.litchi_ctf.pojo.RankList;
import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.RankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "RankService")
public class RankServiceImpl implements RankService{
    private static final Logger log= LoggerFactory.getLogger(RankServiceImpl.class);
    @Autowired
    private Usermapper usermapper;
    @Autowired
    private Rankmapper rankmapper;
    @Autowired
    private Challengemapper challengemapper;
    @Override
    public int getUserRankByUid(int uid) {
        Integer solvedNumber=usermapper.getUserSolvedNumberById(uid);
        RankList[] countUserNumberOfSolvedNumberList=rankmapper.countUserNumberOfSolvedNumber();
        int countAmountUser=0;
        for (RankList rankList : countUserNumberOfSolvedNumberList) {
            if (rankList.getSolvedNumber()<=solvedNumber){
                break;
            }
            else {
                countAmountUser=+rankList.getUserNumber();
            }
        }
        return countAmountUser+1;
    }

    @Override
    public List<User> getUserRankList() {
        return usermapper.listUsersDescOrderBySolvedNumber();
    }
}
