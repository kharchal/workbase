package ua.com.hav.workbase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.hav.workbase.annotation.MethodDescription;
import ua.com.hav.workbase.service.RoleService;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class IndexController {

    @RequestMapping({"/","/index"})
    public String index(Model model) {
        model.addAttribute("time", new Date());
        return "index";
    }

    @Autowired
    private RoleService roleService;

    @RequestMapping("/setrole/{role}")
    @MethodDescription("set current user role as &lt;role:String&gt; ")
    public String setRole(@PathVariable String role, HttpSession session) {
        roleService.setRole(session, role);
        return "index";
    }

}
