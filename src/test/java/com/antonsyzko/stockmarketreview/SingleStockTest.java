package com.antonsyzko.stockmarketreview;

import org.junit.Test;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Admin on 26.09.2016.
 */
public class SingleStockTest {

    @Test
    public  void SingleStockTesting() {
        Stock stock = null;
        Stock stock2 = null;
        Stock intel = null;
        Stock airbus = null;
        Stock samsung = null;
        try {
            stock = YahooFinance.get("GC=F");
            stock2 = YahooFinance.get("INTC");
            samsung = YahooFinance.get("SSNLF");
            BigDecimal price2 = stock2.getQuote(true).getPrice();
            String[] symbols = new String[] {"INTC", "BABA", "TSLA", "AIR.PA", "YHOO","SSNLF"};
            Map<String, Stock> stocks = YahooFinance.get(symbols); // single request
             intel = stocks.get("INTC");
             airbus = stocks.get("AIR.PA");
            samsung = stocks.get("SSNLF");



        } catch (IOException e) {
            e.printStackTrace();
        }

        BigDecimal price = stock.getQuote().getPrice();
        BigDecimal change = stock.getQuote().getChangeInPercent();
        BigDecimal peg = stock.getStats().getPeg();
        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();



        stock.print();
        System.out.println("///////////////////////////////////////////");
        System.out.println("price double "+price.doubleValue());
        System.out.println("change double "+change.doubleValue());
        System.out.println("peg  double   "+peg.doubleValue());
        System.out.println("dividend "+dividend);
        System.out.println("//////////////////////////////////////////////");
        System.out.println(intel);
        System.out.println(airbus);
        System.out.println(samsung);
        intel.print();
        airbus.print();
        samsung.print();




    }
}
