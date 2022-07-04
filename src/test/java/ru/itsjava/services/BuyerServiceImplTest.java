package ru.itsjava.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.domain.VeryNecessaryThing;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class BuyerServiceImplTest {

    @Configuration
    static class MyConfiguration {

        @Bean
        public IOService ioService() {
            IOService mockIOService = Mockito.mock(IOService.class);
            when(mockIOService.input()).thenReturn(50);

            return mockIOService;
        }

        @Bean
        public VeryNecessaryThingService veryNecessaryThingService() {
            //Тут вопросики
            VeryNecessaryThing thing1 = new VeryNecessaryThing("'It'll do' ", "Average ", "Black ", 500);
            VeryNecessaryThing thing2 = new VeryNecessaryThing("'It'll do' ", "Average ", "Black ", 50);
            List<VeryNecessaryThing> thingsTemp = List.of(thing1, thing2);
            return (VeryNecessaryThingService) thing1;
        }

        @Bean
        public BuyerService buyerService(VeryNecessaryThingService veryNecessaryThingService, IOService ioService) {

            return new BuyerServiceImpl(veryNecessaryThingService, ioService);
        }

        @Autowired
        private BuyerService buyerService;

        @Test
        public void takeYourProductTest () {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            buyerService.takeYourProduct();

            Assertions.assertEquals("Hello. We are glad to see you!\n" + "Here are our products\n"
                   + "Enter the exact amount of the product\n" + "50\n" + "Here is your product\n", out.toString() );
        }
    }
}
