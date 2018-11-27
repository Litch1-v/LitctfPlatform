package com.litchi.litchi_ctf.pojo;
public class Challenge {
    private Integer cid;
    private String flag;
    private String title;
    private Integer type;
    private String description;
    private int solvedNumber;

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    private String link;


    public Integer getCid() {
        return cid;
    }

    public void setId(Integer id) {
        this.cid = cid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }



    public int getSolvedNumber() {
        return solvedNumber;
    }

    public void setSolvedNumber(int solvedNumber) {
        this.solvedNumber = solvedNumber;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "cid=" + cid +
                ", flag='" + flag + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", solvedNumber=" + solvedNumber +
                ", link='" + link + '\'' +
                '}';
    }
}
