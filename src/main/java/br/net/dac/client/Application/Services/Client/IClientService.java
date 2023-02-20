package br.net.dac.client.Application.Services.Client;

import br.net.dac.client.Application.Services.Client.Events.CreateClientEvent;
import br.net.dac.client.Application.Services.Client.Events.UpdateClientEvent;
import br.net.dac.client.Application.Services.Client.Result.ClientResult;
import br.net.dac.client.Domain.Entities.Client;

import java.util.List;

public interface IClientService {
   void createClient (CreateClientEvent event);
   void updateClient (UpdateClientEvent event);
   List<ClientResult> getAllClients();

   ClientResult findOneByCpf(String cpf);
   ClientResult findOneAdressByCpf(String cpf);
}
