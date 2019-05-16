package com.movie.config;

import java.util.Locale;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class I18nConfig {

    @Bean(name = "localeResolver")
    public MyLocaleResolver myLocaleResolver(){
    	
        MyLocaleResolver myLocaleResolver = new MyLocaleResolver();
        myLocaleResolver.setDefaultLocale(Locale.ENGLISH);
        return myLocaleResolver;
    }
}
