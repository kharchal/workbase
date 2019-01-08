package ua.com.hav.workbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hav.workbase.exception.ClientNotFoundException;
import ua.com.hav.workbase.model.Client;
import ua.com.hav.workbase.model.DateConverter;
//import ua.com.hav.workbase.view.ClientView;

import java.util.List;

@Service
//@Transactional
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

    public Client findById(Integer id) {
        return clientRepo.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

//    @Transactional
    public void save(Client clientView) {
//        Integer personId = clientView.getPersonId();
//        Person person = null;
//        if (personId == null) {
//            person = new Person();
//        } else {
//            person = personRepo.findById(personId).orElseThrow(() -> new RuntimeException("person not found id = " + personId));
//        }
//        person.setSurname(clientView.getSurname());
//        person.setName(clientView.getName());

        Integer id = clientView.getId();
        Client client = null;
        if (id == null) {
            client = new Client();
        } else {
            client = clientRepo.findById(id).orElseThrow(() -> new RuntimeException("client not found id = " + id));
        }
        client.setPerson(clientView.getPerson());
        client.setLevel(clientView.getLevel());
        client.setBalance(clientView.getBalance());
        client.setXdate(DateConverter.toInt(clientView.getDateString()));
        clientRepo.save(client);
    }

//    @Transactional(rollbackFor = RuntimeException.class)
//    public void saveOld(ClientView client) {
//        Integer personId = client.getPersonId();
//        personId = personId == null ? 0 : personId;
//        Person person = personRepo.findById(personId).orElse(new Person());
//        person.setName(client.getName());
//        person.setSurname(client.getSurname());
//        personRepo.save(person);
//        Integer id = client.getId();
//        id = id == null ? 0 : id;
//        Client client1 = clientRepo.findById(id).orElse(new Client());
////        Client client1 = null;
////        if (!byId.isPresent()) {
////            client1 = new Client();
////
////        } else {
////            client1 = byId.get();
////
////        }
//        client1.setPerson(person);
//        client1.setLevel(client.getLevel());
//        client1.setBalance(client.getBalance());
////        client1.setDate(client.getDate().getLongValue());
//        client1.setXdate(DateConverter.toInt(client.getXdate()));
//        System.out.println("client1 = " + client1);
//        if (client.getLevel().getId() == 2) {
//            throw new RuntimeException("xxx ???");
//        }
//        clientRepo.save(client1);
//    }
}
