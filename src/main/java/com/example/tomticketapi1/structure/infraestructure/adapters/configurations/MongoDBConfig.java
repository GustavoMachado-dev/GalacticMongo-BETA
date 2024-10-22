package com.example.tomticketapi1.structure.infraestructure.adapters.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

/**
 * A classe MongoDBConfig é responsável pela configuração do MongoDB no aplicativo.
 * Ela define um bean do tipo MongoTemplate, que é utilizado para interagir com o banco de dados MongoDB.
 */
@Configuration
public class MongoDBConfig {

    /**
     * Cria um bean do tipo MongoTemplate.
     *
     * @param mongoDatabaseFactory A fábrica de banco de dados MongoDB.
     * @param converter O conversor para mapeamento de documentos MongoDB.
     * @return Uma instância de MongoTemplate configurada.
     */
    @Bean
    public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDatabaseFactory, MappingMongoConverter converter) {
        // Remove _class
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return new MongoTemplate(mongoDatabaseFactory, converter);
    }
}
