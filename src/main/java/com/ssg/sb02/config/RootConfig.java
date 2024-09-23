package com.ssg.sb02.config;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration   //스프링의 설정 클래스임을 명시
public class RootConfig {
    //ModelMapper 를 스프링의 빈으로 설정
    @Bean
    public ModelMapper getMapper(){
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                    .setMatchingStrategy(MatchingStrategies.STRICT);

            return modelMapper;

    }
}
