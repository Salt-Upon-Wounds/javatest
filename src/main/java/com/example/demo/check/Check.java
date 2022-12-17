package com.example.demo.check;
import com.example.demo.models.*;
import com.example.demo.sourse.ISource;
import org.springframework.boot.ApplicationArguments;

import java.util.ArrayList;
import java.util.List;

public abstract class Check implements ICheck {
    protected DiscountCard card;
    protected ISource src;
    protected IReadStrategy reader;
    protected IWriteStrategy writer;
    public Check(ISource src, IReadStrategy reader, IWriteStrategy writer) {
        this.src = src;
        this.reader = reader;
        this.writer = writer;
    }
    public void makeCheck(ApplicationArguments args) {
        String check = "";
        for (Arg arg : reader.readData(args)) {
            check += arg.id + " " + arg.amount;
        }
        writer.writeData(check);
    }
}

