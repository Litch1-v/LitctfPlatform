package com.litchi.litchi_ctf.service.serviceImpl;

import com.litchi.litchi_ctf.service.RankService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RankServiceImplTest {
    @Autowired
    private RankService rankService;
    @Test
    public void getUserRankByUid() {
        System.out.println(rankService.getUserRankByUid(1));
    }
    @Test
    public void getRankListTest(){
        rankService.getUserRankList().forEach(a->System.out.println(a.getUsername()));
    }
}