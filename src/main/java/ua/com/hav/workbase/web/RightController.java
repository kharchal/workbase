package ua.com.hav.workbase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.hav.workbase.annotation.MethodDescription;
import ua.com.hav.workbase.model.AccessRight;
import ua.com.hav.workbase.model.Role;
import ua.com.hav.workbase.repo.AccessRightRepo;
import ua.com.hav.workbase.repo.RoleRepo;
import ua.com.hav.workbase.service.RoleService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RightController {

    @Autowired
    private AccessRightRepo rightRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private RoleService service;

    @RequestMapping("/rights/")
    public String list(Model model) {
        List<AccessRight> rights = rightRepo.findAll();
        rights.sort((a, b) -> {return a.getMapping().compareTo(b.getMapping());});
        model.addAttribute("rightList", rights);
        List<Role> roles = roleRepo.findAll();
        roles.sort((a, b) -> {return a.getValue().compareTo(b.getValue());});
        model.addAttribute("roles", roles);
        return "admin/rights";
    }

    @RequestMapping("/rights/for/{r_id}/on/{m_id}")
    @MethodDescription("The method gives access right for Mapping(m_id) to Role(r_id)")
    public String on(@PathVariable(name = "r_id") Integer roleId, @PathVariable(name = "m_id") Integer mappingId, HttpSession session) {
        AccessRight right = rightRepo.findById(mappingId).orElseThrow(() -> new RuntimeException());
        Role role = roleRepo.findById(roleId).orElseThrow(() -> new RuntimeException());
        List<AccessRight> mappings = role.getMappings();
        mappings.add(right);
        roleRepo.save(role);
        String userRole = (String) session.getAttribute("userRole");
        service.setRole(session, userRole);
        return "redirect:/rights/";
    }

    @RequestMapping("/rights/for/{r_id}/off/{m_id}")
    @MethodDescription("The method takes away access right for Mapping(m_id) from Role(r_id)")
    public String off(@PathVariable(name = "r_id") Integer roleId, @PathVariable(name = "m_id") Integer mappingId, HttpSession session) {
        AccessRight right = rightRepo.findById(mappingId).orElseThrow(() -> new RuntimeException());
        Role role = roleRepo.findById(roleId).orElseThrow(() -> new RuntimeException());
        List<AccessRight> mappings = role.getMappings();
        mappings.remove(right);
        roleRepo.save(role);
        String userRole = (String) session.getAttribute("userRole");
        service.setRole(session, userRole);
        return "redirect:/rights/";
    }

    @RequestMapping("/rights/reset/")
    @MethodDescription("reset all access rights")
    public String reset() {
        List<AccessRight> rights = rightRepo.findAll();
        List<Role> roles = roleRepo.findAll();
        for (Role role : roles) {
            role.getMappings().clear();
            for (AccessRight right : rights) {
                role.getMappings().add(right);
            }
            roleRepo.save(role);
        }
        return "redirect:/rights/";
    }
}
