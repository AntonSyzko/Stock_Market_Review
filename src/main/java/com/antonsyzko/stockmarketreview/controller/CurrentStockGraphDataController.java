package com.antonsyzko.stockmarketreview.controller;//package com.antonsyzko.yahoofifnance.controller;
//
//import com.antonsyzko.yahoofinance.model.*;

//import StockFetcher;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.text.ParseException;
//
///**
// * Created by Admin on 28.10.2016.
// */
//@Controller
//@RequestMapping("/")
//public class CurrentStockGraphDataController {
//
//    Logger logger = LoggerFactory.getLogger(CurrentStockGraphDataController.class);
//
//    @RequestMapping(value="/currentStocksGraphData",method= RequestMethod.GET)
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
//        return "currentStocksGraphData";
//    }
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
//}
