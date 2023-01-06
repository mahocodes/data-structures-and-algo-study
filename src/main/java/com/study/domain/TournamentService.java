package com.study.domain;

import java.util.HashMap;
import java.util.List;

public class TournamentService {

    // Given an array of pairs representing teams and an array of the results of each competition, write a function that
    // returns the winner of the tournament. Each team faces all other teams at a time. One team will be the home team.
    // There's always a winner of each match. Win = 3 points and Loss = 0 points
    // The winner is the team with most amount of points.
    // There's always a winner and at least two teams
    // Ex: competitions = [[team1, team2],    and results = [0, 0, 1] then team1 = 0 points
    //                     [team2, team3],                                 team2 = 3 points
    //                     [team3, team1],                                 team3 = 6 points
    // Complexity => O(n) time, where n is the number of competitions. O(k) space where k is the number of teams
    public String printTheTournamentWinner(List<List<String>> competitions, List<Integer> results) {
        var hashTable = new HashMap<String, Integer>();
        var finalWinner = "";
        var highestScore = 0;

        for (int match = 0; match < competitions.size(); match++) {
            var matchResult = results.get(match);

            var winningTeam = competitions.get(match).get(matchResult == 0 ? 1 : 0);

            var oldScore = hashTable.getOrDefault(winningTeam, 0);
            var newScore = oldScore + 3;

            if (newScore > highestScore) {
                highestScore = newScore;
                finalWinner = winningTeam;
            }

            hashTable.put(winningTeam, newScore);
        }

        return finalWinner;
    }
}
