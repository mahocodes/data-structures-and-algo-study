package com.study.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChangeServiceTest {

    @InjectMocks
    private ChangeService service;

    @Test
    void shouldFindNonConstructibleChange() {
        var coins = new int[]{5, 7, 1, 1, 2, 3, 22};

        var nonConstructibleChange = service.nonConstructibleChange(coins);

        assertEquals(20, nonConstructibleChange);
    }

    @Test
    void shouldFindNonConstructibleChange2() {
        var coins = new int[]{1};

        var nonConstructibleChange = service.nonConstructibleChange(coins);

        assertEquals(2, nonConstructibleChange);
    }

    @Test
    void shouldFindNonConstructibleChange3() {
        var coins = new int[]{};

        var nonConstructibleChange = service.nonConstructibleChange(coins);

        assertEquals(0, nonConstructibleChange);
    }

    @Test
    void shouldFindNonConstructibleChange4() {
        var coins = new int[]{1, 1, 2};

        var nonConstructibleChange = service.nonConstructibleChange(coins);

        assertEquals(5, nonConstructibleChange);
    }
}