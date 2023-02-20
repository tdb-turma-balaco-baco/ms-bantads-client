package br.net.dac.client.Infrastructure.Services.Messaging.Configuration;

import br.net.dac.client.Application.Services.Client.Events.CreateClientEvent;
import br.net.dac.client.Application.Services.Client.Events.UpdateClientEvent;
import br.net.dac.client.Domain.Events.ClientCreatedEvent;
import br.net.dac.client.Domain.Events.ClientUpdated;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

import java.util.Map;
import java.util.HashMap;
@Configuration
public class RabbitConfig {
    @Value("${client.queue}")
    private String clientQueue;

    @Value("${client-response.queue}")
    private String clientResponseQueue;

    @Bean
    public Queue clientQueue() {
        return new Queue(clientQueue, true);
    }

    @Bean
    public Queue clientResponseQueue() {
        return new Queue(clientResponseQueue, true);
    }

    @Bean
    public MessageConverter messageConverter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        converter.setClassMapper(classMapper());
        return converter;
    }

    @Bean
    public DefaultClassMapper classMapper() {
        DefaultClassMapper classMapper = new DefaultClassMapper();
        classMapper.setIdClassMapping(customClassMapping());
        classMapper.setTrustedPackages("*");
        return classMapper;
    }

    public Map<String, Class<?>> customClassMapping(){
        Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("CreateClientEvent", CreateClientEvent.class);
        idClassMapping.put("UpdateClientEvent", UpdateClientEvent.class);


        idClassMapping.put("ClientCreatedEvent", ClientCreatedEvent.class);
        idClassMapping.put("ClientUpdated", ClientUpdated.class);

        return idClassMapping;
    }


    public AmqpTemplate template(ConnectionFactory connection) {
        RabbitTemplate template = new RabbitTemplate(connection);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
