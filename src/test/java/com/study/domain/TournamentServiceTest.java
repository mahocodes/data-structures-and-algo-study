package com.study.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class TournamentServiceTest {
    @InjectMocks
    private TournamentService service;

    @Test
    void shouldPrintTheCorrectWinner() {
        var competitions = List.of(List.of("team1", "team2"), List.of("team2", "team3"), List.of("team3", "team2"));
        var result = List.of(0, 0, 1);

        var winner = service.printTheTournamentWinner(competitions, result);

        assertThat(winner).isEqualTo("team3");
    }

    @Test
    void shouldPrintTheCorrectWinner2() {
        var competitions = List.of(List.of("team1", "team2"), List.of("team2", "team1"));
        var result = List.of(1, 0);

        var winner = service.printTheTournamentWinner(competitions, result);

        assertThat(winner).isEqualTo("team1");
    }
}