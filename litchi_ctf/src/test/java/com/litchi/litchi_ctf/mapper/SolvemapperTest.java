package com.litchi.litchi_ctf.mapper;

import com.litchi.litchi_ctf.util.TypeChallengeResultHandler;
import org.apache.ibatis.session.ResultHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SolvemapperTest {
    @Autowired
    private Solvemapper solvemapper;

    @Test
    public void listTypeGroupSolvedByUserIdTest(){
        ResultHandler resultHandler=new TypeChallengeResultHandler();
        solvemapper.listTypeGroupSolvedByUserId(1,resultHandler);
        System.out.println(((TypeChallengeResultHandler) resultHandler).getResults().toString());
    }
}