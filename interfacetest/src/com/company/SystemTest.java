package com.company;

public class SystemTest {

    public Test test;

    public SystemTest(Test test) {
        this.test = test;
    }

    public void sendMessages(){
        test.Message("Vytautas");
    }
}
