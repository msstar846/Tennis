package com.dius.interview.grace;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TennisMatchTest {

    @Test
    public void testWholeMatch() {
        TennisMatch tennisMatch = new TennisMatch("player 1", "player 2");

        tennisMatch.pointWonBy("player 1");
        tennisMatch.pointWonBy("player 2");
        assertThat("this will return \"0-0, 15-15\"",
                tennisMatch.score(),
                is("0-0, 15-15"));

        tennisMatch.pointWonBy("player 1");
        tennisMatch.pointWonBy("player 1");
        assertThat("this will return \"0-0, 40-15\"",
                tennisMatch.score(),
                is("0-0, 40-15"));

        tennisMatch.pointWonBy("player 2");
        tennisMatch.pointWonBy("player 2");
        assertThat("this will return \"0-0, Deuce\"",
                tennisMatch.score(),
                is("0-0, Deuce"));

        tennisMatch.pointWonBy("player 1");
        assertThat("this will return \"0-0, Advantage player 1\"",
                tennisMatch.score(),
                is("0-0, Advantage player 1"));

        tennisMatch.pointWonBy("player 1");
        assertThat("this will return \"1-0\"",
                tennisMatch.score(),
                is("1-0"));
    }

}
