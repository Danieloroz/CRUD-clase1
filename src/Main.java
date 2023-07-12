import domain.enums.ClientType;
import domain.models.Client;
import mapping.dtos.ClientDto;
import repository.ClientRepository;
import repository.ClientRepositoryImpl;
import services.ClientService;
import services.impl.ClientServiceImpl;

public class Main {
    public static void main(String[] args) {
        ClientRepository repository = new ClientRepositoryImpl();
        ClientService service = new ClientServiceImpl(repository);
        createClients(service);

        System.out.println("clientes: "+service.listAllClient());

        service.updateClient(new ClientDto("1", "Lorena", "lorena@cue.edu.co", ClientType.TEAR1,
                "3174247454" ));

        System.out.println("clients updated: "+service.listAllClient());

        service.removeClient("1");

        System.out.println("Clients filtered: ");

        service.listAllByType(ClientType.TEAR2).forEach(System.out::println);

        service.removeClient("3");

        System.out.println("Clients updated (2): "+service.listAllClient());
    }

    private static void createClients(ClientService service){
        service.createClient(new ClientDto("1", "Lorena", "lorena@cue.edu.co", ClientType.TEAR1,
                "3174247454"));
        service.createClient(new ClientDto("2", "Lorena", "lorena@cue.edu", ClientType.TEAR2,
                "3174247454"));
        service.createClient(new ClientDto("3", "Lorena", "lorena@cue.edu", ClientType.TEAR3,
                "3174247454"));
    }
}
