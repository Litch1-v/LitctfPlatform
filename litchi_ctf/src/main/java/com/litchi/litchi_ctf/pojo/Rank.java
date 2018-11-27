package com.litchi.litchi_ctf.pojo;

import java.util.HashMap;

public class Rank {
    private static Rank rank=new Rank();
    private int[] rankList;

    public int[] getRankList() {
        return rankList;
    }

    public void setRankList(int[] rankList) {
        this.rankList = rankList;
    }

    public HashMap<Integer, Integer> getRankMap() {
        return rankMap;
    }

    public void setRankMap(HashMap<Integer, Integer> rankMap) {
        this.rankMap = rankMap;
    }

    private HashMap<Integer,Integer> rankMap=new HashMap<>();
    private Rank(){

    }
    public static Rank getInstance(){
        return rank;
    }
}
