package com.litchi.litchi_ctf.service;

import com.litchi.litchi_ctf.pojo.Challenge;
import com.litchi.litchi_ctf.pojo.User;

public interface SolveService {
     void saveNewSolved(Challenge challenge,User user);
     int addOneSolvedNumber(int cid);
     int addOneUserSolvedNumber(int uid);
}
