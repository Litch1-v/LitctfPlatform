package com.litchi.litchi_ctf.service;

import com.litchi.litchi_ctf.pojo.Challenge;
import com.litchi.litchi_ctf.pojo.ChallengeList;

public interface ChallengeService {
    public ChallengeList getAllChallenge();
    public Challenge getChallengeById(int cid);
    public int saveChallenge(Challenge challenge);
    public int deleteChallenge(int cid);
    public int addChallenge(Challenge challenge);

}
