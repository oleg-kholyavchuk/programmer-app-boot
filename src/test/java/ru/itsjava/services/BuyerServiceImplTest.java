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
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class BuyerServiceImplTest {

    @Configuration
    static class MyConfiguration {

        public final VeryNecessaryThingService veryNecessaryThingService = new VeryNecessaryThingServiceImpl();
        private static final String string = "12";
        private final InputStream inputStream = new ByteArrayInputStream(string.getBytes(StandardCharsets.UTF_8));
        private final IOService ioService = new IOServiceImpl(inputStream);
        private final BuyerService buyerService = new BuyerServiceImpl(veryNecessaryThingService, ioService);

        @Test
        public void takeYourProductTest() {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            buyerService.takeYourProduct();

            Assertions.assertEquals("Hello. We are glad to see you!\r\n" + "Here are our products\r\n" +"VeryNecessaryThing{Title: 'Super thing' Size: Big Color: Red Price : 100500}\r\n" +
                   "VeryNecessaryThing{Title: 'So-so' Size: Little Color: Green Price : 100}\r\n"  + "VeryNecessaryThing{Title: 'It'll do' Size: Average Color: Black Price : 500}\r\n"  +
                   "VeryNecessaryThing{Title: 'It'll do' Size: Average Color: Black Price : 50}\r\n" + "Enter the exact amount of the product\r\n" + "Here is your product\r\n", out.toString());
        }
    }
}

