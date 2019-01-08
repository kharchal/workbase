package ua.com.hav.workbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hav.workbase.aspect.AccessRightsHolder;
import ua.com.hav.workbase.model.AccessRight;
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
        List<String> mappings = null;
// byValue.getMappings().stream()
//                .map(r -> r.getMapping()).collect(Collectors.toList());
//        session.setAttribute("rights", mappings);
        session.setAttribute("userRole", role);
        return mappings;
    }

    public AccessRightsHolder loadRights(AccessRightsHolder rightsHolder) {
        List<Role> allRoles = roleRepo.findAll();

        for (Role role : allRoles) {
            String roleName = role.getValue();
//            for (AccessRight right : role.getMappings()) {
//                rightsHolder.put(right.getMapping(), roleName);
//            }
        }
        System.out.println();
        System.out.println("rightsHolder = " + rightsHolder);
        System.out.println();
        return rightsHolder;
    }
}
