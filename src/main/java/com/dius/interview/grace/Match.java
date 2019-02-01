package com.dius.interview.grace;

public class Match {

    private static final String[] SCORE_DESC = {"0", "15", "30", "40"};

    private String player1Name;
    private String player2Name;
    private int player1Score;
    private int player2Score;
    private int player1GameScore;
    private int player2GameScore;

    public Match(String player1, String player2) {
        player1Name = player1;
        player2Name = player2;
        player1Score = 0;
        player2Score = 0;
        player1GameScore = 0;
        player2GameScore = 0;
    }

    public void pointWonBy(String player) {
        if(player1Name.equals(player)) {
            player1Score++;
        }else {
            player2Score++;
        }
    }

    public String score() {
        String scoreMessage = player1GameScore + "-" + player2GameScore;
        scoreMessage += ", ";

        if(player1Score >= 3 && player2Score >= 3) {
            //either deuce or advantage
            int scoreDiff = player1Score - player2Score;
            if(scoreDiff == 0) {
                scoreMessage = "Deuce";
            }else if(scoreDiff == 1) {
                scoreMessage = "Advantage" + getPlayerInLead();
            }
        }else {
            scoreMessage += SCORE_DESC[player1Score] + "-" + SCORE_DESC[player2Score];
        }

        return scoreMessage;
    }

    private String getPlayerInLead() {
        return player1Score > player2Score ? player1Name : player2Name;
    }
}
