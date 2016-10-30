package com.antonsyzko.stockmarketreview;

import org.junit.Test;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.fx.FxQuote;
import yahoofinance.quotes.fx.FxSymbols;

import java.io.IOException;

/**
 * Created by Admin on 24.10.2016.
 */
public class ForexQuoteTest {

    @Test
    public void testFXQuote(){
        FxQuote usdeur = null;
        FxQuote usdgbp = null;
        try {
            usdeur = YahooFinance.getFx(FxSymbols.USDEUR);
            usdgbp = YahooFinance.getFx("USDGBP=X");


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(usdeur);
        System.out.println(usdgbp);
        System.out.println(usdeur.toString());
        try {
            System.out.println(usdgbp.getPrice(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
