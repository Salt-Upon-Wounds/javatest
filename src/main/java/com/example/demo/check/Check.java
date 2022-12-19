package com.example.demo.check;
import com.example.demo.models.*;
import com.example.demo.sourse.HardCodedSource;
import com.example.demo.sourse.ISource;
import org.springframework.boot.ApplicationArguments;

import java.util.ArrayList;
import java.util.List;

public class Check implements ICheck {
    protected DiscountCard card = null;
    protected ISource src;
    protected IReadStrategy reader;
    protected IWriteStrategy writer;
    public Check(ISource src, IReadStrategy reader, IWriteStrategy writer) {
        this.src = src;
        this.reader = reader;
        this.writer = writer;
    }
    public Check(char src, char reader, char writer) {
        switch (src) {
            //case "h": this.src = new HardCodedSource(); break;
            default: this.src = new HardCodedSource(); break;
        }
        switch (src) {
            //case "c": this.reader = new CheckConsoleReadStrategy(); break;
            default: this.reader = new CheckConsoleReadStrategy(); break;
        }
        switch (src) {
            //case "c": new CheckConsoleWriteStrategy(); break;
            default: this.writer = new CheckConsoleWriteStrategy(); break;
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
        if (card != null) total *= 0.01 * (100 - card.getDiscount());
        check += "card: " + card.getName() + " " + card.getDiscount() + "%\n";
        check += "total: " + total +  "$";
        writer.writeData(check);
    }
}

