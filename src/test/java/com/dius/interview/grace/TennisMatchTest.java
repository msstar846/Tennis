package com.dius.interview.grace;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TennisMatchTest {

    @Test
    public void testGameWonByOnePlayer() {
        TennisMatch tennisMatch = new TennisMatch("player 1", "player 2");

        // we have setup player 1 to win 5 games up to [5-0, 40-0]
        for(int i = 1; i < 24; i++) {
            tennisMatch.pointWonBy("player 1");

            // player won 4 times in a row win the game
            if(i % 4 == 0) {
                String expectScore = i/4 + "-0";
                assertThat("this should return game score",
                        tennisMatch.score(),
                        is(expectScore));
            }
        }
        // one point to win the set
        tennisMatch.pointWonBy("player 1");
        assertThat("player 1 won 6 games in a row, therefore win the set",
                tennisMatch.score(),
                is("1-0, player 1 Won the set!"));
    }

    @Test
    public void testGame() {
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

    @Test
    public void testTieBreak() {
        TennisMatch tennisMatch = new TennisMatch("player 1", "player 2");

        // player1 won 5 games
        for(int i = 1; i < 21; i++) {
            tennisMatch.pointWonBy("player 1");
        }

        // player2 won 6 games
        for(int i = 1; i < 25; i++) {
            tennisMatch.pointWonBy("player 2");
        }

        System.out.println(tennisMatch.score());
    }

}
