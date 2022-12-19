package com.example.demo;

import com.example.demo.check.Check;
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
        char[] arr = new char[3];

        if (args.containsOption("read")) {
            //первый символ первого значения опции
            arr[0] = args.getOptionValues("read").get(0).charAt(0);
        }

        if (args.containsOption("write")) {
            arr[1] = args.getOptionValues("write").get(0).charAt(0);
        }

        if (args.containsOption("src")) {
            arr[2] = args.getOptionValues("src").get(0).charAt(0);
        }

        Check check = new Check(arr[2], arr[0], arr[1]);
        check.makeCheck(args);
    }
}
