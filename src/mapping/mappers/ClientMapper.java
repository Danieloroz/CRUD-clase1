package mapping.mappers;

import domain.models.Client;
import mapping.dtos.ClientDto;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMapper {

    public static ClientDto mapForm(Client source) {
        return new ClientDto(source.getIdentifier(),
                source.getFullName(),
                source.getEmail(),
                source.getType(),
                source.getContact());
    }

    public static Client mapFrom(ClientDto source) {
        return new Client(source.identifier(),
                source.fullName(),
                source.email(),
                source.type(),
                source.cellPhone());
    }

    public static List<ClientDto> mapFrom(List<Client> source) {
        return source.stream().map(ClientMapper::mapForm).collect(Collectors.toList());
    }

}
