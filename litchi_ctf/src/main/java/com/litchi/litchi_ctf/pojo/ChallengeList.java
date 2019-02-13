package com.litchi.litchi_ctf.pojo;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ChallengeList {

    private static ChallengeList challengeList=new ChallengeList();
    private  ConcurrentHashMap<Integer,List<Challenge>> challengeListMap=new ConcurrentHashMap<>();

    private ChallengeList(){
    }
    public static ChallengeList getInstance() {
        return challengeList;
    }

    public ConcurrentHashMap<Integer, List<Challenge>> getChallengeListMap() {
        return challengeListMap;
    }

    public void setChallengeListMap(ConcurrentHashMap<Integer, List<Challenge>> challengeListMap) {
        this.challengeListMap = challengeListMap;
    }


}
