package com.litchi.litchi_ctf.service.serviceImpl;

import com.litchi.litchi_ctf.mapper.Challengemapper;
import com.litchi.litchi_ctf.mapper.Solvemapper;
import com.litchi.litchi_ctf.pojo.Challenge;
import com.litchi.litchi_ctf.pojo.Solved;
import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.SolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service(value = "SolveService")
public class SolveServiceImpl implements SolveService {

    @Autowired
    private Challengemapper challengemapper;
    @Autowired
    private Solvemapper solvemapper;

    @Override
    public int solvedNumber(int uid) {
        return solvemapper.SelectCountSolvedByUser(uid);
    }

    @Override
    public List<Challenge> solvedChallenge(int uid) {
        List<Challenge> challengeList = new LinkedList<Challenge>();
        int[] solved = solvemapper.SelectAllSolvedByUser(uid);
        for (int cid : solved) {
            Challenge challenge = challengemapper.selectChallengeById(cid);
            challengeList.add(challenge);
        }
        return challengeList;
    }

    @Override
    public int[] solvedChallengeId(int uid) {
        return solvemapper.SelectAllSolvedByUser(uid);
    }

    @Override
    public int solvedWebNumber(int uid) {
        return solvemapper.SelectWebSolvedNumberByUser(uid);
    }

    @Override
    public int solvedPwnNumber(int uid) {
        return solvemapper.SelectPwnSolvedNumberByUser(uid);
    }

    @Override
    public int solvedMiscNumber(int uid) {
        return solvemapper.SelectMiscSolvedNumberByUser(uid);
    }

    @Override
    public int solvedReNumber(int uid) {
        return solvemapper.SelectReSolvedNumberByUser(uid);
    }

    @Override
    public int solvedCyptoNumber(int uid) {
        return solvemapper.SelectCyptoSolvedNumberByUser(uid);
    }

    @Override
    public int[] solvedWebChallenge(int uid) {
        return new int[0];
    }

    @Override
    public int[] solvedPwnChallenge(int uid) {
        return new int[0];
    }

    @Override
    public int[] solvedMiscChallenge(int uid) {
        return new int[0];
    }

    @Override
    public int[] solvedReChallenge(int uid) {
        return new int[0];
    }

    @Override
    public int[] solvedCyptoChallenge(int uid) {
        return new int[0];
    }

    @Override
    public Solved getUserSolved(User user) {
        int uid = user.getUid();
        Solved solved = new Solved(uid);
        solved.setCyptoSolved(solvemapper.SelectCyptoSolvedByUser(uid));
        solved.setMiscSolved(solvemapper.SelectMiscSolvedByUser(uid));
        solved.setPwnSolved(solvemapper.SelectPwnSolvedByUser(uid));
        solved.setWebSolved(solvemapper.SelectWebSolvedByUser(uid));
        solved.setReSolved(solvemapper.SelectReSolvedByUser(uid));
        return solved;
    }

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

