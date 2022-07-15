package ru.itsjava.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Class IOServiceImpl")
public class IOServiceImplTest {

    @Configuration
    static class MyConfiguration {
        private static final int NUM = 12;
        private static final String string = "12";
        private final InputStream inputStream = new ByteArrayInputStream(string.getBytes(StandardCharsets.UTF_8));

        @Bean
        public IOService ioService() {
            return new IOServiceImpl(inputStream);
        }
    }

    @Autowired
    private IOService ioService;

    @Test
    @DisplayName("correct work method Input")
    public void shouldHaveCorrectInput() {
        assertEquals(MyConfiguration.NUM, ioService.input());

    }
}
