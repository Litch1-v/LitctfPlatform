package com.litchi.litchi_ctf.service;

import com.litchi.litchi_ctf.pojo.Challenge;
import com.litchi.litchi_ctf.pojo.ChallengeList;

public interface ChallengeService {
    ChallengeList listAllChallenges();
    Challenge getChallengeById(int cid);
    int saveChallenge(Challenge challenge);
    void deleteChallenge(int cid);
    int addChallenge(Challenge challenge);

}
