package com.litchi.litchi_ctf.pojo;

public class User {
    private Integer uid;
    private String username;
    private String password;
    private String classNumber;
    private String email;
    private String role;
    private String trueName;
    private int[] solvedWebChallenges;
    private int[] solvedCodeChallenges;
    private int[] solvedMiscChallenges;
    private int[] solvedPwnChallenges;
    private int[] solvedReChallenges;
    private int[] solvedCyptoChallenges;

    public int getSolvedNumber() {
        return solvedNumber;
    }

    public void setSolvedNumber(int solvedNumber) {
        this.solvedNumber = solvedNumber;
    }

    private int solvedNumber;

    public int[] getSolvedCodeChallenges() {
        return solvedCodeChallenges;
    }

    public void setSolvedCodeChallenges(int[] solvedCodeChallenges) {
        this.solvedCodeChallenges = solvedCodeChallenges;
    }

    public int[] getSolvedMiscChallenges() {
        return solvedMiscChallenges;
    }

    public void setSolvedMiscChallenges(int[] solvedMiscChallenges) {
        this.solvedMiscChallenges = solvedMiscChallenges;
    }

    public int[] getSolvedPwnChallenges() {
        return solvedPwnChallenges;
    }

    public void setSolvedPwnChallenges(int[] solvedPwnChallenges) {
        this.solvedPwnChallenges = solvedPwnChallenges;
    }

    public int[] getSolvedReChallenges() {
        return solvedReChallenges;
    }

    public void setSolvedReChallenges(int[] solvedReChallenges) {
        this.solvedReChallenges = solvedReChallenges;
    }

    public int[] getSolvedCyptoChallenges() {
        return solvedCyptoChallenges;
    }

    public void setSolvedCyptoChallenges(int[] solvedCyptoChallenges) {
        this.solvedCyptoChallenges = solvedCyptoChallenges;
    }

    public int[] getSolvedWebChallenges() {
        return solvedWebChallenges;
    }

    public void setSolvedWebChallenges(int[] solvedChallenges) {
        this.solvedWebChallenges = solvedChallenges;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setStudentId(String username) {
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
}
