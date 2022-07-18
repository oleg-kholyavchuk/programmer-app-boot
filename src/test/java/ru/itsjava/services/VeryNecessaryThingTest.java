package ru.itsjava.services;

import lombok.RequiredArgsConstructor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.itsjava.domain.VeryNecessaryThing;

@SpringBootTest
@RequiredArgsConstructor
public class VeryNecessaryThingTest {
    private final static int PRICE = 10;

    @Test
    public void shouldHaveCorrectMethodGetPrice() {
        VeryNecessaryThing thing1 = new VeryNecessaryThing("'Super thing' ", "Big ", "Red ", 10);

        Assertions.assertTrue(PRICE == thing1.getPrice());
    }
}
