package com.endava.soa.hook;

import io.cucumber.java.After;

import static com.endava.soa.utils.DriverManager.getAtfDriver;

public class AfterHook {


    @After
    public void afterHook() throws Exception {
        getAtfDriver().close();
    }
}
