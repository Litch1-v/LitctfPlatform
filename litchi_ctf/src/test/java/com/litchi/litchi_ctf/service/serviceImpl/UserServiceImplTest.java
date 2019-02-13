package com.litchi.litchi_ctf.service.serviceImpl;

import com.litchi.litchi_ctf.LitchiCtfApplicationTests;
import com.litchi.litchi_ctf.pojo.Challenge;
import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.SolveService;
import com.litchi.litchi_ctf.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Service;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Test
    public void main() {
     User user=userService.getUserById(1);
        List<Integer> typeSolvedChallenge=user.getSolvedChallenge().get(2);
        System.out.println(typeSolvedChallenge.contains(3));
    }

}