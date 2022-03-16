package ru.itsjava.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.domain.Notebook;

@SpringBootTest
@DisplayName("Class NotebookServiceImpl")
public class NotebookServiceImplTest {

    @Configuration
    static class MyConfiguration {
        @Bean
        public NotebookService notebookService() {
            return new NotebookServiceImpl("apple", "air", 1990);
        }
    }

    @Autowired
    private NotebookServiceImpl notebookService;

    @Test
    @DisplayName("Give correct notebook")
    public void shouldHaveCorrectMethodGetNotebook() {
        Notebook notebook = notebookService.getNotebook();
        Assertions.assertEquals(notebook.getFirm(), "apple");

    }
}


