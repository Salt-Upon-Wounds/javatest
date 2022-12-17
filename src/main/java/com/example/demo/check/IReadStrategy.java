package com.example.demo.check;

import org.springframework.boot.ApplicationArguments;

import java.util.List;

public interface IReadStrategy {
    List<Arg> readData(ApplicationArguments args);
}
