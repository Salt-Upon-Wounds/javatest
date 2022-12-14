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
        Product[] Products = {
                new Product(0, 1.2F, "cup"),
                new Product(1, 5.2F, "apple"),
                new Product(2, 10F, "milk"),
                new Product(3, 3.67F, "bread"),
        };
        int i = 0;
        for (String str : args.getSourceArgs()) {
            System.out.format( "Arg %d: %s%n", i, str );
        }
    }
}
