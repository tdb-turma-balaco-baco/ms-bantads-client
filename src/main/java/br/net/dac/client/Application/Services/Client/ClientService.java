package br.net.dac.client.Application.Services.Client;

import br.net.dac.client.Application.Abstractions.IMessageSender;
import br.net.dac.client.Application.Services.Client.Events.CreateClientEvent;
import br.net.dac.client.Application.Services.Client.Events.UpdateClientEvent;
import br.net.dac.client.Application.Services.Client.Result.AddressClient;
import br.net.dac.client.Application.Services.Client.Result.AddressResult;
import br.net.dac.client.Application.Services.Client.Result.ClientResult;
import br.net.dac.client.Domain.Entities.Address;
import br.net.dac.client.Domain.Entities.Client;
import br.net.dac.client.Domain.Events.ClientCreatedEvent;
import br.net.dac.client.Domain.Events.ClientUpdatedEvent;
import br.net.dac.client.Domain.Exceptions.ClientNotFoundException;
import br.net.dac.client.Infrastructure.Persistence.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService {

    @Autowired
    ClientRepository _clientRepository;

    @Autowired
    IMessageSender _messageSender;


    @Override
    public void createClient(CreateClientEvent event) {
        try {
            if (_clientRepository.findOneByCpf(event.getCpf()) == null) {
                Address address = new Address(event.getAddress().getType(), event.getAddress().getStreet(), event.getAddress().getNumber(), event.getAddress().getComplement(), event.getAddress().getCep(), event.getAddress().getCity(), event.getAddress().getState());
                Client client = new Client();
                client.setName(event.getName());
                client.setCpf(event.getCpf());
                client.setEmail(event.getEmail());
                client.setPhone(event.getPhone());
                client.setWage(event.getWage());
                client.setClientAdress(address);

                _clientRepository.saveAndFlush(client);

                ClientCreatedEvent eventDomain = new ClientCreatedEvent(event.getName(), event.getCpf(), event.getEmail(), event.getWage());
                _messageSender.sendMessage(eventDomain);
            }
        }
        catch (Exception ex) {

        }
    }

    @Override
    public void updateClient(UpdateClientEvent event) {
        Client client = _clientRepository.findOneByCpf(event.getCpf());
        
        client.getClientAdress().setType(event.getAddress().getType());
        client.getClientAdress().setCep(event.getAddress().getCep());
        client.getClientAdress().setCity(event.getAddress().getCity());
        client.getClientAdress().setComplement(event.getAddress().getComplement());
        client.getClientAdress().setNumber(event.getAddress().getNumber());
        client.getClientAdress().setState(event.getAddress().getState());
        client.getClientAdress().setStreet(event.getAddress().getStreet());
        client.setName(event.getName());
        client.setEmail(event.getEmail());
        client.setPhone(event.getPhone());
        client.setWage(event.getWage());
        
        _clientRepository.saveAndFlush(client);

        ClientUpdatedEvent eventDomain = new ClientUpdatedEvent(event.getName(), event.getCpf(), event.getEmail());
        _messageSender.sendMessage(eventDomain);

    }

    @Override
    public List<ClientResult> getAllClients() {
        List<Client> clients = _clientRepository.findAll();
        List<ClientResult> clientResults = clients.stream().map(c -> new ClientResult(c.getId(), c.getName(), c.getEmail(), c.getCpf(), c.getPhone(), c.getWage(), mapEntityToAddress(c.getClientAdress()))).collect(Collectors.toList());
        return clientResults;
    }

    @Override
    public ClientResult findOneByCpf(String cpf) {
        Client client = _clientRepository.findOneByCpf(cpf);
        if(client == null) throw new ClientNotFoundException();
        
        ClientResult clientResult = mapEntityToDTO(client);
        return clientResult;

    }
    public AddressClient findOneAdressByCpf(String cpf) {
        Client client = _clientRepository.findOneByCpf(cpf);
        if(client == null) throw new ClientNotFoundException();

        AddressClient addressClientResult = mapEntityToDTOByAdress(client);
        return addressClientResult;
    }

    private AddressClient mapEntityToDTOByAdress(Client client) {
        AddressClient result = new AddressClient();
        result.setCpf(client.getCpf());
        result.setCity(client.getClientAdress().getCity());
        result.setState(client.getClientAdress().getState());
        return result;
    }

    private AddressResult mapEntityToAddress(Address adress){
        AddressResult ad = new AddressResult();
        ad.setType(adress.getType());
        ad.setCep(adress.getCep());
        ad.setCity(adress.getCity());
        ad.setId(adress.getId());
        ad.setState(adress.getState());
        ad.setComplement(adress.getComplement());
        ad.setNumber(adress.getNumber());
        ad.setStreet(adress.getStreet());
        return ad;

    }
    private ClientResult mapEntityToDTO (Client client) {
        ClientResult cl = new ClientResult();
        cl.setId(client.getId());
        cl.setCpf(client.getCpf());
        cl.setEmail(client.getEmail());
        cl.setName(client.getName());
        cl.setPhone(client.getPhone());
        cl.setWage(client.getWage());
        cl.setClientAdress(mapEntityToAddress(client.getClientAdress()));
        return cl;

    }

}
