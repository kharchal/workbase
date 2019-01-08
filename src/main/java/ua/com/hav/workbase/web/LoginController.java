package ua.com.hav.workbase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.hav.workbase.model.User;
import ua.com.hav.workbase.service.RoleService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/login/", method = RequestMethod.GET)
    public String loginPage() {
        return "login/login";
    }

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password, HttpSession session) {
        User user = userRepo.findByLoginAndPassword(login, password);
        if (user == null) {
            return "redirect:/login/";
        }
        String role = user.getRole().getValue();
        session.setAttribute("userRole", role);
//        roleService.setRights(session, role);
        return "redirect:/";
    }
}
