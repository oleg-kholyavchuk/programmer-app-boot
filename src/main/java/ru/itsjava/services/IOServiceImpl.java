package ru.itsjava.services;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService {
    private final Scanner reader;

    public IOServiceImpl(@Value("#{T(java.lang.System).in}") InputStream inputStream) {
        this.reader = new Scanner(inputStream);
    }

    @SneakyThrows
    @Override
    public int input() {
        return reader.nextInt();
    }
}
