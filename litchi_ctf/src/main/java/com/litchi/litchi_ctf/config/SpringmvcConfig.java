package com.litchi.litchi_ctf.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class SpringmvcConfig extends WebMvcConfigurerAdapter {
    @Override
   public void addViewControllers(ViewControllerRegistry registry) {
    }
}
