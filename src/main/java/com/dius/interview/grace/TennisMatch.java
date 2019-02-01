package com.dius.interview.grace;

public class TennisMatch implements Match{

    private static final String[] SCORE_DESC = {"0", "15", "30", "40"};

    private String player1Name;
    private String player2Name;
    private int player1Score;
    private int player2Score;
    private int player1GameScore;
    private int player2GameScore;

    public TennisMatch(String player1, String player2) {
        player1Name = player1;
        player2Name = player2;
        player1Score = 0;
        player2Score = 0;
        player1GameScore = 0;
        player2GameScore = 0;
    }

    @Override
    public void pointWonBy(String player) {
        if(player1Name.equals(player)) {
            player1Score++;
        }else {
            player2Score++;
        }
    }

    @Override
    public String score() {

        // check if game is won by player
        if(player1Score >= 4 || player2Score >= 4) {
            int diff = player1Score - player2Score;
            if(diff >= 2) {
                player1GameScore++;
                resetGame();
            }else if(diff <= -2) {
                player2GameScore++;
            }
        }

        String scoreMessage = player1GameScore + "-" + player2GameScore;

        if(player1Score >= 3 && player2Score >= 3) {
            scoreMessage += ", ";
            //either deuce or advantage
            int scoreDiff = player1Score - player2Score;
            if(scoreDiff == 0) {
                scoreMessage += "Deuce";
            }else if(scoreDiff == 1) {
                scoreMessage += "Advantage " + getPlayerInLead();
            }
        }else if(player1Score != 0 && player2Score != 0){
            scoreMessage += ", ";
            scoreMessage += SCORE_DESC[player1Score] + "-" + SCORE_DESC[player2Score];
        }

        return scoreMessage;
    }

    private void resetGame() {
        player1Score = 0;
        player2Score = 0;
    }

    private String getPlayerInLead() {
        return player1Score > player2Score ? player1Name : player2Name;
    }
}
