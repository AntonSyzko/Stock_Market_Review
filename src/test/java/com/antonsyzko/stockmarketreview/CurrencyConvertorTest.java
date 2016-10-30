package com.antonsyzko.stockmarketreview;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Admin on 24.10.2016.
 */
public class CurrencyConvertorTest {

    @Test
    public void convert() throws IOException {
        String currencyFrom = "GBP";
        String currencyTo = "USD";
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://quote.yahoo.com/d/quotes.csv?s=" + currencyFrom + currencyTo + "=X&f=l1&e=.csv");
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = httpclient.execute(httpGet, responseHandler);
        httpclient.getConnectionManager().shutdown();
        System.out.println(Float.parseFloat(responseBody));
    }
}
