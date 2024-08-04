package com.whms.configs;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class DateConfig {
    @Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss}")
    String dateTimePattern;
    @Bean
    public LocalDateTimeSerializer localDateTimeSerializer(){
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimePattern));
    }
    @Bean
    public LocalDateTimeDeserializer localDateTimeDeserializer(){
        return new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(dateTimePattern));
    }
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer(){
        return builder -> {
          builder.serializerByType(LocalDateTime.class, localDateTimeSerializer());
          builder.deserializerByType(LocalDateTime.class, localDateTimeDeserializer());
        };
    }
}
