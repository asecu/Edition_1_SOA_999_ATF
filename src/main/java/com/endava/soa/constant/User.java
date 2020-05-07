package com.endava.soa.constant;

public enum User {
    TEST_USER("soatest2020@gmail.com", "1234567890");

    private String username;
    private String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
