package com.company;

public class Main {

    public static void main(String[] args) {
        Email email = new Email();
	    SystemTest systemTest = new SystemTest(email);
	    systemTest.sendMessages();
    }
}
