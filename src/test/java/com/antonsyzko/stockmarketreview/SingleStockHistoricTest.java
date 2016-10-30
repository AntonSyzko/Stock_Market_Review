package com.antonsyzko.stockmarketreview;

import org.junit.Test;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.util.Calendar;

/**
 * Created by Admin on 26.09.2016.
 */
public class SingleStockHistoricTest {

    @Test
    public  void SingleStockHistoricTesting() {
        Stock tesla = null;
        Stock google = null;
        Calendar from = null;
        Calendar to = null;
        try {
            tesla = YahooFinance.get("TSLA", true);
            //System.out.println(tesla.getHistory());
            from = Calendar.getInstance();
             to = Calendar.getInstance();
            from.add(Calendar.MONTH, -1); // from 5 years ago

            google = YahooFinance.get("GOOG", from, to, Interval.WEEKLY);
           // System.out.println(google);
            System.out.println(google.getHistory(from,to));
            google.print();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
