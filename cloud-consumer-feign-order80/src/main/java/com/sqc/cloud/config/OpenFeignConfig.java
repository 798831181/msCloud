package com.sqc.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunqichao
 * @date 2020-03-25 17:41
 */
@Configuration
public class OpenFeignConfig {
    @Bean
    public Logger.Level getFeignLoggerLever(){
        return Logger.Level.FULL;
    }
}
