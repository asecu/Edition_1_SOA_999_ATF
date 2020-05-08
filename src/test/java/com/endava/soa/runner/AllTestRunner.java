package com.endava.soa.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        junit = "--step-notifications",
        features = "src/test/resources/feature",
        glue = {
                "com.endava.soa.stepdef",
                "com.endava.soa.hook"
        },
        tags = {"@All"}
)
public class AllTestRunner {
}
