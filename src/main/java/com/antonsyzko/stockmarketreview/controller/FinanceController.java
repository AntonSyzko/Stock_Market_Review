package com.antonsyzko.stockmarketreview.controller;//package com.antonsyzko.yahoofifnance.controller;
//
//import com.antonsyzko.yahoofinance.model.*;

//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import yahoofinance.Stock;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import yahoofinance.YahooFinance;
//import yahoofinance.quotes.fx.FxQuote;
//import yahoofinance.quotes.fx.FxSymbols;
////import yahoofinance.Stock;
////import yahoofinance.YahooFinance;
//
//
//import java.io.IOException;
//
//import java.math.BigDecimal;
//import java.net.MalformedURLException;
//import java.text.ParseException;
//import java.util.*;
//
//
///**
// * Created by Admin on 26.09.2016.
//* @author Anton Syzko

//to incl
// */
//
//@Controller
//@RequestMapping("/")
//public strictfp class FinanceController {
//
//
//    Logger logger = LoggerFactory.getLogger(FinanceController.class);
//
////    @RequestMapping("/")
////    public String index() {
////        return "fbstocks";
////    }
////    Stock stock = null;
////
////    @RequestMapping(value="/charts",method= RequestMethod.GET)
////    public String stockCharts(Model model) {
////        return "charts";
////    }
////
////    @RequestMapping(value="/amchart",method= RequestMethod.GET)
////    public String stockAmCharts(Model model) {
////        return "amchart";
////    }
////
////    @RequestMapping(value="/canvaslive",method= RequestMethod.GET)
////    public String canvasLive(Model model) {
////        return "canvaslive";
////    }
////
////    @RequestMapping(value="/high",method= RequestMethod.GET)
////    public String high(Model model) {
////        return "high";
////    }
////
////    @RequestMapping(value="/liverandomhigh",method= RequestMethod.GET)
////    public String liverandomhigh(Model model) {
////        return "liverandomhigh";
////    }
//
//
//
//
//
//
////
////
////    @ModelAttribute("fbask")
////    public double fbAsk(){
////        double res = 0;
////        try {
////             stock = YahooFinance.get("FB");
////            res = stock.getQuote().getAsk().doubleValue();
////            System.out.println(res+"**********************************************************");
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return res;
////    }
////
////    @ModelAttribute("fbbid")
////    public double fbBid(){
////        double res = 0;
////        try {
////             stock = YahooFinance.get("FB");
////            res = stock.getQuote().getBid().doubleValue();
////            System.out.println(res+"********************************************************************");
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return res;
////    }
////
////
////
//
//
//
//
//
//
//
//
//
//
//
//
//
////
////
////    Stock amznStock  = StockFetcher.getStock("AMZN");
////
////
//    @RequestMapping(value="/",method=RequestMethod.GET)
//    public String fsStocks(Model model) {
//        model.addAttribute("oracleStock", StockFetcher.getStock("ORCL"));
//        model.addAttribute("googStock", StockFetcher.getStock("GOOG"));
//        model.addAttribute("yhooStock", StockFetcher.getStock("YHOO"));
//        model.addAttribute("msftStock", StockFetcher.getStock("MSFT"));
//        model.addAttribute("intcStock", StockFetcher.getStock("INTC"));
//        model.addAttribute("appleStock", StockFetcher.getStock("AAPL"));
//        model.addAttribute("fbStock", StockFetcher.getStock("FB"));
//        model.addAttribute("amznStock", StockFetcher.getStock("AMZN"));
//        model.addAttribute("citigroupStock", StockFetcher.getStock("C"));
//        model.addAttribute("hpqStock", StockFetcher.getStock("HPQ"));
//        model.addAttribute("dellStock", StockFetcher.getStock("DVMT"));
//        model.addAttribute("ibmStock", StockFetcher.getStock("IBM"));
//
//        return "fbstocks";
//
//    }
//
//
//
////
////        Stock facebook = StockFetcher.getStock("FB");
////    Stock aapl = StockFetcher.getStock("AAPL");
////    Stock googl = StockFetcher.getStock("GOOG");
////
////    @ModelAttribute("aapl")
////    public double[] aaplAll(){
////
////        double [] result= new double[7];
////        result[0]=aapl.getOpen();
////        result[1]=aapl.getDayhigh();
////        result[2]=aapl.getDaylow();
////        result[3]=aapl.getPreviousClose();
////        result[4]=aapl.getPrice();
////        result[5]=aapl.getWeek52high();
////        result[6]=aapl.getWeek52low();
////
////        return result;
////    }
//
//
////
////@ModelAttribute("googlevolume")
////public List<Historic> historicGoogle(){
////    GetStocksApi getstoks = new GetStocksApi();
////    java.util.List<Historic>  historic = getstoks.getHistorical(new Symbol(
////                    "GOOG", null),
////            new java.util.GregorianCalendar(
////                    2016, java.util.Calendar.JANUARY, 01).getTime(),
////            new java.util.GregorianCalendar(
////                    2016, Calendar.FEBRUARY, 01).getTime(),
////            Interval.WEEKLY);
////
////    System.out.println(historic.iterator().next().getVolume());
////    double res = historic.listIterator().next().getOpen();
////    return historic ;
////
////}
//
//
//
//
////    @ModelAttribute("fbyearlow")
////    public strictfp double fbYearLow(){
////
////        double  result= facebook.getWeek52low();
////        System.out.println("year low " + result);
////        return result;
////    }
////    @ModelAttribute("fbyearhigh")
////    public strictfp double fbYearHigh(){
////
////        double  result= facebook.getWeek52high();
////        System.out.println("year high " + result);
////
////        return result;
////    }
////    @ModelAttribute("fbopen")
////    public strictfp double fbOpen(){
////
////        double  result= facebook.getWeek52low();
////        System.out.println("opeb " + result);
////
////        return result;
////    }
////    @ModelAttribute("fbdaylow")
////    public strictfp double fbdaylow(){
////
////        double  result= facebook.getDaylow();
////        System.out.println("day low " + result);
////
////        return result;
////    }
////    @ModelAttribute("fbdayhigh")
////    public  strictfp double fbdayhigh(){
////
////        double  result= facebook.getDayhigh();
////        System.out.println("day high " + result);
////
////        return result;
////    }
////    @ModelAttribute("fbprewclose")
////    public strictfp double fbprewclose(){
////
////        double  result= facebook.getPreviousClose();
////        System.out.println("prew close " + result);
////
////        return result;
////    }
////    @ModelAttribute("fbexchange")
////    public strictfp double fbExchsnge(){
////
////        double  result= facebook.getPrice();
////        System.out.println("exchange " + result);
////
////        return result;
////    }
////
////
////
////
////
////    @ModelAttribute("oopsa")
////    public strictfp double [] oopsa(){
////        double [] res = new double[20];
////        GetStocksApi getstoks = new GetStocksApi();
////        java.util.List<Historic>  historic = getstoks.getHistorical(new Symbol(
////                        "GOOG", null),
////                new java.util.GregorianCalendar(
////                        2016, java.util.Calendar.JANUARY, 01).getTime(),
////                new java.util.GregorianCalendar(
////                        2016, Calendar.FEBRUARY, 01).getTime(),
////                Interval.WEEKLY);
////
////        System.out.println(historic.iterator().next().getVolume());
////        // double res = historic.iterator().next().getVolume();
////      res[0]= historic.listIterator(0).next().getOpen();
////        res[1]= historic.listIterator(0).next().getHigh();
////        res[2] = historic.listIterator(0).next().getLow();
////        res[3] = historic.listIterator(0).next().getClose();
////
////        res[4]= historic.listIterator(1).next().getOpen();
////        res[5]= historic.listIterator(1).next().getHigh();
////        res[6] = historic.listIterator(1).next().getLow();
////        res[7] = historic.listIterator(1).next().getClose();
////
////        res[8]= historic.listIterator(2).next().getOpen();
////        res[9]= historic.listIterator(2).next().getHigh();
////        res[10] = historic.listIterator(2).next().getLow();
////        res[11] = historic.listIterator(2).next().getClose();
////
////        res[12]= historic.listIterator(3).next().getOpen();
////        res[13]= historic.listIterator(3).next().getHigh();
////        res[14] = historic.listIterator(3).next().getLow();
////        res[15] = historic.listIterator(3).next().getClose();
////
////        res[16]= historic.listIterator(4).next().getOpen();
////        res[17]= historic.listIterator(4).next().getHigh();
////        res[18] = historic.listIterator(4).next().getLow();
////        res[19] = historic.listIterator(4).next().getClose();
////
////
////        return res ;
////
////    }
//
//
////
////    @RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
////    public @ResponseBody
////    String  getTime() {
////
////        Random rand = new Random();
////        float r = rand.nextFloat() * 100;
////        String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
////        System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
////        return result;
////    }
//
//
//
//    @RequestMapping(value = "/currencytickUSDEUR", method = RequestMethod.GET)
//    @ResponseBody
//   final public   String getTick() {
//        double tickPriceGBPUSD = 0;
//        double tickPriceGBPEUR = 0;
//        double tickPriceGBPJPY = 0;
//        double tickPriceGBPCHF = 0;
//        double tickPriceGBPNZD = 0;
//        double tickPriceGBPCAD = 0;
//        double tickPriceGBPAUD = 0;
//
//        double tickPriceEURGBP = 0;
//        double tickPriceEURUSD = 0;
//        double tickPriceEURCHF = 0;
//        double tickPriceEURJPY = 0;
//        double tickPriceEURCAD = 0;
//        double tickPriceEURAUD = 0;
//        double tickPriceEURNZD = 0;
//
//        double tickPriceUSDGBP = 0;
//        double tickPriceUSDEUR = 0;
//        double tickPriceUSDJPY = 0;
//        double tickPriceUSDCHF = 0;
//        double tickPriceUSDCAD = 0;
//        double tickPriceUSDAUD = 0;
//        double tickPriceUSDNZD = 0;
//
//        FxQuote GBPUSD = null;
//        FxQuote GBPEUR = null;
//        FxQuote GBPJPY  = null;
//        FxQuote GBPCHF = null;
//        FxQuote GBPNZD = null;
//        FxQuote GBPCAD = null;
//        FxQuote GBPAUD = null;
//
//        FxQuote EURGBP = null;
//        FxQuote EURUSD = null;
//        FxQuote EURCHF = null;
//        FxQuote EURCAD= null;
//        FxQuote EURJPY = null;
//        FxQuote EURAUD = null;
//        FxQuote EURNZD = null;
//
//        FxQuote USDGBP = null;
//        FxQuote USDEUR = null;
//        FxQuote USDJPY = null;
//        FxQuote USDCHF= null;
//        FxQuote USDCAD = null;
//        FxQuote USDAUD = null;
//        FxQuote USDNZD = null;
//
//        Stock Gold = null;
//        Stock GoldFutures = null;
//        Stock Silver = null;
//        Stock SilverFutures = null;
//        Stock BrentOilFutures = null;
//        Stock RBOBGasolineFutures = null;
//        Stock LightSweetCrudeOilFutures = null;
//        Stock HenryHubNaturalGasFutures = null;
//
//
//
//
//        BigDecimal priceGold = new BigDecimal(0);
//        BigDecimal priceGoldFutures = new BigDecimal(0);
//        BigDecimal priceSilver = new BigDecimal(0);
//        BigDecimal priceSilverFutures = new BigDecimal(0);
//        BigDecimal priceBrentOilFutures = new BigDecimal(0);
//        BigDecimal priceOIL = new BigDecimal(0);
//        BigDecimal priceRBOBGasolineFutures = new BigDecimal(0);
//        BigDecimal priceHenryHubNaturalGasFutures = new BigDecimal(0);
//
//
//
//        try {
//            GBPUSD = YahooFinance.getFx(FxSymbols.GBPUSD);
//            GBPEUR = YahooFinance.getFx(FxSymbols.GBPEUR);
//            GBPJPY = YahooFinance.getFx(FxSymbols.GBPJPY);
//            GBPCHF = YahooFinance.getFx(FxSymbols.GBPCHF);
//            GBPNZD = YahooFinance.getFx(FxSymbols.GBPNZD);
//            GBPCAD = YahooFinance.getFx(FxSymbols.GBPCAD);
//            GBPAUD = YahooFinance.getFx(FxSymbols.GBPAUD);
//
//             EURGBP = YahooFinance.getFx(FxSymbols.EURGBP);
//             EURUSD = YahooFinance.getFx(FxSymbols.EURUSD);
//             EURCHF = YahooFinance.getFx(FxSymbols.EURCHF);
//             EURCAD= YahooFinance.getFx(FxSymbols.EURCAD);
//             EURJPY = YahooFinance.getFx(FxSymbols.EURJPY);
//             EURAUD = YahooFinance.getFx(FxSymbols.EURAUD);
//             EURNZD = YahooFinance.getFx(FxSymbols.EURNZD);
//
//             USDGBP = YahooFinance.getFx(FxSymbols.USDGBP);
//             USDEUR = YahooFinance.getFx(FxSymbols.USDEUR);
//             USDJPY = YahooFinance.getFx(FxSymbols.USDJPY);
//             USDCHF= YahooFinance.getFx(FxSymbols.USDCHF);
//             USDCAD = YahooFinance.getFx(FxSymbols.USDCAD);
//             USDAUD = YahooFinance.getFx(FxSymbols.USDAUD);
//             USDNZD = YahooFinance.getFx(FxSymbols.USDNZD);
//
//            Gold = YahooFinance.get("ZG=F");;
//            GoldFutures = YahooFinance.get("GC=F");;
//            Silver = YahooFinance.get("ZI=F");;
//            SilverFutures = YahooFinance.get("SI=F");;
//             BrentOilFutures = YahooFinance.get("BZ=F");;
//             RBOBGasolineFutures = YahooFinance.get("RB=F");;
//            LightSweetCrudeOilFutures = YahooFinance.get("CL=F");;
//             HenryHubNaturalGasFutures = YahooFinance.get("NG=F");;
//
//
//             priceGold = Gold.getQuote(true).getPrice();
//          priceGoldFutures = GoldFutures.getQuote(true).getPrice();
//             priceSilver = Silver.getQuote(true).getPrice();
//           priceSilverFutures = SilverFutures.getQuote(true).getPrice();
//             priceBrentOilFutures = BrentOilFutures.getQuote(true).getPrice();
//             priceOIL = LightSweetCrudeOilFutures.getQuote(true).getPrice();
//             priceRBOBGasolineFutures = RBOBGasolineFutures.getQuote(true).getPrice();
//             priceHenryHubNaturalGasFutures = HenryHubNaturalGasFutures.getQuote(true).getPrice();
//
//
//
//
//            tickPriceGBPUSD = GBPUSD.getPrice(true).doubleValue();
//            tickPriceGBPEUR = GBPEUR.getPrice(true).doubleValue();
//            tickPriceGBPJPY = GBPJPY.getPrice(true).doubleValue();
//            tickPriceGBPCHF = GBPCHF.getPrice(true).doubleValue();
//            tickPriceGBPNZD = GBPNZD.getPrice(true).doubleValue();
//            tickPriceGBPCAD = GBPCAD.getPrice(true).doubleValue();
//            tickPriceGBPAUD = GBPAUD.getPrice(true).doubleValue();
//
//
//
//
//            tickPriceEURGBP = EURGBP.getPrice(true).doubleValue();
//            tickPriceEURUSD = EURUSD.getPrice(true).doubleValue();
//            tickPriceEURCHF = EURCHF.getPrice(true).doubleValue();
//            tickPriceEURJPY = EURJPY.getPrice(true).doubleValue();
//            tickPriceEURCAD = EURCAD.getPrice(true).doubleValue();
//            tickPriceEURAUD = EURAUD.getPrice(true).doubleValue();
//            tickPriceEURNZD = EURNZD.getPrice(true).doubleValue();
//
//
//
//
//            tickPriceUSDGBP = USDGBP.getPrice(true).doubleValue();
//            tickPriceUSDEUR = USDEUR.getPrice(true).doubleValue();
//            tickPriceUSDJPY = USDJPY.getPrice(true).doubleValue();
//            tickPriceUSDCHF = USDCHF.getPrice(true).doubleValue();
//            tickPriceUSDCAD = USDCAD.getPrice(true).doubleValue();
//            tickPriceUSDAUD = USDAUD.getPrice(true).doubleValue();
//            tickPriceUSDNZD = USDNZD.getPrice(true).doubleValue();
//
//
//
//
//        }catch (IOException e){
//            e.getMessage();
//        }
//
//        String result = "<br>  <b style=\"color:green\"> &nbsp;&nbsp;&nbsp;GBP / USD&nbsp;&nbsp;</b>    <b>" + tickPriceGBPUSD + "</b>"+"  <b style=\"color:blue\">&nbsp; &nbsp;&nbsp;GBP / EUR&nbsp;&nbsp;</b>  <b>  "+ tickPriceGBPEUR + "</b> "+
//                "  <b style=\"color:darkgreen\">&nbsp; &nbsp;&nbsp;GBP / JPY&nbsp;&nbsp;</b>  <b>  "+ tickPriceGBPJPY + "</b> " +" <b style=\"color:cornflowerblue\"> &nbsp;&nbsp;&nbsp;GBP / CHF &nbsp;&nbsp; </b>  <b>  "+ tickPriceGBPCHF + "</b> "+
//        "  <b style=\"color:forestgreen\">&nbsp;&nbsp;&nbsp; GBP / CAD &nbsp;&nbsp;</b>  <b>  "+ tickPriceGBPCAD + "</b> " +"  <b style=\"color:deepskyblue\">&nbsp;&nbsp;&nbsp; GBP / AUD &nbsp;&nbsp;</b>  <b>  "+ tickPriceGBPAUD + "</b> "+
//        "  <b style=\"color:forestgreen\">&nbsp;&nbsp;&nbsp; GBP / NZD &nbsp;&nbsp;</b>  <b>  "+ tickPriceGBPNZD + "</b> "+
//
//                "<br>  <b style=\"color:green\">&nbsp;&nbsp; &nbsp;EUR / GBP&nbsp;&nbsp;</b>    <b>" + tickPriceEURGBP + "</b>"+"  <b style=\"color:blue\"> &nbsp;&nbsp;&nbsp;EUR / USD&nbsp;&nbsp;</b>  <b>  "+ tickPriceEURUSD + "</b> "+
//               " <b style=\"color:darkgreen\">&nbsp; &nbsp;&nbsp;EUR / JPY &nbsp;&nbsp; </b>  <b>  "+ tickPriceEURJPY + "</b> "+ "  <b style=\"color:cornflowerblue\">&nbsp; &nbsp;&nbsp;EUR / CHF&nbsp;&nbsp;</b>  <b>  "+ tickPriceEURCHF + "</b> " +
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
//                + " &nbsp;&nbsp; <b style=\"color:crimson\">" + new Date().toString() + "</b>";
//        //System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
//        return result;
//    }
//
////
////    @RequestMapping(value = "/arraycheck", method = RequestMethod.GET)
////    public @ResponseBody
////    String  getArray() {
////
////          String result = "fgd";
////        //System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
////        return result;
////    }
//
//    @ModelAttribute("eurusdtik")
//    public double eurousdTik(){
//
//        double tickPriceEURUSD = 0;
//        FxQuote eurusd = null;
//        try {
//            eurusd = YahooFinance.getFx(FxSymbols.USDEUR);
//            tickPriceEURUSD =  eurusd.getPrice(true).doubleValue();
//            System.out.println("***********************"+tickPriceEURUSD);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return tickPriceEURUSD;
//    }
//
//    @ModelAttribute("eurgbptik")
//    public strictfp double eurogbpTik(){
//
//        double tickPriceEURGBP = 0;
//        FxQuote eurgbp = null;
//        try {
//            eurgbp = YahooFinance.getFx(FxSymbols.EURGBP);
//            tickPriceEURGBP =  eurgbp.getPrice(true).doubleValue();
//            System.out.println("***********************"+tickPriceEURGBP);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return tickPriceEURGBP;
//    }
//
//    @ModelAttribute("usdgbptik")
//    public strictfp double usdgbpTik(){
//
//         double tickPriceUSDGBP = 0;
//        FxQuote usdgbp = null;
//        try {
//            usdgbp = YahooFinance.getFx(FxSymbols.USDGBP);
//            tickPriceUSDGBP =  usdgbp.getPrice(true).doubleValue();
//            System.out.println("***********************"+tickPriceUSDGBP);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return tickPriceUSDGBP;
//    }
//
//
//
//
//
//
////    @ModelAttribute("googdoubles")
////    public double[] aaplDbls(){
////
////        double [] result= new double[13];
////        result[0]=googl.getPrice();
////        result[1]=(double)googl.getVolume();
////        result[2]=googl.getPe();
////        result[3]=googl.getEps();
////        result[4]=googl.getWeek52high();
////        result[5]=googl.getWeek52low();
////        result[6]=googl.getDaylow();
////        result[7]=googl.getDayhigh();
////        result[8]=googl.getMovingav50day();
////        result[9]=googl.getMarketcap();
////        result[10]=googl.getShortRatio();
////        result[11]=googl.getPreviousClose();
////        result[12]=googl.getOpen();
////
////
////
////
////        return result;
////    }
////    @ModelAttribute("googstrings")
////    public String[] aaplStrs(){
////        String[] res = new String [4];
////
////        res[0]=googl.getSymbol();
////        res[1]=googl.getName();
////        res[2]=googl.getCurrency();
////        res[3]=googl.getExchange();
////
////
////        return res;
////    }
//
//
//
//    @ExceptionHandler({Exception.class})
//    public ModelAndView getGeneralException(Exception ex) {
//        return new ModelAndView("error", "error", ex.getMessage());
//    }
//
//    @ExceptionHandler({Exception.class})
//    public ModelAndView getIOEcxeption(IOException ex) {
//        return new ModelAndView("error", "error", ex.getMessage());
//    }
//
//    @ExceptionHandler({Exception.class})
//    public ModelAndView getParsingException(ParseException ex) {
//        return new ModelAndView("error", "error", ex.getMessage());
//    }
//
//    @ExceptionHandler({Exception.class})
//    public ModelAndView getMalFormedURL(MalformedURLException ex) {
//        return new ModelAndView("error", "error", ex.getMessage());
//    }
//
//
//}
