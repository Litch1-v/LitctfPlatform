package com.litchi.litchi_ctf.service.serviceImpl;

import com.litchi.litchi_ctf.mapper.Challengemapper;
import com.litchi.litchi_ctf.mapper.Solvemapper;
import com.litchi.litchi_ctf.mapper.Usermapper;
import com.litchi.litchi_ctf.pojo.Challenge;
import com.litchi.litchi_ctf.pojo.ChallengeList;
import com.litchi.litchi_ctf.pojo.ChallengeType;
import com.litchi.litchi_ctf.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ChallengeService")
public class ChallengeServiceImpl implements ChallengeService {
    @Autowired
    private Challengemapper challengemapper;
    @Autowired
    private Usermapper usermapper;
    @Autowired
    private Solvemapper solvemapper;
    @Autowired
    private ChallengeService challengeService;
    @Override
    public ChallengeList listAllChallenges() {
        ChallengeList challengeList = ChallengeList.getInstance();
        for (ChallengeType value : ChallengeType.values()) {
            challengeList.getChallengeListMap().put(value.getTypecode(), challengemapper.listChallengesByType(value.getTypecode()));
        }
        return challengeList;
    }

    @Override
    public Challenge getChallengeById(int cid) {
        return challengemapper.getChallengeById(cid);
    }

    @Override
    public int saveChallenge(Challenge challenge) {
       return challengemapper.updateChallenge(challenge);
    }

    /**
     * @param cid 需要删除的题目，删除之后，需要将题目从TypeChallengeMap中移除
     * 从数据库移除相关题目信息，将做过这道题的人的solvedNumber-1;
     *由于排名界面是视图，所以不需要更改rankview
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteChallenge(int cid) {
        Challenge challengeWantToDelete=challengemapper.getChallengeById(cid);
        challengemapper.deleteChallengeById(cid);
        challengeService.listAllChallenges().getChallengeListMap().get(challengeWantToDelete.getType()).remove(challengeWantToDelete);
        usermapper.updateSolvedNumberCauseByChallengeDelete(cid);
        solvemapper.deleteSolvedByCid(cid);
    }

    @Override
    public int addChallenge(Challenge challenge) {
        challengeService.listAllChallenges().getChallengeListMap().get(challenge.getType()).add(challenge);
        return challengemapper.insertChallenge(challenge);

    }
}
