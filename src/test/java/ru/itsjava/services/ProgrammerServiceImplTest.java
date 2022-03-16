package ru.itsjava.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import ru.itsjava.domain.Notebook;

import static org.mockito.Mockito.when;

@SpringBootTest
@SuppressWarnings("ALL")
@DisplayName("Class ProgrammerServiceImpl")
public class ProgrammerServiceImplTest {

    static class MyConfiguration() {

        @Bean
        public IOService ioService() {
            IOServiceImpl mockIOService = Mockito.mock(IOServiceImpl.class);
            when(mockIOService.input()).thenReturn("Vitaliy");

            return mockIOService;
        }

        @Bean
        public NotebookService notebookService() {
            NotebookServiceImpl mockNotebookService = Mockito.mock(NotebookServiceImpl.class);
            when(mockNotebookService.getNotebook()).thenReturn(new Notebook("Asus", "G115AF", 2019));

            return mockNotebookService;
        }

        @Bean
        public ProgrammerService programmerService(NotebookService notebookService, IOServiceImpl ioService) {

            return new ProgrammerServiceImpl(notebookService, ioService);

        }
    }

    @Autowired
    private ProgrammerService programmerService;

    @Test
    @DisplayName("Correct method 'Hi programmer'")
    public void shouldHaveCorrectSayHiToNewProgrammer() {
        programmerService.hiToNewProgrammer();
    }
}
