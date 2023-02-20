package br.net.dac.client.Application.Services.Client;

import br.net.dac.client.Application.Abstractions.IMessageSender;
import br.net.dac.client.Application.Services.Client.Events.CreateClientEvent;
import br.net.dac.client.Application.Services.Client.Events.UpdateClientEvent;
import br.net.dac.client.Application.Services.Client.Result.AdressResult;
import br.net.dac.client.Application.Services.Client.Result.ClientResult;
import br.net.dac.client.Domain.Entities.Adress;
import br.net.dac.client.Domain.Entities.Client;
import br.net.dac.client.Domain.Events.ClientCreatedEvent;
import br.net.dac.client.Domain.Events.ClientUpdated;
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
            if (_clientRepository.findOneByCpf(event.getCpf()) == null ) {
                Adress adress = new Adress(event.getClientAdress().getType(), event.getClientAdress().getStreet(), event.getClientAdress().getNumber(), event.getClientAdress().getComplement(), event.getClientAdress().getCep(), event.getClientAdress().getCity(), event.getClientAdress().getState());
                Client client = new Client();
                client.setName(event.getName());
                client.setCpf(event.getCpf());
                client.setEmail(event.getEmail());
                client.setWage(event.getWage());
                client.setClientAdress(adress);
                ClientCreatedEvent eventDomain = new ClientCreatedEvent(event.getName(), event.getCpf(), event.getEmail(), event.getWage());
                _messageSender.sendMessage(eventDomain);
            }
        }
        catch (Exception ex) {

        }


    }
    @Override
    public void updateClient(UpdateClientEvent event) {
        Client client = _clientRepository.findById(event.getClientId()).get();
        Adress adress = new Adress(event.getClientAdress().getType(), event.getClientAdress().getStreet(), event.getClientAdress().getNumber(), event.getClientAdress().getComplement(), event.getClientAdress().getCep(), event.getClientAdress().getCity(), event.getClientAdress().getState());

        client.setName(event.getName());
        client.setEmail(event.getEmail());
        client.setPhone(event.getPhone());
        client.setWage(event.getWage());
        client.setClientAdress(adress);
        _clientRepository.saveAndFlush(client);

        ClientUpdated eventDomain = new ClientUpdated(event.getName(), event.getCpf(), event.getEmail());
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
        ClientResult clientResult = mapEntityToDTO(client);
        return clientResult;

    }
    public ClientResult findOneAdressByCpf(String cpf) {
        Adress adress = new Adress();
        Client client = _clientRepository.findOneByCpf(cpf);
        ClientResult clientResult = mapEntityToDTOByAdress(client, adress);
        return clientResult;
    }

    private ClientResult mapEntityToDTOByAdress(Client client, Adress adress) {
        AdressResult ad = new AdressResult();
        ClientResult c = new ClientResult();
        c.getClientAdress().setCity(adress.getCity());
        c.getClientAdress().setState(adress.getState());
        c.setCpf(client.getCpf());
        return c;
    }

    private AdressResult mapEntityToAddress(Adress adress){
        AdressResult ad= new AdressResult();
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
        cl.setName(client.getName());
        cl.setPhone(client.getPhone());
        cl.setWage(client.getWage());
        cl.setClientAdress(mapEntityToAddress(client.getClientAdress()));
        return cl;

    }

}
