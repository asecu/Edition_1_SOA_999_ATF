package com.endava.soa.atf.stepdef;

import io.cucumber.java.en.Given;

import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BasicStepDef {
    @Given("{int} plus {int} equals {int}")
    public void plusEquals(int arg1, int arg2, int result) {
        assertThat(format("Check that %d plus %d equals: ", arg1, arg2), arg1 + arg2, is(result));
    }

    @Given("{int} minus {int} equals {int}")
    public void minusEquals(int arg1, int arg2, int result) {
        assertThat(format("Check that %d minus %d equals: ", arg1, arg2), arg1 - arg2, is(result));
    }
}
