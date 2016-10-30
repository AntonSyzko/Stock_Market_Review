package com.antonsyzko.stockmarketreview.model;

/**
 * Created by Admin on 22.07.2016.
 * @author Anton Syzko
 */
public class Stock {

    private String symbol;
    private double price;
    private int volume;
    private double pe;
    private double eps;
    private double week52low;
    private double week52high;
    private double daylow;
    private double dayhigh;
    private double movingav50day;
    private double marketcap;
    private String name;
    private String currency;
    private double shortRatio;
    private double previousClose;
    private double open;
    private String exchange;

    public Stock(){}

    public Stock(String symbol, double price, int volume, double pe, double eps, double week52low,
                 double week52high, double daylow, double dayhigh, double movingav50day, double marketcap, String name, String currency, double shortRatio, double previousClose, double open, String exchange) {
        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.pe = pe;
        this.eps = eps;
        this.week52low = week52low;
        this.week52high = week52high;
        this.daylow = daylow;
        this.dayhigh = dayhigh;
        this.movingav50day = movingav50day;
        this.marketcap = marketcap;
        this.name = name;
        this.currency = currency;
        this.shortRatio = shortRatio;
        this.previousClose = previousClose;
        this.open = open;
        this.exchange = exchange;
    }

    public String getExchange(){
        return this.exchange;
    }

    public double getPreviousClose(){
        return this.previousClose;
    }

    public double getOpen(){
        return this.open;
    }

    public double getShortRatio(){
        return this.shortRatio;
    }

    public String getCurrency(){
        return this.currency;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public double getPrice() {
        return this.price;
    }

    public int getVolume() {
        return this.volume;
    }

    public double getPe() {
        return this.pe;
    }

    public double getEps() {
        return this.eps;
    }

    public double getWeek52low() {
        return this.week52low;
    }

    public double getWeek52high() {
        return this.week52high;
    }

    public double getDaylow() {
        return this.daylow;
    }

    public double getDayhigh() {
        return this.dayhigh;
    }

    public double getMovingav50day() {
        return this.movingav50day;
    }

    public double getMarketcap() {
        return this.marketcap;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (Double.compare(stock.getPrice(), getPrice()) != 0) return false;
        if (getVolume() != stock.getVolume()) return false;
        if (Double.compare(stock.getPe(), getPe()) != 0) return false;
        if (Double.compare(stock.getEps(), getEps()) != 0) return false;
        if (Double.compare(stock.getWeek52low(), getWeek52low()) != 0) return false;
        if (Double.compare(stock.getWeek52high(), getWeek52high()) != 0) return false;
        if (Double.compare(stock.getDaylow(), getDaylow()) != 0) return false;
        if (Double.compare(stock.getDayhigh(), getDayhigh()) != 0) return false;
        if (Double.compare(stock.getMovingav50day(), getMovingav50day()) != 0) return false;
        if (Double.compare(stock.getMarketcap(), getMarketcap()) != 0) return false;
        if (Double.compare(stock.getShortRatio(), getShortRatio()) != 0) return false;
        if (Double.compare(stock.getPreviousClose(), getPreviousClose()) != 0) return false;
        if (Double.compare(stock.getOpen(), getOpen()) != 0) return false;
        if (getSymbol() != null ? !getSymbol().equals(stock.getSymbol()) : stock.getSymbol() != null) return false;
        if (getName() != null ? !getName().equals(stock.getName()) : stock.getName() != null) return false;
        if (getCurrency() != null ? !getCurrency().equals(stock.getCurrency()) : stock.getCurrency() != null)
            return false;
        return getExchange() != null ? getExchange().equals(stock.getExchange()) : stock.getExchange() == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getSymbol() != null ? getSymbol().hashCode() : 0;
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getVolume();
        temp = Double.doubleToLongBits(getPe());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getEps());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getWeek52low());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getWeek52high());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getDaylow());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getDayhigh());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getMovingav50day());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getMarketcap());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCurrency() != null ? getCurrency().hashCode() : 0);
        temp = Double.doubleToLongBits(getShortRatio());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getPreviousClose());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getOpen());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getExchange() != null ? getExchange().hashCode() : 0);
        return result;
    }
}