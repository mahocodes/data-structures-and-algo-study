package com.study.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ValidBracketsTest {

    @InjectMocks
    private ValidBrackets service;


    @Test
    void shouldReturnTrueWhenInputIsValid() {
        var result = service.isValid("{[]}");

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenInputIsInvalid() {
        var result = service.isValid("{[}]");

        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenInputIsInvalid2() {
        var result = service.isValid("{}(");

        assertFalse(result);
    }
}