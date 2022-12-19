package com.example.demo.check;
import com.example.demo.models.*;
import com.example.demo.sourse.HardCodedSource;
import com.example.demo.sourse.ISource;
import org.springframework.boot.ApplicationArguments;

import java.util.ArrayList;
import java.util.List;

public abstract class Check implements ICheck {
    protected DiscountCard card = null;
    protected ISource src;
    protected IReadStrategy reader;
    protected IWriteStrategy writer;
    public Check(ISource src, IReadStrategy reader, IWriteStrategy writer) {
        this.src = src;
        this.reader = reader;
        this.writer = writer;
    }
    public Check(String src, String reader, String writer) {
        if (src.equals("h")) {
            this.src = new HardCodedSource();
        }
        if (reader.equals("c")) {
            this.reader = new CheckConsoleReadStrategy();
        }
        if (writer.equals("c")) {
            this.writer = new CheckConsoleWriteStrategy();
        }
    }
    public void makeCheck(ApplicationArguments args) {
        String check = "";
        float total = 0;
        for (Arg arg : reader.readData(args)) {
            if (arg.key.equals("card")) {
                card = src.getCardById(Integer.parseInt(arg.val));
            } else {
                Product p = src.getProductByID(Integer.parseInt(arg.key));
                int amount = Integer.parseInt(arg.val);
                float res = amount * p.getCost();
                if (p.getSpecial() && amount > 5) res *= 0.9;
                total += res;
                check += arg.val + " " + p.getName() + " " + p.getCost() + " " + res + "$\n";
            }
        }
        check += "total: " + total +  "$";
        writer.writeData(check);
    }
}

