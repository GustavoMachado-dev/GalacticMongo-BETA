package com.example.tomticketapi1;

import com.example.tomticketapi1.structure.infraestructure.config.MailConfig;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
* Acesse o Swagger: http://localhost:8080/swagger-ui/index.html
*
* */

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "TomTicket API",
        version = "2.4 - BETA",
        description = "Documentação Swagger da Tom Ticket API.",
        contact = @Contact(name = "Gustavo Machado", email = "gustavof.lopesmachado@gmail.com")
        ))
@Import(MailConfig.class)
public class TomTicketApi1Application {

    public static void main(String[] args) {
        SpringApplication.run(TomTicketApi1Application.class, args);
    }

}
