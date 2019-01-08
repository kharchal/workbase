package ua.com.hav.workbase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.hav.workbase.model.Client;
import ua.com.hav.workbase.model.Level;
import ua.com.hav.workbase.model.Person;
import ua.com.hav.workbase.repo.LevelRepo;
import ua.com.hav.workbase.repo.PersonRepo;
import ua.com.hav.workbase.service.ClientService;
//import ua.com.hav.workbase.view.ClientView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private LevelRepo levelRepo;

    @Autowired
    private PersonRepo personRepo;

    @RequestMapping("/clients/")
    public String list(Model model) {
        List<Client> clients = clientService.findAll();
//        List<ClientView> clientViews = new ArrayList<>();
//        for (Client c : clients) {
//            clientViews.add(new ClientView(c));
////            c.setDate(c.getDate());
//        }
        model.addAttribute("clients", clients);
        return "client/clients";
    }

    @RequestMapping("/clients/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Client client = clientService.findById(id);
//        if (!client.isPresent()) {
//            return "redirect:/clients/";
//        }
        model.addAttribute("client", client);
        return "client/edit";
    }

    @RequestMapping(value = "/clients/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("client") Client client, BindingResult result) {
        if (result.hasErrors() || client.getPerson().getId() == null) {
            return "client/edit";
        }
        System.out.println("save client = " + client);
        clientService.save(client);
        return "redirect:/clients/";
    }

    @RequestMapping("/clients/create")
    public String create(Model model) {
        model.addAttribute("client", new Client(new Person("xxx", "yyy")));
        return "client/edit";
    }

    @RequestMapping("/clients/delete/{id}")
    public String delete(@PathVariable Integer id) {
        System.out.println("deleted id = " + id);
        //delete action
        return "redirect:/clients/";
    }

//    @ModelAttribute(name = "rights")
//    public List<String> rights() {
////        return asList("r", "u", "a");
//        return asList("r", "u", "c", "d");
//    }

    @ModelAttribute(name = "levels")
    public Map<Integer, String> levels() {
        return levelRepo.findAll().stream()
                .collect(Collectors.toMap(Level::getId, Level::getValue));
    }

    @ModelAttribute(name = "persons")
    public Map<Integer, String> persons() {
        return personRepo.findAll().stream()
                .collect(Collectors.toMap(Person::getId, Person::getSurname));
    }
}
