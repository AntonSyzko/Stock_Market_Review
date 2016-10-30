package com.antonsyzko.stockmarketreview.model;

/**
 * Created by Admin on 24.07.2016.
 * @author Anton Syzko
 */
public class Historic {

   private java.util.Date date;
    private double         open;
    private double         high;
    private double         low;
    private double         close;
    private double         volume;
    private double         adjClose;

    public Historic(java.util.Date date, double open, double high, double low,
                    double close, double volume, double adjClose) {
        super();

       this.date     = date;
        this.open     = open;
        this.high     = high;
        this.low      = low;
        this.close    = close;
        this.volume   = volume;
        this.adjClose = adjClose;
    }

//   public long getDate() {
//        return date.getTime();
//    }

    public strictfp double getOpen() {
        return open;
    }

    public strictfp double getHigh() {
        return high;
    }

    public strictfp double getLow() {
        return low;
    }

    public strictfp double getClose() {
        return close;
    }

    public strictfp double getVolume() {
        return volume;
    }

    public strictfp double getAdjClose() {
        return adjClose;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Historic{");
        sb.append("date=").append(date);
        sb.append(", open=").append(open);
        sb.append(", high=").append(high);
        sb.append(", low=").append(low);
        sb.append(", close=").append(close);
        sb.append(", volume=").append(volume);
        sb.append(", adjClose=").append(adjClose);
        sb.append('}');
        return sb.toString();
    }
}

