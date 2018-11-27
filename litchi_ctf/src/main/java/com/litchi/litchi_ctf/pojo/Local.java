package com.litchi.litchi_ctf.pojo;

import java.util.List;

/**
 *Type类型解释：Web-1 Pwn-2 Misc-3 Cypto-4 Code-5 Re-6
 *
 */
public class Local {
    public final String[] type={"web","pwn","misc","cypto","code","re"};
    private static Local local=new Local();
    private int userNumber;
    private Rank rank;
    private ChallengeList challengeList;

    public List<Notice> getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(List<Notice> noticeList) {
        this.noticeList = noticeList;
    }

    private List<Notice> noticeList;
    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    private Local(){
    }
    public static Local getInstance(){
        return local;
    }

    public ChallengeList getChallengeList() {
        return challengeList;
    }

    public void setChallengeList(ChallengeList challengeList) {
        this.challengeList = challengeList;
    }
}
