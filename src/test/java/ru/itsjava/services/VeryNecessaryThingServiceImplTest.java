package ru.itsjava.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.domain.VeryNecessaryThing;

import java.util.Collection;
import java.util.List;

@SpringBootTest
public class VeryNecessaryThingServiceImplTest {

    @Test
    public void showingVeryNecessaryThingTest() {
        VeryNecessaryThing thing1 = new VeryNecessaryThing("'It'll do' ", "Average ", "Black ", 500);
        VeryNecessaryThing thing2 = new VeryNecessaryThing("'It'll do' ", "Average ", "Black ", 50);
        List<VeryNecessaryThing> thingsTemp = List.of(thing1, thing2);
        Assertions.assertTrue(thingsTemp.contains(thing1));
    }

    @Test
    public void byChoosingVeryNecessaryThingPriceTest() {
        VeryNecessaryThing thing1 = new VeryNecessaryThing("'It'll do' ", "Average ", "Black ", 500);
        VeryNecessaryThing thing2 = new VeryNecessaryThing("'It'll do' ", "Average ", "Black ", 50);
        List<VeryNecessaryThing> thingsTemp = List.of(thing1, thing2);
        Assertions.assertTrue(thingsTemp.contains(thing1));
        Assertions.assertTrue(thing1.getPrice() == 500);
    }
}
