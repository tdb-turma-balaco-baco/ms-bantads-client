package br.net.dac.client.Infrastructure.Services.Messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.net.dac.client.Application.Abstractions.IMessageSender;
import br.net.dac.client.Domain.Events.Common.DomainEvent;
@Component
public class MessageSender implements IMessageSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(DomainEvent event) {
        rabbitTemplate.convertAndSend("client-response.queue", event);
    }
}
