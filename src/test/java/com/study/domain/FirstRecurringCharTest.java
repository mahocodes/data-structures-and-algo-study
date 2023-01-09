package com.study.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class FirstRecurringCharTest {

    @InjectMocks
    private FirstRecurringChar service;

    @Test
    void shouldReturnCorrectIndexForString() {
        var string = "abcabc";

        var index = service.firstRecurringChar(string);

        assertThat(index).isEqualTo(3);
    }

    @Test
    void shouldReturnDefaultValueOfMinusOneWhenStringDoesNotHaveAnyRepeatingChar() {
        var string = "abcdefg";

        var index = service.firstRecurringChar(string);

        assertThat(index).isEqualTo(-1);
    }
}