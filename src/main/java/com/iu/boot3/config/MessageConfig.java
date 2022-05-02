package com.iu.boot3.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration //Legacy ***-context.xml
public class MessageConfig implements WebMvcConfigurer {

	@Bean // <bean class=""> 객체 생성
 	public LocaleResolver localeResolver() {
		
		// 1. Session 이용법
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.KOREAN);
		
		// 2. Cookie 이용법
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(Locale.KOREAN);
		cookieLocaleResolver.setCookieName("lang");
		
		
		return cookieLocaleResolver;   //sessionLocaleResolver; 필요한거 사용 
	}
	
	@Bean  //객체 생성을 위한 annotation
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("langs");
		//Parameter를 받아서 언어 구분
		//url?lang=en
		
		return localeChangeInterceptor;
	}
}
