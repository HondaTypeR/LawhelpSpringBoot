package com.it.lawhelp.spring.vo;


import com.fasterxml.jackson.annotation.JsonFormat;

public class PeopleRes {
    private int parentid;
    private String peopleName;
    private String peopleRes;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createDate;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getPeopleRes() {
        return peopleRes;
    }

    public void setPeopleRes(String peopleRes) {
        this.peopleRes = peopleRes;
    }
}
