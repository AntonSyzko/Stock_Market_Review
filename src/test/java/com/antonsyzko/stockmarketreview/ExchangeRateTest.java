package com.antonsyzko.stockmarketreview;
/**
 * Created by Admin on 10.10.2016.
 */

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ExchangeRateTest {

    private double getRate(String from, String to) {
        try {
            URL url = new URL("http://quote.yahoo.com/d/quotes.csv?f=l1&s=" + from + to + "=X");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            if (line.length() > 0) {
                return Double.parseDouble(line);
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }

    public double getEuroUsdRate() {
        return getRate("EUR", "BTC");
    }

    public double getGoldEuroRate() {
        return getRate("XAU", "EUR");
    }

    public double getSilverEuroRate() {
        return getRate("XAG", "EUR");
    }

    @Test
    public  void ExchangeRateTesting() {
        ExchangeRateTest exchange = new ExchangeRateTest();

        double rateSilver = exchange.getSilverEuroRate();
        System.out.println("Silver/Euro: " + rateSilver);

        double rateGold = exchange.getGoldEuroRate();
        System.out.println("Gold/Euro: " + rateGold);

        double rateUsd = exchange.getEuroUsdRate();
        System.out.println("GBP/BTC: " + rateUsd);
    }
}
