package com.litchi.litchi_ctf.pojo;

import java.util.LinkedList;
import java.util.List;

public class ChallengeList {
    private static ChallengeList challengeList=new ChallengeList();
    private List<Challenge> webChallenges=new LinkedList<>();
    private List<Challenge> miscChallenges=new LinkedList<>();
    private List<Challenge> pwnChallenges=new LinkedList<>();

    public List<Challenge> getAllChallenges() {
        return allChallenges;
    }

    public void setAllChallenges(List<Challenge> allChallenges) {
        this.allChallenges = allChallenges;
    }

    private List<Challenge> allChallenges=new LinkedList<>();
    public static ChallengeList getChallengeList() {
        return challengeList;
    }

    public static void setChallengeList(ChallengeList challengeList) {
        ChallengeList.challengeList = challengeList;
    }

    public List<Challenge> getWebChallenges() {
        return webChallenges;
    }

    public void setWebChallenges(List<Challenge> webChallenges) {
        this.webChallenges = webChallenges;
    }

    public List<Challenge> getMiscChallenges() {
        return miscChallenges;
    }

    public void setMiscChallenges(List<Challenge> miscChallenges) {
        this.miscChallenges = miscChallenges;
    }

    public List<Challenge> getPwnChallenges() {
        return pwnChallenges;
    }

    public void setPwnChallenges(List<Challenge> pwnChallenges) {
        this.pwnChallenges = pwnChallenges;
    }

    public List<Challenge> getCyptoChallenges() {
        return cyptoChallenges;
    }

    public void setCyptoChallenges(List<Challenge> cyptoChallenges) {
        this.cyptoChallenges = cyptoChallenges;
    }

    public List<Challenge> getReChallenges() {
        return reChallenges;
    }

    public void setReChallenges(List<Challenge> reChallenges) {
        this.reChallenges = reChallenges;
    }

    private List<Challenge> cyptoChallenges=new LinkedList<>();
    private List<Challenge> reChallenges=new LinkedList<>();
    private ChallengeList(){};

    public static ChallengeList getInstance() {
        return challengeList;
    }
}
