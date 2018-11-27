package com.litchi.litchi_ctf.service.serviceImpl;

import com.litchi.litchi_ctf.mapper.Challengemapper;
import com.litchi.litchi_ctf.pojo.Challenge;
import com.litchi.litchi_ctf.pojo.ChallengeList;
import com.litchi.litchi_ctf.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ChallengeService")
public class ChallengeServiceImpl implements ChallengeService {
    @Autowired
    private Challengemapper challengemapper;
    @Override
    public ChallengeList getAllChallenge() {
        ChallengeList challengeList=ChallengeList.getInstance();
        challengeList.setWebChallenges(challengemapper.selectChallengeByType(1));
        challengeList.setPwnChallenges(challengemapper.selectChallengeByType(2));
        challengeList.setMiscChallenges(challengemapper.selectChallengeByType(3));
        challengeList.setCyptoChallenges(challengemapper.selectChallengeByType(4));
        challengeList.setReChallenges(challengemapper.selectChallengeByType(6));
        challengeList.getAllChallenges().clear();
        challengeList.getAllChallenges().addAll(challengeList.getCyptoChallenges());
        challengeList.getAllChallenges().addAll(challengeList.getWebChallenges());
        challengeList.getAllChallenges().addAll(challengeList.getMiscChallenges());
        challengeList.getAllChallenges().addAll(challengeList.getPwnChallenges());
        challengeList.getAllChallenges().addAll(challengeList.getReChallenges());
        return challengeList;
    }

    @Override
    public Challenge getChallengeById(int cid) {
        return challengemapper.selectChallengeById(cid);
    }

    @Override
    public int saveChallenge(Challenge challenge) {
       return challengemapper.updateChallenge(challenge);
    }

    @Override
    public int deleteChallenge(int cid) {
        return challengemapper.deleteChallengeById(cid);
    }

    @Override
    public int addChallenge(Challenge challenge) {
        return challengemapper.insertChallenge(challenge);
    }
}
