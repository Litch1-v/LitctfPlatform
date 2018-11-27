package com.litchi.litchi_ctf.service;

import com.litchi.litchi_ctf.pojo.Challenge;
import com.litchi.litchi_ctf.pojo.Solved;
import com.litchi.litchi_ctf.pojo.User;

import java.util.List;

public interface SolveService {
    public List<Challenge> solvedChallenge(int uid);
    public int[] solvedChallengeId(int uid);
    public int solvedNumber(int uid);
    public int solvedWebNumber(int uid);
    public int solvedPwnNumber(int uid);
    public int solvedMiscNumber(int uid);
    public int solvedReNumber(int uid);
    public int solvedCyptoNumber(int uid);
    int[] solvedWebChallenge(int uid);
    int[] solvedPwnChallenge(int uid);
    int[] solvedMiscChallenge(int uid);
    int[] solvedReChallenge(int uid);
    int[] solvedCyptoChallenge(int uid);
    public Solved getUserSolved(User user);
    public void saveNewSolved(Challenge challenge,User user);
    public int addOneSolvedNumber(int cid);
    public int addOneUserSolvedNumber(int uid);
}
