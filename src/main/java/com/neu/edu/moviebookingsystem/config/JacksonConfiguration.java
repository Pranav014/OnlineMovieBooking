package com.neu.edu.moviebookingsystem.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class JacksonConfiguration {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Time.class, new JsonDeserializer<Time>() {
            @Override
            public Time deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
                String timeString = jsonParser.getText();
                System.out.println("TIME========> " +timeString);
                try {

                    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                    Date parsedDate = dateFormat.parse(timeString);
                    return new Time(parsedDate.getTime());
                } catch (ParseException e) {
                    throw new IllegalArgumentException("Invalid time format: " + timeString);
                }
            }
        });
        objectMapper.registerModule(module);
        return objectMapper;
    }
}
