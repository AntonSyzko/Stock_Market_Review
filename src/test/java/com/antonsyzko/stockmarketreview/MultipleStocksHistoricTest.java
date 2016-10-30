package com.antonsyzko.stockmarketreview;

import org.junit.Test;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

/**
 * Created by Admin on 26.09.2016.
 */
public class MultipleStocksHistoricTest {

    @Test
    public  void MultipleStocksHistoricTesting() {
        Stock intel = null;
        Stock airbus = null;
        Calendar from = null;
        Calendar to = null;

        try{
            from = Calendar.getInstance();
            to = Calendar.getInstance();
            from.add(Calendar.DAY_OF_MONTH, -3);
            String[] symbols = new String[] {"INTC", "BABA", "TSLA", "AIR.PA", "YHOO"};
// Can also be done with explicit from, to and Interval parameters
            //Map<String, Stock> stocks = YahooFinance.get(symbols, true);

            Map<String, Stock> stocks = YahooFinance.get(symbols,from,to,Interval.DAILY);
            for(Map.Entry<String,Stock> entry:stocks.entrySet()){
                System.out.println(entry.getKey() + " /  " + entry.getValue().getHistory(from,to,Interval.DAILY));
            }
//           intel  = stocks.get("INTC");
//           airbus = stocks.get("AIR.PA");
//            Stock google = YahooFinance.get("GOOG");
//            List<HistoricalQuote> googleHistQuotes = google.getHistory(Interval.MONTHLY);
//            Iterator altHistoricQoutes = googleHistQuotes.iterator();
//            while (altHistoricQoutes.hasNext()){
//                System.out.println(altHistoricQoutes.next());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
