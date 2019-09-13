package com.company;

public class Email implements Test{
    @Override
    public void Message(String text) {
        System.out.println("EMail sent for: " + text);
    }
}
