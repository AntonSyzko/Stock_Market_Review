package com.antonsyzko.stockmarketreview.controller;//package com.antonsyzko.yahoofifnance.controller;
//
//import com.antonsyzko.yahoofinance.model.*;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.text.ParseException;
//import java.util.Calendar;
//import java.util.Map;
//
///**
// * Created by Admin on 26.10.2016.
//to include separate
// */
//@Controller
//@RequestMapping("/")
//public class SingleStocksController {
//
//    Logger logger = LoggerFactory.getLogger(SingleStocksController.class);
//
//
//    @RequestMapping(value="/eachsinglestock",method= RequestMethod.GET)
//    public String eachsinglestock(Model model) {
//        return "eachsinglestock";
//    }
//
//
//
//
//
//    @RequestMapping(value="/intelvsmicrosoft",method= RequestMethod.GET)
//    public String intelvsmicrosoft(Model model) {
//        return "intelvsmicrosoft";
//    }
//
//
//
//
//    @ModelAttribute("stockMapForFB")
//    public strictfp Map<Integer,StocksHistoric> stocksMapaFB(){
//        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
//        java.util.Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
//                        "FB", null),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.JANUARY, 1).getTime(),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.OCTOBER,20 ).getTime(),
//                Interval.MONTHLY);
//
//        return historicYearMap;
//    }
//
//
//    @ModelAttribute("stockMapForAAPL")
//    public strictfp Map<Integer,StocksHistoric> stocksMapaApple(){
//        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
//        java.util.Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
//                        "AAPL", null),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.JANUARY, 1).getTime(),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.OCTOBER, 20).getTime(),
//                Interval.MONTHLY);
//        return historicYearMap;
//    }
//
//
//    @ModelAttribute("stockMapForYahoo")
//    public strictfp Map<Integer,StocksHistoric> stocksMapaYahoo(){
//        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
//        java.util.Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
//                        "YHOO", null),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.JANUARY, 1).getTime(),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.OCTOBER, 20).getTime(),
//                Interval.MONTHLY);
//        return historicYearMap;
//    }
//
//    @ModelAttribute("stockMapForMSFT")
//    public strictfp Map<Integer,StocksHistoric> stocksMapaMSFT(){
//        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
//        java.util.Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
//                        "MSFT", null),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.JANUARY, 1).getTime(),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.OCTOBER, 20).getTime(),
//                Interval.MONTHLY);
//        return historicYearMap;
//    }
//
//    @ModelAttribute("stockMapForIntel")
//    public strictfp Map<Integer,StocksHistoric> stocksMapaIntel(){
//        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
//        java.util.Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
//                        "INTC", null),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.JANUARY, 1).getTime(),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.OCTOBER, 20).getTime(),
//                Interval.MONTHLY);
//        return historicYearMap;
//    }
//
//
//
//
//    @ModelAttribute("stockMapForAmazon")
//    public strictfp Map<Integer,StocksHistoric> stocksMapaAmazon(){
//        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
//        java.util.Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
//                        "AMZN", null),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.JANUARY, 1).getTime(),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.OCTOBER, 20).getTime(),
//                Interval.MONTHLY);
//        return historicYearMap;
//    }
//
//
//    @ModelAttribute("stockMapForGoogle")
//    public strictfp Map<Integer,StocksHistoric> stockMapForGoogle(){
//        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
//        java.util.Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
//                        "GOOG", null),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.JANUARY, 1).getTime(),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.OCTOBER, 20).getTime(),
//                Interval.MONTHLY);
//        return historicYearMap;
//    }
//
//    @ModelAttribute("stockMapForOracle")
//    public strictfp Map<Integer,StocksHistoric> stockMapForOracle(){
//        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
//        java.util.Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
//                        "ORCL", null),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.JANUARY, 1).getTime(),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.OCTOBER, 20).getTime(),
//                Interval.MONTHLY);
//        return historicYearMap;
//    }
//
//    @ModelAttribute("stockMapForDELL")
//    public strictfp Map<Integer,StocksHistoric> stockMapForDEll(){
//        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
//        java.util.Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
//                        "DVMT", null),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.JANUARY, 1).getTime(),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.OCTOBER, 20).getTime(),
//                Interval.MONTHLY);
//        return historicYearMap;
//    }
//    @ModelAttribute("stockMapForHP")
//    public strictfp Map<Integer,StocksHistoric> stockMapForHP(){
//        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
//        java.util.Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
//                        "HPQ", null),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.JANUARY, 1).getTime(),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.OCTOBER, 20).getTime(),
//                Interval.MONTHLY);
//        return historicYearMap;
//    }
//    @ModelAttribute("stockMapForIBM")
//    public strictfp Map<Integer,StocksHistoric> stockMapForIBM(){
//        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
//        java.util.Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
//                        "IBM", null),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.JANUARY, 1).getTime(),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.OCTOBER, 20).getTime(),
//                Interval.MONTHLY);
//        return historicYearMap;
//    }
//    @ModelAttribute("stockMapForCiti")
//    public strictfp Map<Integer,StocksHistoric> stockMapForCitiGroup(){
//        GetStocksHistoricApi getstoks = new GetStocksHistoricApi();
//        java.util.Map<Integer,StocksHistoric>  historicYearMap = getstoks.getHistoricalMap(new Symbol(
//                        "C", null),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.JANUARY, 1).getTime(),
//                new java.util.GregorianCalendar(
//                        2016, Calendar.OCTOBER, 20).getTime(),
//                Interval.MONTHLY);
//        return historicYearMap;
//    }
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
//}
