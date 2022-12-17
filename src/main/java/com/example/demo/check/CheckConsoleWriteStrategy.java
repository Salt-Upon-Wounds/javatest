package com.example.demo.check;

public class CheckConsoleWriteStrategy implements IWriteStrategy {
    @Override
    public void writeData(String check) {
        System.out.println(check);
    }
}
