package com.litchi.litchi_ctf.service.serviceImpl;

import com.litchi.litchi_ctf.mapper.Challengemapper;
import com.litchi.litchi_ctf.mapper.Solvemapper;
import com.litchi.litchi_ctf.pojo.Challenge;
import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.SolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "SolveService")
public class SolveServiceImpl implements SolveService {

    @Autowired
    private Challengemapper challengemapper;
    @Autowired
    private Solvemapper solvemapper;


    @Override
    public void saveNewSolved(Challenge challenge,User user) {
        solvemapper.insertNewSolve(challenge.getCid(),user.getUid());
    }

    @Override
    public int addOneSolvedNumber(int cid) {
       return solvemapper.addOneSolvedNumber(cid);
    }

    @Override
    public int addOneUserSolvedNumber(int uid) {
        return solvemapper.addOneUserSolvedNumber(uid);
    }
}

