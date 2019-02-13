package com.litchi.litchi_ctf.pojo;
public enum ChallengeType {
    /**
     * 对应六种CTF比赛赛题
     */
    WEB(1),
    PWN(2),
    MISC(3),
    CYPTO(4),
    CODE(5),
    RE(6);
    private int typecode;
    ChallengeType(int typecode){
        this.typecode=typecode;
    }

    public int getTypecode() {
        return typecode;
    }


}
