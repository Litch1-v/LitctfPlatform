package com.litchi.litchi_ctf.config;

import com.litchi.litchi_ctf.util.csrf.CSRFHandlerInterceptor;
import com.litchi.litchi_ctf.util.csrf.CSRFRequestDataValueProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

@Configuration
public class CsrfConfig implements WebMvcConfigurer {
    @Autowired
    private CSRFHandlerInterceptor csrfHandlerInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(csrfHandlerInterceptor);
    }
    @Bean(name = "requestDataValueProcessor")
    public RequestDataValueProcessor registerDataValueProcessor(){
        return new CSRFRequestDataValueProcessor();
    }


}
