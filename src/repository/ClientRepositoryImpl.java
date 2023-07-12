package repository;

import domain.enums.ClientType;
import domain.models.Client;
import mapping.dtos.ClientDto;
import mapping.mappers.ClientMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClientRepositoryImpl implements ClientRepository {


    List<Client> clients;

    public ClientRepositoryImpl() {
        clients = new ArrayList<>();
    }
    @Override
    public ClientDto createClient(ClientDto client) {
        clients.add(ClientMapper.mapFrom(client));
        return null;
    }

    @Override
    public ClientDto updateClient(ClientDto client) {

        Client clientSaved = findById(client.identifier());
        clientSaved.setContact(client.cellPhone());
        clientSaved.setFullName(client.fullName());
        clientSaved.setEmail(client.email());
        updateClientInList(clientSaved);
        return ClientMapper.mapForm(clientSaved);
    }

    private void updateClientInList(Client client) {
        clients.remove(client);
        clients.add(client);
    }

    @Override
    public ClientDto removeClient(String clientId) {

        clients.remove(clientId);

        return null;
    }

    @Override
    public List<ClientDto> listAllClient() {
        return clients.stream().map(ClientMapper::mapForm).collect(Collectors.toList());
    }

    @Override
    public List<ClientDto> listAllByType(ClientType type) {
        return clients.stream()
                .filter(e->e.getType().equals(type))
                .map(e->ClientMapper.mapForm(e))
                .toList();

    }
    private Client findById(String indentifier){
        for(Client client : clients){
            if(client.getIdentifier().equalsIgnoreCase(indentifier)){
                return client;
            }
        }
        throw new RuntimeException("Client not found");
    }

}
