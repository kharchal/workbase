package ua.com.hav.workbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hav.workbase.exception.ClientNotFoundException;
import ua.com.hav.workbase.model.Client;
import ua.com.hav.workbase.model.Person;
import ua.com.hav.workbase.repo.ClientRepo;
import ua.com.hav.workbase.repo.LevelRepo;
import ua.com.hav.workbase.repo.PersonRepo;
import ua.com.hav.workbase.view.ClientView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private PersonRepo personRepo;

    public List<Client> findAll() {
        return clientRepo.findAll();
    }
//    public List<ClientView> findAll() {
//        return clientRepo.findAll().stream().map(c -> ClientView.convert(c)).collect(Collectors.toList());
//    }

    public ClientView findById(Integer id) {
        return ClientView.convert(clientRepo.findById(id).orElseThrow(() -> new ClientNotFoundException(id)));
    }

    public void save(ClientView client) {
        Integer personId = client.getPersonId();
        Person person = personRepo.findById(personId).orElse(new Person());
        person.setName(client.getName());
        person.setSurname(client.getSurname());
        personRepo.save(person);
        Optional<Client> byId = clientRepo.findById(client.getId());
        Client client1 = null;
        if (!byId.isPresent()) {
            client1 = new Client();

        } else {
            client1 = byId.get();

        }
        client1.setPerson(person);
        client1.setLevel(client.getLevel());
        client1.setBalance(client.getBalance());
        clientRepo.save(client1);
    }
}
