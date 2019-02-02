package com.dius.interview.grace;

public class Player {
    private String name;
    private int score;
    private int gameScore;
    private int setScore;

    public Player(String name) {
        this.name = name;
        score = 0;
        gameScore = 0;
        setScore = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void resetScore() {
        score = 0;
    }

    public void winScore() {
        score++;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void resetGameScore() {
        gameScore = 0;
    }

    public void winGameScore() {
        gameScore++;
    }

    public int getSetScore() {
        return setScore;
    }

    public void winSetScore() {
        setScore++;
    }

    public void resetSetScore() {
        setScore = 0;
    }
}
