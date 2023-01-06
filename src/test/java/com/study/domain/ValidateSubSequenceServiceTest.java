package com.study.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ValidateSubSequenceServiceTest {

    private ValidateSubSequenceService service;

    @BeforeEach
    void setUp() {
        service = new ValidateSubSequenceService();
    }

    @Test
    void shouldValidateSubsequence() {
        var array = List.of(-7, 1, 6, 8, 10, 12, 15);
        var sequence = List.of(1, 8, 12);

        var result = service.isSubsequenceValid(array, sequence);

        assertTrue(result);
    }

    @Test
    void shouldValidateSubsequence2() {
        var array = List.of(-7, 1, 6, 8, 10, 12, 15);
        var sequence = List.of(1, 8, 12);

        var result = service.isSubsequenceValidFor(array, sequence);

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForInvalidSubsequence() {
        var array = List.of(-7, 1, 6, 8, 10, 12, 15);
        var sequence = List.of(4, 5);

        var result = service.isSubsequenceValid(array, sequence);

        assertFalse(result);
    }

    @Test
    void shouldReturnFalseForInvalidSubsequence2() {
        var array = List.of(-7, 1, 6, 8, 10, 12, 15);
        var sequence = List.of(4, 5);

        var result = service.isSubsequenceValidFor(array, sequence);

        assertFalse(result);
    }

    @Test
    void shouldReturnFalseForInvalidSubsequence3() {
        var array = List.of(-7, 1, 6, 8, 10, 12, 15);
        var sequence = List.of(6, 1);

        var result = service.isSubsequenceValid(array, sequence);

        assertFalse(result);
    }

    @Test
    void shouldReturnFalseForInvalidSubsequence4() {
        var array = List.of(-7, 1, 6, 8, 10, 12, 15);
        var sequence = List.of(6, 1);

        var result = service.isSubsequenceValidFor(array, sequence);

        assertFalse(result);
    }


    @Test
    void shouldValidateSubsequenceWhenSequenceHasOneNumber() {
        var array = List.of(-7, 1, 6, 8, 10, 12, 15);
        var sequence = List.of(6);

        var result = service.isSubsequenceValid(array, sequence);

        assertTrue(result);
    }

    @Test
    void shouldValidateSubsequenceWhenAndSequenceHasOneNumber() {
        var array = List.of(6);
        var sequence = List.of(6);

        var result = service.isSubsequenceValid(array, sequence);

        assertTrue(result);
    }

}