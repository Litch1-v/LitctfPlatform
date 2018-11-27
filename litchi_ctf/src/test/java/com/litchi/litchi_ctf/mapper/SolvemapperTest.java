package com.litchi.litchi_ctf.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SolvemapperTest {
    @Autowired
    private Solvemapper solvemapper;
    @Test
    public void selectWebSolvedByUser() {
        for (int i=0;i<solvemapper.SelectWebSolvedByUser(1).length;i++){
            System.out.println(solvemapper.SelectWebSolvedByUser(1)[i]);
        }

    }
}