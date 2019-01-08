package ua.com.hav.workbase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.hav.workbase.model.Obj;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DateController {

    @Autowired
    private DateRepo dateRepo;

    @RequestMapping("/date/form")
    public String form(Model model) {
        Obj obj = new Obj();
        obj.setDate(new Date());
//        obj.setDate(LocalDate.now());
        model.addAttribute("abc", obj);
        return "date/form";
    }

    @RequestMapping(value = "/date/save", method = RequestMethod.POST)
    public String save(@Valid Obj abc, BindingResult errors) {
        System.out.println("obj = " + abc);
        if (errors.hasErrors()) {
            return "date/form";
        }
        dateRepo.save(abc);
        return "redirect:/date/";
    }

    @RequestMapping("/date/")
    public String list(Model model) {
//        model.addAttribute("objects", dateRepo.findAll(new Sort(new Sort.Order(Sort.Direction.DESC, "date"))));
        List<Obj> all = dateRepo.findAll();
        List<Obj> sorted = all.stream().sorted((a, b) -> {
            return a.getDate().compareTo(b.getDate());
        }).collect(Collectors.toList());
        model.addAttribute("objects", sorted);
        return "date/list";
    }

    @RequestMapping("/date/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Obj obj = dateRepo.findById(id).orElseThrow(() -> new RuntimeException("" + id));
        model.addAttribute("abc", obj);
        return "date/form";
    }
}
