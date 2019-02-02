package com.dius.interview.grace;

public class TennisMatch implements Match {

    private static final String[] SCORE_DESC = {"0", "15", "30", "40"};
    private static final int FOUR_POINTS = 4;
    private static final int THREE_POINTS = 3;
    private static final int TWO_POINTS = 2;
    private static final int LOVE = 0;
    private static final String DEUCE = "Deuce";
    private static final String ADVANTAGE = "Advantage ";

    private Player playerOne;
    private Player playerTwo;

    public TennisMatch(String player1, String player2) {
        this.playerOne = new Player(player1);
        this.playerTwo = new Player(player2);
    }

    @Override
    public void pointWonBy(String player) {
        if (playerOne.getName().equals(player)) {
            playerOne.winScore();
        } else {
            playerTwo.winScore();
        }
        calculateGameScore();
        calculateSetScore();
    }

    @Override
    public String score() {

        String setMsg = getSetMsg();
        if(setMsg != null) {
            return setMsg;
        }
        String gameScoreMsg = getGameScoreMsg();
        String scoreMsg = getScoreMsg();

        return gameScoreMsg + scoreMsg;
    }

    private String getSetMsg() {
        String setScoreMsg = null;
        int playerOneSetScore = playerOne.getSetScore();
        int playerTwoSetScore = playerTwo.getSetScore();

        if(playerOneSetScore > 0 || playerTwoSetScore > 0) {
            String setWinnerName = playerOneSetScore > playerTwoSetScore ?
                    playerOne.getName() : playerTwo.getName();

            if(setWinnerName != null) {
                setScoreMsg = playerOne.getSetScore() + "-" + playerTwo.getSetScore() + ", ";
                setScoreMsg += setWinnerName + " Won the set!";
            }
        }

        return setScoreMsg;
    }

    private void calculateSetScore() {
        int playerOneScore = playerOne.getGameScore();
        int playerTwoScore = playerTwo.getGameScore();
        int scoreDiff = Math.abs(playerOneScore - playerTwoScore);

        // winning set only by leading 2 games
        if (scoreDiff >= TWO_POINTS) {
            if(playerOneScore >= 6) { playerOne.winSetScore(); resetSet();}
            if(playerTwoScore >= 6) { playerTwo.winSetScore(); resetSet();}
        }
    }

    private String getScoreMsg() {
        String scoreMsg = "";
        int playerOneScore = playerOne.getScore();
        int playerTwoScore = playerTwo.getScore();
        int scoreDiff = Math.abs(playerOneScore - playerTwoScore);

        if (playerOneScore == LOVE && playerTwoScore == LOVE) {
            return scoreMsg;
        } else {
            scoreMsg = ", ";
            if (playerOneScore >= THREE_POINTS && playerTwoScore >= THREE_POINTS) {
                // either deuce or advantage
                if (scoreDiff == 0) {
                    scoreMsg += DEUCE;
                } else if (scoreDiff == 1) {
                    scoreMsg += ADVANTAGE + getPlayerInLead().getName();
                }
            } else {
                scoreMsg += SCORE_DESC[playerOneScore] + "-" + SCORE_DESC[playerTwoScore];
            }
        }

        return scoreMsg;
    }

    private String getGameScoreMsg() {
        String gameScoreMsg = playerOne.getGameScore() + "-" + playerTwo.getGameScore();

        return gameScoreMsg;
    }

    private void calculateGameScore() {
        int playerOneScore = playerOne.getScore();
        int playerTwoScore = playerTwo.getScore();
        int scoreDiff = Math.abs(playerOneScore - playerTwoScore);

        // winning game only by leading 2 points
        if (scoreDiff >= TWO_POINTS) {
            // at least scored 4 points
            if (playerOneScore >= FOUR_POINTS || playerTwoScore >= FOUR_POINTS) {
                Player playerWonGame = getPlayerInLead();
                playerWonGame.winGameScore();
                resetGame();
            }
        }
    }

    private void resetGame() {
        playerOne.resetScore();
        playerTwo.resetScore();
    }

    private void resetSet() {
        playerOne.resetGameScore();
        playerTwo.resetGameScore();
        resetGame();
    }

    private Player getPlayerInLead() {
        if (playerOne.getScore() > playerTwo.getScore()) {
            return playerOne;
        }
        return playerTwo;
    }
}
