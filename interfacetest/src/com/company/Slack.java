package com.company;

public class Slack implements Test {
    @Override
    public void Message(String text) {
        System.out.println("Sent to slack: " + text);
    }
}
