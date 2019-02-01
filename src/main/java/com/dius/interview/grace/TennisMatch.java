package com.dius.interview.grace;

public class TennisMatch implements Match {

    private static final String[] SCORE_DESC = {"0", "15", "30", "40"};

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
    }

    @Override
    public String score() {

        String gameScoreMsg = getGameScoreMsg();
        ;

        String scoreMsg = getScoreMsg();

        return gameScoreMsg + scoreMsg;
    }

    private String getScoreMsg() {
        String scoreMsg = "";
        int playerOneScore = playerOne.getScore();
        int playerTwoScore = playerTwo.getScore();
        int scoreDiff = Math.abs(playerOneScore - playerTwoScore);

        if (playerOneScore == 0 && playerTwoScore == 0) {
            return scoreMsg;
        } else {
            scoreMsg = ", ";
            if (playerOneScore >= 3 && playerTwoScore >= 3) {
                // either deuce or advantage
                if (scoreDiff == 0) {
                    scoreMsg += "Deuce";
                } else if (scoreDiff == 1) {
                    scoreMsg += "Advantage " + getPlayerInLead().getName();
                }
            } else {
                scoreMsg += SCORE_DESC[playerOneScore] + "-" + SCORE_DESC[playerTwoScore];
            }
        }

        return scoreMsg;
    }

    private String getGameScoreMsg() {
        int playerOneScore = playerOne.getScore();
        int playerTwoScore = playerTwo.getScore();
        int scoreDiff = Math.abs(playerOneScore - playerTwoScore);

        // winning game only by leading 2 points
        if (scoreDiff == 2) {
            // at least scored 4 points
            if (playerOneScore >= 4 || playerTwoScore >= 4) {
                Player playerWonGame = getPlayerInLead();
                playerWonGame.winGameScore();
                resetGame();
            }
        }

        String gameScoreMsg = playerOne.getGameScore() + "-" + playerTwo.getGameScore();

        return gameScoreMsg;
    }

    private void resetGame() {
        playerOne.resetScore();
        playerTwo.resetScore();
    }

    private Player getPlayerInLead() {
        if (playerOne.getScore() > playerTwo.getScore()) {
            return playerOne;
        }
        return playerTwo;
    }
}
