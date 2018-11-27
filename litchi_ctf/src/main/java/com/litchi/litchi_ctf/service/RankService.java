package com.litchi.litchi_ctf.service;

import com.litchi.litchi_ctf.pojo.Rank;
import com.litchi.litchi_ctf.pojo.User;

import java.util.List;

public interface RankService {
    public List<User> getUserRank(Rank rank);
    public void freshRank(Rank rank);
    public int getUserRankByUid(int uid, Rank rank);

}
