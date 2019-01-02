package ua.com.hav.workbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hav.workbase.model.Role;
import ua.com.hav.workbase.repo.RoleRepo;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public List<String> setRole(HttpSession session, String role) {
        Role byValue = roleRepo.findByValue(role);
        System.out.println("byValue = " + byValue);
        List<String> mappings = byValue.getMappings().stream()
                .map(r -> r.getMapping()).collect(Collectors.toList());
        session.setAttribute("rights", mappings);
        session.setAttribute("userRole", role);
        return mappings;
    }
}
