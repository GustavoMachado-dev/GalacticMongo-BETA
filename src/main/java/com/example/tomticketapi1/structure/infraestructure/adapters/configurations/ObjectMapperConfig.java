package com.example.tomticketapi1.structure.infraestructure.adapters.configurations;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * A classe ObjectMapperConfig é responsável pela configuração do ObjectMapper do Jackson,
 * que é utilizado para serializar e desserializar objetos JSON no aplicativo.
 */
@Configuration
public class ObjectMapperConfig {

    /**
     * Cria um bean do tipo ObjectMapper.
     *
     * @param builder O construtor para o ObjectMapper.
     * @return Uma instância de ObjectMapper configurada.
     */
    @Bean
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        // Configura o formato da data
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        objectMapper.setDateFormat(dateFormat);

        return objectMapper;
    }
}
