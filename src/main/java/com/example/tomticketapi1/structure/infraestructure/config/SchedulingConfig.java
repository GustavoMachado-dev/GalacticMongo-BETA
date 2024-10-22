package com.example.tomticketapi1.structure.infraestructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * A classe SchedulingConfig habilita o suporte para agendamento
 * de tarefas na aplicação. Com essa configuração, é possível
 * utilizar anotações como @Scheduled para executar métodos
 * em intervalos específicos.
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {
}