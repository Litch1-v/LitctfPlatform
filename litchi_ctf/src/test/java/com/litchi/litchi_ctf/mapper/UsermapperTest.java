package com.litchi.litchi_ctf.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsermapperTest {
    @Autowired
    private Usermapper usermapper;
    @Autowired
    private Rankmapper rankmapper;
    @Test
    public void listUserOrderBySolvedNumberTest(){
        usermapper.listUsersDescOrderBySolvedNumber().forEach(a->System.out.println(a.getUsername()));
    }
    @Test
    public void getMapOfUserNumberForSolvedNumber(){
        System.out.println(rankmapper.countUserNumberOfSolvedNumber());
    }
}