package br.net.dac.client.Application.Abstractions;


import br.net.dac.client.Domain.Events.Common.DomainEvent;

public interface IMessageSender {
    void sendMessage(DomainEvent event);
}
