package com.antonsyzko.stockmarketreview;

//import com.antonsyzko.yahoofinance.configuration.SessionListener;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StockMarketReviewApplication.class);
	}

//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		super.onStartup(servletContext);
//		servletContext.addListener(new SessionListener());
//	}

}
