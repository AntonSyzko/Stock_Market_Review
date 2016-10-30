package com.antonsyzko.stockmarketreview;


import com.antonsyzko.stockmarketreview.model.Stock;
import com.antonsyzko.stockmarketreview.model.StockFetcher;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

/**
 * Created by Admin on 24.10.2016.
 */
public class StocjAsJsonTest {

    Stock FBS     = StockFetcher.getStock("FB");


@Test
public void   getStocksAsJsonObject(){
        String res = null;
    Stock curr  = StockFetcher.getStock("AAPL");
        Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        res = gson.toJson(curr);
    System.out.println(res.toString());

    }
}
