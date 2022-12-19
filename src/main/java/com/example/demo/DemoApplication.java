package com.example.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.models.*;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run( ApplicationArguments args ) throws Exception
    {
        //System.out.println( "Name: " + name );

        int i = 0;
        for (String str : args.getSourceArgs()) {
            System.out.format( "Arg %d: %s%n", i, str );
        }
    }
}
