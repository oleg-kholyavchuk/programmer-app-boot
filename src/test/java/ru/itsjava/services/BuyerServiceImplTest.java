package ru.itsjava.services;

import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.domain.VeryNecessaryThing;

import static org.mockito.Mockito.when;

@SpringBootTest
public class BuyerServiceImplTest {
//
//    @Configuration
//    static class MyConfiguration {
//
//        @Bean
//        public IOService ioService() {
//            IOService mockIOService = Mockito.mock(IOService.class);
//            when(mockIOService.input()).thenReturn("Oleg");
//
//            return mockIOService;
//        }
//
//        @Bean
//        public VeryNecessaryThingService veryNecessaryThingService() {
//            VeryNecessaryThingService mockVeryNecessaryThingService = Mockito.mock(VeryNecessaryThingServiceImpl.class);
//            when(mockVeryNecessaryThingService.getClass())
//                    .thenReturn(new VeryNecessaryThing("sfs", "fdfd", "dfdfdf", 12));
//            return mockVeryNecessaryThingService;
//        }
//    }
}
