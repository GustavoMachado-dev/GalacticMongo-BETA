package com.example.tomticketapi1.structure.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * A classe AppConfig é uma classe de configuração que define beans
 * utilizados na aplicação Spring. Neste caso, ela configura um
 * bean do tipo RestTemplate, que pode ser usado para realizar
 * chamadas a serviços REST.
 */
@Configuration
public class AppConfig {

    /**
     * Cria e retorna um bean do tipo RestTemplate.
     *
     * @return um novo objeto RestTemplate, que pode ser utilizado
     * para fazer requisições HTTP.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
