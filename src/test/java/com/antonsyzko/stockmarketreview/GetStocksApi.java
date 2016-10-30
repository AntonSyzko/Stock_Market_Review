
package com.antonsyzko.stockmarketreview;


import com.antonsyzko.stockmarketreview.model.Historic;
import com.antonsyzko.stockmarketreview.model.Interval;
import com.antonsyzko.stockmarketreview.model.Symbol;
import org.junit.Test;

import java.util.Calendar;

/**
 * Created by Admin on 24.07.2016.
 */
public class GetStocksApi {


    private static final int CONNECT_TIME_SECONDS = 2;
    private static final int READ_TIME_SECONDS    = 3;
    private static final String historicURL
            = "http://ichart.finance.yahoo.com/table.csv";

    @Test
    public  void GetStocksApiTesting() {
        GetStocksApi getstoks = new GetStocksApi();
        java.util.List<Historic>  historic = getstoks.getHistorical(new Symbol(
                        "DVMT", null),
                new java.util.GregorianCalendar(
                        2016, Calendar.JANUARY, 01).getTime(),
                new java.util.GregorianCalendar(
                        2016, Calendar.OCTOBER, 20).getTime(),
                Interval.MONTHLY);

        for (Historic value : historic) {
            System.out.println(value.getVolume());

        }





    }



    public java.util.List<Historic> getHistorical(Symbol symbol,
                                                  java.util.Date start,
                                                  java.util.Date end,
                                                  Interval ival) {
        java.util.List<Historic> historic = new java.util.ArrayList<>(20);
        java.net.URL           url;
        java.net.URLConnection connection;
    /* a - Month number, starting with 0 for January. */
        String a = Integer.toString(Integer.parseInt(
                new java.text.SimpleDateFormat("MM").format(start)) - 1);
    /* b - Day number, eg, 1 for the first of the month. */
        String b = Integer.toString(Integer.parseInt(
                new java.text.SimpleDateFormat("dd").format(start)));
    /* c - Year. */
        String c = Integer.toString(Integer.parseInt(
                new java.text.SimpleDateFormat("yyyy").format(start)));
    /* d - Month number, starting with 0 for January. */
        String d = Integer.toString(Integer.parseInt(
                new java.text.SimpleDateFormat("MM").format(end)) - 1);
    /* e - Day number, eg, 1 for the first of the month. */
        String e = Integer.toString(Integer.parseInt(
                new java.text.SimpleDateFormat("dd").format(end)));
    /* f - Year. */
        String f = Integer.toString(Integer.parseInt(
                new java.text.SimpleDateFormat("yyyy").format(end)));
    /* frequency of historical prices */
        String g;
        switch (ival) {
            case DAYLY:
                g = "d";
                break;
            case WEEKLY:
                g = "w";
                break;
            case MONTHLY:
                g = "m";
                break;
            default:
                g = "d";
                break;
        }
        try {
            url = new java.net.URL(historicURL + "?s=" + symbol.getCode()
                    + "&d=" + d + "&e=" + e + "&f=" + f + "&g="
                    + g +"&a=" + a + "&b=" + b + "&c=" + c
                    + "&ignore=.csv");
            connection = url.openConnection();
            connection.setConnectTimeout(CONNECT_TIME_SECONDS * 1000);
            connection.setReadTimeout(READ_TIME_SECONDS * 1000);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            try (java.io.BufferedReader br = new java.io.BufferedReader(
                    new java.io.InputStreamReader(connection.getInputStream()))) {
//                Historic historicValue;
                java.util.StringTokenizer st;
                String s;
            /* read title - Date,Open,High,Low,Close,Volume,Adj Close */
                br.readLine();
                while ((s = br.readLine()) != null) {
                    st = new java.util.StringTokenizer(s, ",");
                    java.util.Date date = new java.util.Date(
                            new java.text.SimpleDateFormat("yyyy-MM-dd").parse(
                                    st.nextToken()).getTime());
                    double open     = Double.parseDouble(st.nextToken());
                    double high     = Double.parseDouble(st.nextToken());
                    double low      = Double.parseDouble(st.nextToken());
                    double close    = Double.parseDouble(st.nextToken());
                    double volume   = Double.parseDouble(st.nextToken());
                    double adjClose = Double.parseDouble(st.nextToken());
                    historic.add(new Historic(date, open, high, low, close,
                            volume, adjClose));
                }
            }
            // } catch (java.net.MalformedURLException - straight OR logic
        } catch (
                 java.io.IOException
                | java.text.ParseException ex) {
//            LOG.warning(ex.toString());
        }
        return java.util.Collections.unmodifiableList(historic);
    }
}
