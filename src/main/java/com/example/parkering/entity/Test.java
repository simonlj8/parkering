package com.example.parkering.entity;


public class Test {
    private String name;
    private String subject;
    private String score;

    public Test(String name, String subject, String score) {
        this.name = name;
        this.subject = subject;
        this.score = score;
    }


    public Test() {
    }



    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    
}


