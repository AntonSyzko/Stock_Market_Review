package com.antonsyzko.stockmarketreview;



import com.antonsyzko.stockmarketreview.model.Historic;
import com.antonsyzko.stockmarketreview.model.Interval;
import com.antonsyzko.stockmarketreview.model.StocksHistoric;
import com.antonsyzko.stockmarketreview.model.Symbol;
import org.junit.Test;

import java.util.*;

/**
 * Created by Admin on 25.10.2016.
 * @author Anton Syzko
 */
public class GetStocksHistoricApiTest {


    private static final int CONNECT_TIME_SECONDS = 2;
    private static final int READ_TIME_SECONDS    = 3;
    private static final String historicURL
            = "http://ichart.finance.yahoo.com/table.csv";

    @Test
    public  strictfp void GetStocksHistoricApiTesting() {
        GetStocksHistoricApiTest getstoks = new GetStocksHistoricApiTest();
        List<StocksHistoric>  historic = getstoks.getHistorical(new Symbol(
                        "GOOG", null),
                new GregorianCalendar(
                        2016, Calendar.SEPTEMBER, 1).getTime(),
                new GregorianCalendar(
                        2016, Calendar.SEPTEMBER, 30).getTime(),
                Interval.DAYLY);


        List<StocksHistoric>  historicYear = getstoks.getHistorical(new Symbol(
                        "GOOG", null),
                new GregorianCalendar(
                        2016, Calendar.JANUARY, 1).getTime(),
                new GregorianCalendar(
                        2016, Calendar.OCTOBER, 20).getTime(),
                Interval.MONTHLY);

        System.out.println(" ******************************************** "+historicYear.toString());

        //mapa

        Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
                        "INTC", null),
                new GregorianCalendar(
                        2015, Calendar.JANUARY, 1).getTime(),
                new GregorianCalendar(
                        2015, Calendar.DECEMBER, 31).getTime(),
                Interval.MONTHLY);


       for(Map.Entry<Integer,StocksHistoric> each : historicYearMap.entrySet()){
           System.out.println("  MONTH of  2015  " + each.getKey() + "  stocks price  :    " + each.getValue().getPrice() + "   /  vol   " + each.getValue().getVolume());
       }



        for (StocksHistoric value : historic) {
            System.out.println(value);

        }

        System.out.println(" list size " + historic.size());


        for (StocksHistoric value : historicYear) {
            System.out.println(value);

        }

        System.out.println("single o  " + historicYearMap.get(1).getOpen());
        System.out.println("single h  " + historicYearMap.get(1).getHigh());
        System.out.println("single l   " + historicYearMap.get(1).getLow());
        System.out.println(" close    " + historicYearMap.get(1).getClose());

        System.out.println("jan open " + historicYearMap.get(1).getOpen());


        System.out.println(" list size " + historicYear.size());
//        System.out.println(historic.iterator().next().getOpen());
//        System.out.println(  historic.iterator().next().getHigh());
//        System.out.println( historic.iterator().next().getLow());
//        System.out.println( historic.iterator().next().getClose());

        System.out.println(historic.get(0).getOpen());
        System.out.println(historic.get(0).getHigh());
        System.out.println(historic.get(0).getLow());
        System.out.println(historic.get(0).getClose());




        System.out.println(historic.get(1).getOpen());
        System.out.println(historic.get(1).getHigh());
        System.out.println(historic.get(1).getLow());
        System.out.println(historic.get(1).getClose());



        List res = new ArrayList();
        res.add(historic.get(0).getOpen());
        res.add(historic.get(0).getHigh());
        res.add(historic.get(0).getLow());
        res.add(historic.get(0).getClose());

        res.add(historic.get(1).getOpen());
        res.add(historic.get(1).getHigh());
        res.add(historic.get(1).getLow());
        res.add(historic.get(1).getClose());

        res.add(historic.get(2).getOpen());
        res.add(historic.get(2).getHigh());
        res.add(historic.get(2).getLow());
        res.add(historic.get(2).getClose());

        res.add(historic.get(3).getOpen());
        res.add(historic.get(3).getHigh());
        res.add(historic.get(3).getLow());
        res.add(historic.get(3).getClose());

        res.add(historic.get(4).getOpen());
        res.add(historic.get(4).getHigh());
        res.add(historic.get(4).getLow());
        res.add(historic.get(4).getClose());

        double ru = historic.listIterator(0).next().getOpen();
        double ru2 = historic.listIterator(1).next().getOpen();
        double ru3 = historic.listIterator(2).next().getOpen();
        double ru4 = historic.listIterator(3).next().getOpen();
        double ru5 = historic.listIterator(4).next().getOpen();

        System.out.println("*********" +"\r\n"+ ru +"\r\n"+ ru+ "\r\n"+ru2 +"\r\n"+ ru3 +"\r\n"+ ru4+"\r\n" + ru5 +"\r\n");



        System.out.println(res.toString());


    }



    public List<StocksHistoric> getHistorical(Symbol symbol,
                                                  Date start,
                                                  Date end,
                                                  Interval ival) {
        List<StocksHistoric> historic = new ArrayList<>(22);
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
                Historic historicValue;
                StringTokenizer st;
                String s;
            /* read title - Date,Open,High,Low,Close,Volume,Adj Close */
                br.readLine();
                while ((s = br.readLine()) != null) {
                    st = new StringTokenizer(s, ",");
                    Date date = new Date(
                            new java.text.SimpleDateFormat("yyyy-MM-dd").parse(
                                    st.nextToken()).getTime());
                    double open     = Double.parseDouble(st.nextToken());
                    double high     = Double.parseDouble(st.nextToken());
                    double low      = Double.parseDouble(st.nextToken());
                    double close    = Double.parseDouble(st.nextToken());
                    double price    = Double.parseDouble(st.nextToken());
                    double volume    = Double.parseDouble(st.nextToken());


                    historic.add(new StocksHistoric(open, high, low, close,price,volume));
                }
            }
            // } catch (java.net.MalformedURLException - straight OR logic
        } catch (
                java.io.IOException
                        | java.text.ParseException ex) {
//            LOG.warning(ex.toString());
        }
        return Collections.unmodifiableList(historic);
    }



    public Map<Integer,StocksHistoric> getHistoricalMap(Symbol symbol,
                                                        Date start,
                                                        Date end,
                                                        Interval ival) {
        int i = 0;
        Map<Integer,StocksHistoric> historicMap = new HashMap<Integer, StocksHistoric>();
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
                StocksHistoric historicValue;
                StringTokenizer st;
                String s;
            /* read title - Date,Open,High,Low,Close,Volume,Adj Close */
                br.readLine();
                while ((s = br.readLine()) != null) {
                    st = new StringTokenizer(s, ",");
                    Date date = new Date(
                            new java.text.SimpleDateFormat("yyyy-MM-dd").parse(
                                    st.nextToken()).getTime());
                    double open     = Double.parseDouble(st.nextToken());
                    double high     = Double.parseDouble(st.nextToken());
                    double low      = Double.parseDouble(st.nextToken());
                    double close    = Double.parseDouble(st.nextToken());
                    double price    = Double.parseDouble(st.nextToken());
                    double volume    = Double.parseDouble(st.nextToken());

                    //historic.add(new StocksHistoric(open, high, low, close));
                    historicMap.put(++i,new StocksHistoric(open,high,low,close,price,volume) );

                }
            }
            // } catch (java.net.MalformedURLException - straight OR logic
        } catch (
                java.io.IOException
                        | java.text.ParseException ex) {
//            LOG.warning(ex.toString());
        }
        return Collections.unmodifiableMap(historicMap);
    }
}
