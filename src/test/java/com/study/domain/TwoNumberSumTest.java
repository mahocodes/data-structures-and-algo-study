package com.study.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class TwoNumberSumTest {

    private TwoNumberSum service;

    @BeforeEach
    void setUp() {
        service = new TwoNumberSum();
    }

    @Test
    void shouldFindTwoNumbersCorrectly() {
        var arr = new int[]{3, 5, -4, 8, 11, 1, -1, 6};

        var twoNumberArrResult = service.twoNumberSum(arr, 10);

        assertThat(twoNumberArrResult).contains(11, -1);
    }

    @Test
    void shouldReturnEmptyListWhenTwoNumbersNotFound() {
        var arr = new int[]{3, 5, -4, 8, 33, 40, 1, 6};

        var twoNumberArrResult = service.twoNumberSum(arr, 10);

        assertThat(twoNumberArrResult).isEmpty();
    }

    @Test
    void shouldFindTwoNumbersCorrectly2() {
        var arr = new int[]{3, 5, -4, 8, 11, 1, -1, 6};

        var twoNumberArrResult = service.twoNumberSum(arr, 10);

        assertThat(twoNumberArrResult).contains(11, -1);
    }

    @Test
    void shouldReturnEmptyListWhenTwoNumbersNotFound2() {
        var arr = new int[]{3, 5, -4, 8, 33, 40, 1, 6};

        var twoNumberArrResult = service.twoNumberSum(arr, 10);

        assertThat(twoNumberArrResult).isEmpty();
    }

    @Test
    void shouldFindTwoNumbersCorrectly3() {
        var arr = new int[]{3, 5, -4, 8, 11, 1, -1, 6};

        var twoNumberArrResult = service.twoNumberSum3(arr, 10);

        assertThat(twoNumberArrResult).contains(11, -1);
        System.out.println(Arrays.toString(twoNumberArrResult));
    }

    @Test
    void shouldReturnEmptyListWhenTwoNumbersNotFound3() {
        var arr = new int[]{3, 5, -4, 8, 33, 40, 1, 6};

        var twoNumberArrResult = service.twoNumberSum(arr, 10);

        assertThat(twoNumberArrResult).isEmpty();
    }
}