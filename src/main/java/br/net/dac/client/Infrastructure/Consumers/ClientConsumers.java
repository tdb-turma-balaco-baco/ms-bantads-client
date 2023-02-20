package br.net.dac.client.Infrastructure.Consumers;

import br.net.dac.client.Application.Services.Client.Events.CreateClientEvent;
import br.net.dac.client.Application.Services.Client.Events.UpdateClientEvent;
import br.net.dac.client.Application.Services.Client.IClientService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"${client.queue}"})
public class ClientConsumers {


    @Autowired
    IClientService _service;

    @RabbitHandler
    public void receiveCreate(@Payload CreateClientEvent event){
        _service.createClient(event);
    }

    @RabbitHandler
    public void receiveUpdate(@Payload UpdateClientEvent event){
        _service.updateClient(event);
    }

}
