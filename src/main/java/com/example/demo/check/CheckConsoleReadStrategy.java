package com.example.demo.check;

import org.springframework.boot.ApplicationArguments;

import java.util.ArrayList;
import java.util.List;

public class CheckConsoleReadStrategy implements IReadStrategy {
    @Override
    public List<Arg> readData(ApplicationArguments args) {
        List<Arg> res = new ArrayList<>();
        for (String arg : args.getNonOptionArgs()) {
            if (arg.matches("^card\\-\\d$|^\\d\\-\\d$")) {
                String[] tmp = arg.split("-");
                res.add(new Arg(tmp[0], tmp[1]));
            }
        }
        return res;
    }
}
