package ru.itsjava.services;

import org.springframework.stereotype.Service;
import ru.itsjava.domain.VeryNecessaryThing;

import java.util.List;

@Service("veryNecessaryThing")
public class VeryNecessaryThingServiceImpl implements VeryNecessaryThingService {

    private final VeryNecessaryThing thing1 = new VeryNecessaryThing("'Super thing' ", "Big ", "Red ", 100500);
    private final VeryNecessaryThing thing2 = new VeryNecessaryThing("'So-so' ", "Little ", "Green ", 100);
    private final VeryNecessaryThing thing3 = new VeryNecessaryThing("'It'll do' ", "Average ", "Black ", 500);
    private final VeryNecessaryThing thing4 = new VeryNecessaryThing("'It'll do' ", "Average ", "Black ", 50);
    private final List<VeryNecessaryThing> thingsTemp = List.of(thing1, thing2, thing3, thing4);

    @Override
    public void showingVeryNecessaryThing() {
        for (VeryNecessaryThing thing : thingsTemp) {
            System.out.println(thing);
        }
    }

    @Override
    public void byChoosingVeryNecessaryThingPrice(int price) {
        VeryNecessaryThing thingTemp;

        for (VeryNecessaryThing thing : thingsTemp) {
            if (thing.getPrice() == price) {
                thingTemp = thing;
                System.out.println(thingTemp);
                break;
            }
        }
    }
}
