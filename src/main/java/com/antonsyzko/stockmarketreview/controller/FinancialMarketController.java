package com.antonsyzko.stockmarketreview.controller;

import com.antonsyzko.stockmarketreview.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.fx.FxQuote;
import yahoofinance.quotes.fx.FxSymbols;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

//import com.antonsyzko.yahoofinance.model.Pudov.*;

/**
 * Created by Admin on 29.10.2016.
 *  @author Anton Syzko

 */
@Controller
@RequestMapping("/")
public class FinancialMarketController {

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String fsStocks(Model model) {
        model.addAttribute("oracleStock", StockFetcher.getStock("ORCL"));
        model.addAttribute("googStock", StockFetcher.getStock("GOOG"));
        model.addAttribute("yhooStock", StockFetcher.getStock("YHOO"));
        model.addAttribute("msftStock", StockFetcher.getStock("MSFT"));
        model.addAttribute("intcStock", StockFetcher.getStock("INTC"));
        model.addAttribute("appleStock", StockFetcher.getStock("AAPL"));
        model.addAttribute("fbStock", StockFetcher.getStock("FB"));
        model.addAttribute("amznStock", StockFetcher.getStock("AMZN"));
        model.addAttribute("citigroupStock", StockFetcher.getStock("C"));
        model.addAttribute("hpqStock", StockFetcher.getStock("HPQ"));
        model.addAttribute("dellStock", StockFetcher.getStock("DVMT"));
        model.addAttribute("ibmStock", StockFetcher.getStock("IBM"));

        return "mainstocksview";

    }
    @RequestMapping(value = "/currencytickUSDEUR", method = RequestMethod.GET)
    @ResponseBody
    final public   String getTick() {
        double tickPriceGBPUSD = 0;
        double tickPriceGBPEUR = 0;
        double tickPriceGBPJPY = 0;
        double tickPriceGBPCHF = 0;
        double tickPriceGBPNZD = 0;
        double tickPriceGBPCAD = 0;
        double tickPriceGBPAUD = 0;

        double tickPriceEURGBP = 0;
        double tickPriceEURUSD = 0;
        double tickPriceEURCHF = 0;
        double tickPriceEURJPY = 0;
        double tickPriceEURCAD = 0;
        double tickPriceEURAUD = 0;
        double tickPriceEURNZD = 0;

        double tickPriceUSDGBP = 0;
        double tickPriceUSDEUR = 0;
        double tickPriceUSDJPY = 0;
        double tickPriceUSDCHF = 0;
        double tickPriceUSDCAD = 0;
        double tickPriceUSDAUD = 0;
        double tickPriceUSDNZD = 0;

        FxQuote GBPUSD = null;
        FxQuote GBPEUR = null;
        FxQuote GBPJPY  = null;
        FxQuote GBPCHF = null;
        FxQuote GBPNZD = null;
        FxQuote GBPCAD = null;
        FxQuote GBPAUD = null;

        FxQuote EURGBP = null;
        FxQuote EURUSD = null;
        FxQuote EURCHF = null;
        FxQuote EURCAD= null;
        FxQuote EURJPY = null;
        FxQuote EURAUD = null;
        FxQuote EURNZD = null;

        FxQuote USDGBP = null;
        FxQuote USDEUR = null;
        FxQuote USDJPY = null;
        FxQuote USDCHF= null;
        FxQuote USDCAD = null;
        FxQuote USDAUD = null;
        FxQuote USDNZD = null;

        Stock Gold = null;
        Stock GoldFutures = null;
        Stock Silver = null;
        Stock SilverFutures = null;
        Stock BrentOilFutures = null;
        Stock RBOBGasolineFutures = null;
        Stock LightSweetCrudeOilFutures = null;
        Stock HenryHubNaturalGasFutures = null;

        BigDecimal priceGold = new BigDecimal(0);
        BigDecimal priceGoldFutures = new BigDecimal(0);
        BigDecimal priceSilver = new BigDecimal(0);
        BigDecimal priceSilverFutures = new BigDecimal(0);
        BigDecimal priceBrentOilFutures = new BigDecimal(0);
        BigDecimal priceOIL = new BigDecimal(0);
        BigDecimal priceRBOBGasolineFutures = new BigDecimal(0);
        BigDecimal priceHenryHubNaturalGasFutures = new BigDecimal(0);

        try {
            GBPUSD = YahooFinance.getFx(FxSymbols.GBPUSD);
            GBPEUR = YahooFinance.getFx(FxSymbols.GBPEUR);
            GBPJPY = YahooFinance.getFx(FxSymbols.GBPJPY);
            GBPCHF = YahooFinance.getFx(FxSymbols.GBPCHF);
            GBPNZD = YahooFinance.getFx(FxSymbols.GBPNZD);
            GBPCAD = YahooFinance.getFx(FxSymbols.GBPCAD);
            GBPAUD = YahooFinance.getFx(FxSymbols.GBPAUD);

            EURGBP = YahooFinance.getFx(FxSymbols.EURGBP);
            EURUSD = YahooFinance.getFx(FxSymbols.EURUSD);
            EURCHF = YahooFinance.getFx(FxSymbols.EURCHF);
            EURCAD= YahooFinance.getFx(FxSymbols.EURCAD);
            EURJPY = YahooFinance.getFx(FxSymbols.EURJPY);
            EURAUD = YahooFinance.getFx(FxSymbols.EURAUD);
            EURNZD = YahooFinance.getFx(FxSymbols.EURNZD);

            USDGBP = YahooFinance.getFx(FxSymbols.USDGBP);
            USDEUR = YahooFinance.getFx(FxSymbols.USDEUR);
            USDJPY = YahooFinance.getFx(FxSymbols.USDJPY);
            USDCHF= YahooFinance.getFx(FxSymbols.USDCHF);
            USDCAD = YahooFinance.getFx(FxSymbols.USDCAD);
            USDAUD = YahooFinance.getFx(FxSymbols.USDAUD);
            USDNZD = YahooFinance.getFx(FxSymbols.USDNZD);

            Gold = YahooFinance.get("ZG=F");;
            GoldFutures = YahooFinance.get("GC=F");;
            Silver = YahooFinance.get("ZI=F");;
            SilverFutures = YahooFinance.get("SI=F");;
            BrentOilFutures = YahooFinance.get("BZ=F");;
            RBOBGasolineFutures = YahooFinance.get("RB=F");;
            LightSweetCrudeOilFutures = YahooFinance.get("CL=F");;
            HenryHubNaturalGasFutures = YahooFinance.get("NG=F");;

            priceGold = Gold.getQuote(true).getPrice();
            priceGoldFutures = GoldFutures.getQuote(true).getPrice();
            priceSilver = Silver.getQuote(true).getPrice();
            priceSilverFutures = SilverFutures.getQuote(true).getPrice();
            priceBrentOilFutures = BrentOilFutures.getQuote(true).getPrice();
            priceOIL = LightSweetCrudeOilFutures.getQuote(true).getPrice();
            priceRBOBGasolineFutures = RBOBGasolineFutures.getQuote(true).getPrice();
            priceHenryHubNaturalGasFutures = HenryHubNaturalGasFutures.getQuote(true).getPrice();

            tickPriceGBPUSD = GBPUSD.getPrice(true).doubleValue();
            tickPriceGBPEUR = GBPEUR.getPrice(true).doubleValue();
            tickPriceGBPJPY = GBPJPY.getPrice(true).doubleValue();
            tickPriceGBPCHF = GBPCHF.getPrice(true).doubleValue();
            tickPriceGBPNZD = GBPNZD.getPrice(true).doubleValue();
            tickPriceGBPCAD = GBPCAD.getPrice(true).doubleValue();
            tickPriceGBPAUD = GBPAUD.getPrice(true).doubleValue();

            tickPriceEURGBP = EURGBP.getPrice(true).doubleValue();
            tickPriceEURUSD = EURUSD.getPrice(true).doubleValue();
            tickPriceEURCHF = EURCHF.getPrice(true).doubleValue();
            tickPriceEURJPY = EURJPY.getPrice(true).doubleValue();
            tickPriceEURCAD = EURCAD.getPrice(true).doubleValue();
            tickPriceEURAUD = EURAUD.getPrice(true).doubleValue();
            tickPriceEURNZD = EURNZD.getPrice(true).doubleValue();

            tickPriceUSDGBP = USDGBP.getPrice(true).doubleValue();
            tickPriceUSDEUR = USDEUR.getPrice(true).doubleValue();
            tickPriceUSDJPY = USDJPY.getPrice(true).doubleValue();
            tickPriceUSDCHF = USDCHF.getPrice(true).doubleValue();
            tickPriceUSDCAD = USDCAD.getPrice(true).doubleValue();
            tickPriceUSDAUD = USDAUD.getPrice(true).doubleValue();
            tickPriceUSDNZD = USDNZD.getPrice(true).doubleValue();

        }catch (IOException e){
            e.getMessage();
        }

        String result =
//                "<br>  <b style=\"color:green\"> &nbsp;&nbsp;&nbsp;GBP / USD&nbsp;&nbsp;</b>    <b>" + tickPriceGBPUSD + "</b>"+"  <b style=\"color:blue\">&nbsp; &nbsp;&nbsp;GBP / EUR&nbsp;&nbsp;</b>  <b>  "+ tickPriceGBPEUR + "</b> "+
//                "  <b style=\"color:darkgreen\">&nbsp; &nbsp;&nbsp;GBP / JPY&nbsp;&nbsp;</b>  <b>  "+ tickPriceGBPJPY + "</b> " +" <b style=\"color:cornflowerblue\"> &nbsp;&nbsp;&nbsp;GBP / CHF &nbsp;&nbsp; </b>  <b>  "+ tickPriceGBPCHF + "</b> "+
//                "  <b style=\"color:forestgreen\">&nbsp;&nbsp;&nbsp; GBP / CAD &nbsp;&nbsp;</b>  <b>  "+ tickPriceGBPCAD + "</b> " +"  <b style=\"color:deepskyblue\">&nbsp;&nbsp;&nbsp; GBP / AUD &nbsp;&nbsp;</b>  <b>  "+ tickPriceGBPAUD + "</b> "+
//                "  <b style=\"color:forestgreen\">&nbsp;&nbsp;&nbsp; GBP / NZD &nbsp;&nbsp;</b>  <b>  "+ tickPriceGBPNZD + "</b> "+
//
//                "<br>  <b style=\"color:green\">&nbsp;&nbsp; &nbsp;EUR / GBP&nbsp;&nbsp;</b>    <b>" + tickPriceEURGBP + "</b>"+"  <b style=\"color:blue\"> &nbsp;&nbsp;&nbsp;EUR / USD&nbsp;&nbsp;</b>  <b>  "+ tickPriceEURUSD + "</b> "+
//                " <b style=\"color:darkgreen\">&nbsp; &nbsp;&nbsp;EUR / JPY &nbsp;&nbsp; </b>  <b>  "+ tickPriceEURJPY + "</b> "+ "  <b style=\"color:cornflowerblue\">&nbsp; &nbsp;&nbsp;EUR / CHF&nbsp;&nbsp;</b>  <b>  "+ tickPriceEURCHF + "</b> " +
//                "  <b style=\"color:forestgreen\">&nbsp;&nbsp;&nbsp; EUR / CAD &nbsp;&nbsp;</b>  <b>  "+ tickPriceEURCAD + "</b> " +"  <b style=\"color:deepskyblue\">&nbsp;&nbsp;&nbsp; EUR / AUD &nbsp;&nbsp;</b>  <b>  "+ tickPriceEURAUD + "</b> "+
//                "  <b style=\"color:forestgreen\">&nbsp;&nbsp;&nbsp; EUR / NZD &nbsp;&nbsp;</b>  <b>  "+ tickPriceEURNZD + "</b> "+
//
//                "<br>  <b style=\"color:green\"> &nbsp;&nbsp;&nbsp;USD / GBP&nbsp;&nbsp;</b>    <b>" + tickPriceUSDGBP + "</b>"+"  <b style=\"color:blue\"> &nbsp;&nbsp;&nbsp;USD / EUR&nbsp;&nbsp;</b>  <b>  "+ tickPriceUSDEUR + "</b> "+
//                "  <b style=\"color:darkgreen\"> &nbsp;&nbsp;&nbsp;USD / JPY&nbsp;&nbsp;</b>  <b>  "+ tickPriceUSDJPY + "</b> " +" <b style=\"color:cornflowerblue\"> &nbsp;&nbsp;&nbsp;USD / CHF &nbsp;&nbsp; </b>  <b>  "+ tickPriceUSDCHF + "</b> "+
//                "  <b style=\"color:forestgreen\">&nbsp;&nbsp;&nbsp; USD / CAD &nbsp;&nbsp;</b>  <b>  "+ tickPriceUSDCAD + "</b> " +"  <b style=\"color:deepskyblue\">&nbsp;&nbsp;&nbsp; USD / AUD &nbsp;&nbsp;</b>  <b>  "+ tickPriceUSDAUD + "</b> "+
//                "  <b style=\"color:forestgreen\">&nbsp;&nbsp;&nbsp; USD / NZD &nbsp;&nbsp;</b>  <b>  "+ tickPriceUSDNZD + "</b> "+
//
//
//
//
//                "<br/>    <b style=\"color:forestgreen\">&nbsp;&nbsp;&nbsp; GOLD &nbsp;&nbsp;</b>  <b>  "+ priceGold + "</b> " +"  <b style=\"color:deepskyblue\">&nbsp;&nbsp;&nbsp; GOLD FUTURES &nbsp;&nbsp;</b>  <b>  "+ priceGoldFutures + "</b> "+
//                "  <b style=\"color:forestgreen\">&nbsp;&nbsp;&nbsp; SILVER &nbsp;&nbsp;</b>  <b>  "+ priceSilver + "</b> " +"   <b style=\"color:deepskyblue\">&nbsp;&nbsp;&nbsp; SILVER FUTURES&nbsp;&nbsp;</b>  <b>  "+ priceSilverFutures + "</b> "+
//                "  <b style=\"color:forestgreen\">&nbsp;&nbsp;&nbsp; LIGHT SWEET CRUDE OIL FUTURES&nbsp;&nbsp;</b>  <b>  "+ priceOIL + "</b> " +" <br/> <b style=\"color:deepskyblue\">&nbsp;&nbsp;&nbsp; BRENT CRUDE OIL FUTURES&nbsp;&nbsp;</b>  <b>  "+ priceBrentOilFutures + "</b> "+
//                "   <b style=\"color:forestgreen\">&nbsp;&nbsp;&nbsp; HENRY HUB NATURAL GAS FUTURES&nbsp;&nbsp;</b>  <b>  "+ priceHenryHubNaturalGasFutures + "</b> " +"  <b style=\"color:deepskyblue\">&nbsp;&nbsp;&nbsp; RBOB GASOLINE FUTURES &nbsp;&nbsp;</b>  <b>  "+ priceRBOBGasolineFutures + "</b> "
                " &nbsp;&nbsp; <b style=\"color:blue;margin-left: 80%\">" + new Date().toString() + "</b><br/>"+

                "<div class=\"container\">\n" +
                "\n" +
                "  <div class=\"table-responsive  \">\n" +
                "  <table class=\"table table-bordered table-condensed  table-hover  table-striped\">\n" +
                        " <caption style=\"margin-left: 40%\"><b><i class=\"fa fa-refresh fa-spin\" style=\"font-size:15px\"></i> &nbsp;&nbsp;&nbsp;YAHOO FINANCE LIVE RATES&nbsp;&nbsp;&nbsp;<i class=\"fa fa-refresh fa-spin\" style=\"font-size:15px\"></i></b></caption>\n"+
                "    <thead>\n" +
                "      <tr>\n" +
                "        <th style=\"color:green\">GBP / USD</th>\n" +
                "        <th style=\"color:deepskyblue\">GBP/EUR</th>\n" +
                "        <th style=\"color:green\">GBP/JPY</th>\n" +
                "        <th style=\"color:deepskyblue\">GBP/CHF</th>\n" +
                "        <th style=\"color:green\">GBP/CAD</th>\n" +
                "        <th style=\"color:deepskyblue\">GBP/AUD</th>\n" +
                "        <th style=\"color:green\">GBP/NZD</th>\n" +
                "       \n" +
                "        <th style=\"color:deepskyblue\">EUR/GBP</th>\n" +
                "        <th style=\"color:green\">EUR/USD</th>\n" +
                "        <th style=\"color:deepskyblue\">EUR/JPY</th>\n" +
                "\n" +
                "\n" +
                "      </tr>\n" +
                "    </thead>\n" +
                "    <tbody>\n" +
                "      <tr>\n" +
                "        <td>"+tickPriceGBPUSD+"</td>\n" +
                "        <td>"+tickPriceGBPEUR+"</td>\n" +
                "        <td>"+tickPriceGBPJPY+"</td>\n" +
                "        <td>"+tickPriceGBPCHF+"</td>\n" +
                "        <td>"+tickPriceGBPCAD+"</td>\n" +
                "        <td>"+tickPriceGBPAUD+"</td>\n" +
                "        <td>"+tickPriceGBPNZD+"</td>\n" +
                "        <td>"+tickPriceEURGBP+"</td>\n" +
                "        <td>"+tickPriceEURUSD+"</td>\n" +
                "        <td>"+tickPriceEURJPY+"</td>\n" +
                "      </tr>\n" +
                "    </tbody>\n" +
                "  </table>\n" +
                "  </div>\n" +
                "<div class=\"table-responsive\">\n" +
                "  <table class=\"table table-bordered table-condensed  table-hover  table-striped\">\n" +
                "    <thead>\n" +
                "      <tr>\n" +
                "        <th style=\"color:green\"> EUR/CHF</th>\n" +
                "        <th style=\"color:deepskyblue\">EUR/CAD</th>\n" +
                "        <th style=\"color:green\">EUR/AUD</th>\n" +
                "        <th style=\"color:deepskyblue\">EUR/NZD</th>\n" +
                "        <th style=\"color:green\">USD/GBP</th>\n" +
                "        <th style=\"color:deepskyblue\">USD/EUR</th>\n" +
                "        <th style=\"color:green\">USD/JPY</th>\n" +
                "       \n" +
                "        <th style=\"color:deepskyblue\">USD/CHF</th>\n" +
                "        <th style=\"color:green\">USD/CAD</th>\n" +
                "        <th style=\"color:deepskyblue\">USD/AUD</th>\n" +
                "\n" +
                "\n" +
                "      </tr>\n" +
                "    </thead>\n" +
                "    <tbody>\n" +
                "      <tr>\n" +
                "        <td>"+tickPriceEURCHF+"</td>\n" +
                "        <td>"+tickPriceEURCAD+"</td>\n" +
                "        <td>"+tickPriceEURAUD+"</td>\n" +
                "        <td>"+tickPriceEURNZD+"</td>\n" +
                "        <td>"+tickPriceUSDGBP+"</td>\n" +
                "        <td>"+tickPriceUSDEUR+"</td>\n" +
                "        <td>"+tickPriceUSDJPY+"</td>\n" +
                "        <td>"+tickPriceUSDCHF+"</td>\n" +
                "        <td>"+tickPriceUSDCAD+"</td>\n" +
                "        <td>"+tickPriceUSDAUD+"</td>\n" +
                "      </tr>\n" +
                "    </tbody>\n" +
                "  </table>\n" +
                "  </div>\n" +
                "<div class=\"table-responsive\">\n" +
                "  <table class=\"table table-bordered table-condensed  table-hover  table-striped\">\n" +
                "    <thead>\n" +
                "      <tr>\n" +
                "        <th style=\"color:green\">GOLD</th>\n" +
                "        <th style=\"color:deepskyblue\">GOLD FUTURES</th>\n" +
                "        <th style=\"color:green\">SILVER</th>\n" +
                "        <th style=\"color:deepskyblue\">SILVER FUTURES</th>\n" +
                "        <th style=\"color:green\">CRUDE OIL</th>\n" +
                "        <th style=\"color:deepskyblue\">BRENT CRUDE OIL</th>\n" +
                "       \n" +
                "        <th style=\"color:green\">NATURAL GAS</th>\n" +
                "        <th style=\"color:deepskyblue\">GASOLINE</th>\n" +
                "        <th style=\"color:green\">USD/NZD</th>\n" +
                "\n" +
                "\n" +
                "      </tr>\n" +
                "    </thead>\n" +
                "    <tbody>\n" +
                "      <tr>\n" +
                "        <td>"+priceGold+"</td>\n" +
                "        <td>"+priceGoldFutures+"</td>\n" +
                "        <td>"+priceSilver+"</td>\n" +
                "        <td>"+priceSilverFutures+"</td>\n" +
                "        <td>"+priceOIL+"</td>\n" +
                "        <td>"+priceBrentOilFutures+"</td>\n" +
                "        <td>"+priceHenryHubNaturalGasFutures+"</td>\n" +
                "        <td>"+priceRBOBGasolineFutures+"</td>\n" +
                "        <td>"+tickPriceUSDNZD+"</td>\n" +

                "      </tr>\n" +
                "    </tbody>\n" +
                "  </table>\n" +
                "  </div>\n" +
                "</div>";
        return result;
    }

    @ModelAttribute("stockMapForFB")
    public strictfp Map<Integer,StocksHistoric> stocksMapaFB(){
        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
        Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
                        "FB", null),
                new java.util.GregorianCalendar(
                        2016, Calendar.JANUARY, 1).getTime(),
                new java.util.GregorianCalendar(
                        2016, Calendar.OCTOBER,20 ).getTime(),
                Interval.MONTHLY);

        return historicYearMap;
    }

    @ModelAttribute("stockMapForAAPL")
    public strictfp Map<Integer,StocksHistoric> stocksMapaApple(){
        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
        Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
                        "AAPL", null),
                new java.util.GregorianCalendar(
                        2016, Calendar.JANUARY, 1).getTime(),
                new java.util.GregorianCalendar(
                        2016, Calendar.OCTOBER, 20).getTime(),
                Interval.MONTHLY);
        return historicYearMap;
    }

    @ModelAttribute("stockMapForYahoo")
    public strictfp Map<Integer,StocksHistoric> stocksMapaYahoo(){
        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
        Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
                        "YHOO", null),
                new java.util.GregorianCalendar(
                        2016, Calendar.JANUARY, 1).getTime(),
                new java.util.GregorianCalendar(
                        2016, Calendar.OCTOBER, 20).getTime(),
                Interval.MONTHLY);
        return historicYearMap;
    }

    @ModelAttribute("stockMapForMSFT")
    public strictfp Map<Integer,StocksHistoric> stocksMapaMSFT(){
        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
        Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
                        "MSFT", null),
                new java.util.GregorianCalendar(
                        2016, Calendar.JANUARY, 1).getTime(),
                new java.util.GregorianCalendar(
                        2016, Calendar.OCTOBER, 20).getTime(),
                Interval.MONTHLY);
        return historicYearMap;
    }

    @ModelAttribute("stockMapForIntel")
    public strictfp Map<Integer,StocksHistoric> stocksMapaIntel(){
        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
        Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
                        "INTC", null),
                new java.util.GregorianCalendar(
                        2016, Calendar.JANUARY, 1).getTime(),
                new java.util.GregorianCalendar(
                        2016, Calendar.OCTOBER, 20).getTime(),
                Interval.MONTHLY);
        return historicYearMap;
    }

    @ModelAttribute("stockMapForAmazon")
    public strictfp Map<Integer,StocksHistoric> stocksMapaAmazon(){
        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
        Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
                        "AMZN", null),
                new java.util.GregorianCalendar(
                        2016, Calendar.JANUARY, 1).getTime(),
                new java.util.GregorianCalendar(
                        2016, Calendar.OCTOBER, 20).getTime(),
                Interval.MONTHLY);
        return historicYearMap;
    }

    @ModelAttribute("stockMapForGoogle")
    public strictfp Map<Integer,StocksHistoric> stockMapForGoogle(){
        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
        Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
                        "GOOG", null),
                new java.util.GregorianCalendar(
                        2016, Calendar.JANUARY, 1).getTime(),
                new java.util.GregorianCalendar(
                        2016, Calendar.OCTOBER, 20).getTime(),
                Interval.MONTHLY);
        return historicYearMap;
    }

    @ModelAttribute("stockMapForOracle")
    public strictfp Map<Integer,StocksHistoric> stockMapForOracle(){
        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
        Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
                        "ORCL", null),
                new java.util.GregorianCalendar(
                        2016, Calendar.JANUARY, 1).getTime(),
                new java.util.GregorianCalendar(
                        2016, Calendar.OCTOBER, 20).getTime(),
                Interval.MONTHLY);
        return historicYearMap;
    }

    @ModelAttribute("stockMapForDELL")
    public strictfp Map<Integer,StocksHistoric> stockMapForDEll(){
        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
        Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
                        "DVMT", null),
                new java.util.GregorianCalendar(
                        2016, Calendar.JANUARY, 1).getTime(),
                new java.util.GregorianCalendar(
                        2016, Calendar.OCTOBER, 20).getTime(),
                Interval.MONTHLY);
        return historicYearMap;
    }

    @ModelAttribute("stockMapForHP")
    public strictfp Map<Integer,StocksHistoric> stockMapForHP(){
        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
        Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
                        "HPQ", null),
                new java.util.GregorianCalendar(
                        2016, Calendar.JANUARY, 1).getTime(),
                new java.util.GregorianCalendar(
                        2016, Calendar.OCTOBER, 20).getTime(),
                Interval.MONTHLY);
        return historicYearMap;
    }

    @ModelAttribute("stockMapForIBM")
    public strictfp Map<Integer,StocksHistoric> stockMapForIBM(){
        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
        Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
                        "IBM", null),
                new java.util.GregorianCalendar(
                        2016, Calendar.JANUARY, 1).getTime(),
                new java.util.GregorianCalendar(
                        2016, Calendar.OCTOBER, 20).getTime(),
                Interval.MONTHLY);
        return historicYearMap;
    }

    @ModelAttribute("stockMapForCiti")
    public strictfp Map<Integer,StocksHistoric> stockMapForCitiGroup(){
        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
        Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
                        "C", null),
                new java.util.GregorianCalendar(
                        2016, Calendar.JANUARY, 1).getTime(),
                new java.util.GregorianCalendar(
                        2016, Calendar.OCTOBER, 20).getTime(),
                Interval.MONTHLY);
        return historicYearMap;
    }

    @ExceptionHandler({Exception.class})
    public ModelAndView getGeneralException(Exception ex) {
        return new ModelAndView("error", "error", ex.getMessage());
    }

    @ExceptionHandler({IOException.class})
    public ModelAndView getIOEcxeption(IOException ex) {
        return new ModelAndView("error", "error", ex.getMessage());
    }

    @ExceptionHandler({ParseException.class})
    public ModelAndView getParsingException(ParseException ex) {
        return new ModelAndView("error", "error", ex.getMessage());
    }

    @ExceptionHandler({MalformedURLException.class})
    public ModelAndView getMalFormedURL(MalformedURLException ex) {
        return new ModelAndView("error", "error", ex.getStackTrace());
    }
}
