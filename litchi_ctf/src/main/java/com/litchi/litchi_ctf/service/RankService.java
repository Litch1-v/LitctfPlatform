package com.litchi.litchi_ctf.service;

import com.litchi.litchi_ctf.pojo.User;

import java.util.List;

public interface RankService {
    List<User> getUserRankList();
    int getUserRankByUid(int uid);

}
