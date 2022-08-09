package ru.itsjava.domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class VeryNecessaryThingTest {
    private final static int PRICE = 10;

    @Test
    public void shouldHaveCorrectMethodGetPrice() {
        VeryNecessaryThing thing1 = new VeryNecessaryThing("'Super thing' ", "Big ", "Red ", 10);

        Assertions.assertEquals(PRICE,thing1.getPrice());
    }
}
