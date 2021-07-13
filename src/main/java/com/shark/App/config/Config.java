package com.shark.App.config;

import com.shark.App.converter.user.fromUser.UserToUserDtoConverter;
import com.shark.App.converter.user.fromUserDto.UserDtoToUserConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class Config {

    @Bean()
    public ConversionServiceFactoryBean conversionServiceFactoryBean() {
        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
        Set<Converter> converterSet = new HashSet<>();

        converterSet.add(new UserDtoToUserConverter());
        converterSet.add (new UserToUserDtoConverter());




        factoryBean.setConverters(converterSet);
        return factoryBean;
    }
}
