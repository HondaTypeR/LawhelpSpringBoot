package com.it.lawhelp.spring.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ProfessorRes {
    private String professorName;
    private String professorUnit;
    private String professorDuty;
    private String goodat;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String professorDate;
    private String professorRes;
    private int parentId;
    private String askAgain;
    private String username;
    private String peopleres;

    public String getPeopleres() {
        return peopleres;
    }

    public void setPeopleres(String peopleres) {
        this.peopleres = peopleres;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAskAgain() {
        return askAgain;
    }

    public void setAskAgain(String askAgain) {
        this.askAgain = askAgain;
    }

    public String getProfessorRes() {
        return professorRes;
    }

    public void setProfessorRes(String professorRes) {
        this.professorRes = professorRes;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getProfessorUnit() {
        return professorUnit;
    }

    public void setProfessorUnit(String professorUnit) {
        this.professorUnit = professorUnit;
    }

    public String getProfessorDuty() {
        return professorDuty;
    }

    public void setProfessorDuty(String professorDuty) {
        this.professorDuty = professorDuty;
    }

    public String getGoodat() {
        return goodat;
    }

    public void setGoodat(String goodat) {
        this.goodat = goodat;
    }

    public String getProfessorDate() {
        return professorDate;
    }

    public void setProfessorDate(String professorDate) {
        this.professorDate = professorDate;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
