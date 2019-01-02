package ua.com.hav.workbase.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.hav.workbase.annotation.MethodDescription;
import ua.com.hav.workbase.model.Client;
import ua.com.hav.workbase.repo.ClientRepo;

import java.util.List;

@RestController
public class ClientRestController {

    @Autowired
    private ClientRepo clientRepo;

    @RequestMapping("/api/clients/")
    @MethodDescription("get all clients by API")
//    @ResponseBody
    public List<Client> clients() {
        return clientRepo.findAll();
    }

    @RequestMapping("/api/clients/qwe/")
    public List<Client> qwe() {
        return clientRepo.findAllByIdGreaterThan(5);
    }
}
