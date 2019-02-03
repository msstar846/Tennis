package com.dius.interview.grace;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlayerTest {
    private Player player = new Player("Alice");

    @Test
    public void canGetName() {
        assertThat("Player name should be Alice",
                player.getName(),
                is("Alice"));
        Player anotherPlayer = new Player("Bob");
        assertThat("New player name should be Bob",
                anotherPlayer.getName(),
                is("Bob"));
    }

    @Test
    public void canWinScore() {
        assertThat("Player initilized with score zero",
                player.getScore(),
                is(0));
        player.winScore();
        assertThat("Player won 1 score",
                player.getScore(),
                is(1));
    }

    @Test
    public void canResetScore() {
        player.winScore();
        player.winScore();
        assertThat("Player won 2 scores",
                player.getScore(),
                is(2));
        player.resetScore();
        assertThat("Player score should be reset to zero",
                player.getScore(),
                is(0));
    }

    @Test
    public void canWinGameScore() {
        assertThat("Player initilized with game score zero",
                player.getGameScore(),
                is(0));
        player.winGameScore();
        assertThat("Player won 1 game",
                player.getGameScore(),
                is(1));
    }

    @Test
    public void canResetGameScore() {
        player.winGameScore();
        assertThat("Player won 1 game score",
                player.getGameScore(),
                is(1));
        player.resetGameScore();
        assertThat("Player game score should be reset to zero",
                player.getGameScore(),
                is(0));
    }

    @Test
    public void canWinSetScore() {
        assertThat("Player initilized with set score zero",
                player.getSetScore(),
                is(0));
        player.winSetScore();
        assertThat("Player won 1 set",
                player.getSetScore(),
                is(1));
    }

    @Test
    public void canResetSetScore() {
        player.winSetScore();
        assertThat("Player won 1 set score",
                player.getSetScore(),
                is(1));
        player.resetSetScore();
        assertThat("Player set score should be reset to zero",
                player.getSetScore(),
                is(0));
    }

}
