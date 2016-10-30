package com.antonsyzko.stockmarketreview.model;

/**
 * Created by Admin on 22.07.2016.
 * @author Anton Syzko
 */
import java.util.regex.Pattern;

public class StockHelper {

    public StockHelper() {}

    public strictfp double handleDouble(String x) {
        Double y;
        if (Pattern.matches("N/A", x)) {
            y = 0.00;
        } else {
            y = Double.parseDouble(x);
        }
        return y;
    }

    public strictfp int handleInt(String x) {
        int y;
        if (Pattern.matches("N/A", x)) {
            y = 0;
        } else {
            y = Integer.parseInt(x);
        }
        return y;
    }
}