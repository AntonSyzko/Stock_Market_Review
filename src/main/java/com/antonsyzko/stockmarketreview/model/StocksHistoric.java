package com.antonsyzko.stockmarketreview.model;

/**
 * Created by Admin on 25.10.2016.
 * @author Anton Syzko
 */
public class StocksHistoric {

//    private java.util.Date date;
    private double         open;
    private double         high;
    private double         low;
    private double         close;
    private double volume;
    private double price;

    public StocksHistoric(double open, double high, double low, double close, double  volume, double price) {
        super();
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.price = price;
        this.volume = volume;
    }

    public double getPrice() {
        return price;
    }

    public double getVolume() {
        return volume;
    }

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



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(20);
        return sb.append(


        "\tOpen: ").append(String.format("%1$.2f", open)
        ).append("\tHigh: ").append(String.format("%1$.2f", high)
        ).append("\tLow: ").append(String.format("%1$.2f", low)
        ).append("\tClose: ").append(String.format("%1$.2f", close)
        ).toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StocksHistoric that = (StocksHistoric) o;

        if (Double.compare(that.getOpen(), getOpen()) != 0) return false;
        if (Double.compare(that.getHigh(), getHigh()) != 0) return false;
        if (Double.compare(that.getLow(), getLow()) != 0) return false;
        if (Double.compare(that.getClose(), getClose()) != 0) return false;
        if (Double.compare(that.getVolume(), getVolume()) != 0) return false;
        return Double.compare(that.getPrice(), getPrice()) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getOpen());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getHigh());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getLow());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getClose());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getVolume());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
