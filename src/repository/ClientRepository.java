package repository;

import domain.enums.ClientType;
import mapping.dtos.ClientDto;

import java.util.List;

public interface ClientRepository {

    ClientDto createClient(ClientDto client);
    ClientDto updateClient(ClientDto client);
    ClientDto removeClient(String clientId);
    List<ClientDto> listAllClient();
    List<ClientDto> listAllByType(ClientType type);


}
