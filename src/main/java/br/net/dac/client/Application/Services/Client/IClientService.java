package br.net.dac.client.Application.Services.Client;

import br.net.dac.client.Application.Services.Client.Events.CreateClientEvent;
import br.net.dac.client.Application.Services.Client.Events.UpdateClientEvent;
import br.net.dac.client.Application.Services.Client.Result.AddressClient;
import br.net.dac.client.Application.Services.Client.Result.ClientResult;

import java.util.List;

public interface IClientService {
   void createClient (CreateClientEvent event);
   void updateClient (UpdateClientEvent event);
   List<ClientResult> getAllClients();

   ClientResult findOneByCpf(String cpf);
   AddressClient findOneAdressByCpf(String cpf);
}
