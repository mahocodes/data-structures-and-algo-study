package com.study.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SquareArrayElementsServiceTest {

    private SquareArrayElementsService service;

    @BeforeEach
    void setUp() {
        service = new SquareArrayElementsService();
    }

    @Test
    void shouldSquareElementsAndOrderCorrectly() {
        var array = new int[]{-7, 1, 4, 8};
        var expectedArray = new int[]{1, 16, 49, 64};

        var squaredArray = service.squareArrayElements(array);

        assertThat(squaredArray).isEqualTo(expectedArray);
    }

    @Test
    void shouldSquareElementsAndOrderCorrectlyWhenArrayHasJustOneElement() {
        var array = new int[]{-7};
        var expectedArray = new int[]{49};

        var squaredArray = service.squareArrayElements(array);

        assertThat(squaredArray).isEqualTo(expectedArray);
    }

    @Test
    void shouldSquareElementsAndOrderCorrectlyWithoutSorting() {
        var array = new int[]{-7, 1, 4, 8};
        var expectedArray = new int[]{1, 16, 49, 64};

        var squaredArray = service.squareArrayElements2(array);

        assertThat(squaredArray).isEqualTo(expectedArray);
    }
}