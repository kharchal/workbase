package ua.com.hav.workbase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.com.hav.workbase.exception.ClientNotFoundException;
import ua.com.hav.workbase.model.Account;
import ua.com.hav.workbase.model.Client;
import ua.com.hav.workbase.model.Payment;
import ua.com.hav.workbase.repo.AccountRepo;
import ua.com.hav.workbase.repo.ClientRepo;
import ua.com.hav.workbase.repo.PaymentRepo;
import ua.com.hav.workbase.service.ClientService;
//import ua.com.hav.workbase.view.ClientView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Controller
public class PaymentController {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private AccountRepo accountRepo;

    @RequestMapping("/payments/")
    public String list(Model model) {
        List<Payment> all = paymentRepo.findAll(new Sort(new Sort.Order(Sort.Direction.DESC, "date")));
        model.addAttribute("payments", all);

        model.addAttribute("total", sum(all));
        return "payment/payments";
    }

    private int sum(List<Payment> payments) {
        int sum = 0;
        for (Payment p : payments) {
            sum += p.getAmount();
        }
        return sum;
    }

    @RequestMapping("/payments/for/{id}")
    public String paymentFor(@PathVariable Integer id, Model model) {
        List<Payment> payments = paymentRepo.findByClient_IdOrderByDateDesc(id);
        model.addAttribute("payments", payments);
        model.addAttribute("total", sum(payments));
        model.addAttribute("clientId", id);
        return "payment/payments";
    }

    @RequestMapping("/payments/create/")
    public String create(Model model) {
        model.addAttribute("payment", new Payment());
        return "payment/edit";
    }

    @RequestMapping("/payments/create/{id}")
    public String createForClientId(@PathVariable Integer id, Model model) {
        Payment payment = new Payment();
        Client client = clientRepo.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
        payment.setClient(client);
        model.addAttribute("payment", payment);
        return "payment/edit";
    }

    @RequestMapping(value = "/payments/save", method = RequestMethod.POST)
    public String save(@RequestParam("client.id") Integer id, @Valid Payment payment, BindingResult result) {
        System.out.println("id = " + id);
        Client client = clientRepo.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
        payment.setClient(client);
        System.out.println("payment = " + payment);
        if (result.hasErrors()) {
            return "payment/edit";
        }
        paymentRepo.save(payment);
        return "redirect:/payments/";
    }

    @ModelAttribute("rights")
    public List<String> rights() {
        return asList("c", "u", "d", "r");
    }

    @ModelAttribute("accounts")
    public Map<Integer, String> accounts(Model model) {
        return accountRepo.findAll().stream()
                .collect(Collectors.toMap(Account::getId, Account::getName));
    }

    @ModelAttribute("clients")
    public Map<Integer, String> clients(Model model) {
        return clientRepo.findAll().stream()
                .collect(Collectors.toMap(Client::getId, Client::toString));
    }
}
