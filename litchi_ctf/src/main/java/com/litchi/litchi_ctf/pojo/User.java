package com.litchi.litchi_ctf.pojo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param  solvedChallenge 对应的是一个键为类型码，
 * 值为一个该类型解题id链表的hashmap
 */
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String classNumber;
    private String email;
    private String role;
    private String trueName;

    public Integer getSolvedNumber() {
        return solvedNumber;
    }

    public void setSolvedNumber(Integer solvedNumber) {
        this.solvedNumber = solvedNumber;
    }

    private Integer solvedNumber;
    private Map<Integer, List<Integer>> solvedChallenge=new HashMap<>();

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public Map<Integer, List<Integer>> getSolvedChallenge() {
        return solvedChallenge;
    }

    public void setSolvedChallenge(Map<Integer, List<Integer>> solvedChallenge) {
        this.solvedChallenge = solvedChallenge;
    }
}
