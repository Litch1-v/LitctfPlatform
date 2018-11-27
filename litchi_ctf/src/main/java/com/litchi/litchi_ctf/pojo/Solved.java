package com.litchi.litchi_ctf.pojo;

public class Solved {
    private int userid;
    private int[] webSolved;
    private int[] pwnSolved;
    private int[] miscSolved;
    private int[] cyptoSolved;
    private int[] reSolved;
    public Solved(int userid){
        this.userid=userid;
    }
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int[] getWebSolved() {
        return webSolved;
    }

    public void setWebSolved(int[] webSolved) {
        this.webSolved = webSolved;
    }

    public int[] getPwnSolved() {
        return pwnSolved;
    }

    public void setPwnSolved(int[] pwnSolved) {
        this.pwnSolved = pwnSolved;
    }

    public int[] getMiscSolved() {
        return miscSolved;
    }

    public void setMiscSolved(int[] miscSolved) {
        this.miscSolved = miscSolved;
    }

    public int[] getCyptoSolved() {
        return cyptoSolved;
    }

    public void setCyptoSolved(int[] cyptoSolved) {
        this.cyptoSolved = cyptoSolved;
    }

    public int[] getReSolved() {
        return reSolved;
    }

    public void setReSolved(int[] reSolved) {
        this.reSolved = reSolved;
    }
}
