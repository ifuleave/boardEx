package org.zerock.boardex.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    //DTO->Vo, VO->DTO 변환 작업이 빈번함으로 이를 처리하기 위해 modelmapper를 스프링 빈으로 등록해서 처리
    //root-servlet.xml에 context:component로 등록
    //getMapper()메소드가 ModelMapper를 반환하도록 설계
    @Bean
    public ModelMapper getMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
