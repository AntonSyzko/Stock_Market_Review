package com.antonsyzko.stockmarketreview.configuration;

/**
 * Created by Admin on 19.09.2016.
 * @author Anton Syzko
 */
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAutoConfiguration
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**") .addResourceLocations("/resources/");
        registry.addResourceHandler("/static/**") .addResourceLocations("/static/");
        registry.addResourceHandler("/css/**") .addResourceLocations("/css/");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("mainstocksview");
        registry.addViewController("/").setViewName("forward:/mainstocksview.html");
        registry.addViewController("/error").setViewName("error");
    }
    @Bean
    public DateFormatter dateFormatter() {
        return new DateFormatter();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(dateFormatter());
    }
}