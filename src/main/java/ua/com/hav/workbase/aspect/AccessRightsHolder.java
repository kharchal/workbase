package ua.com.hav.workbase.aspect;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.com.hav.workbase.model.Role;

import java.util.*;

@Component
@Scope(value = "singleton")
public class AccessRightsHolder {

    private Map<String, Set<String>> rights = new HashMap<>();

    public void put(String mapping, String roleName) {
        Set<String> roles = rights.get(mapping);
        if (roles == null) {
            roles = new HashSet<>();
            rights.put(mapping, roles);
        }
        roles.add(roleName);
    }

    public boolean check(String mapping, String roleName) {
        Set<String> roles = rights.get(mapping);
        if (roles == null) {
            return false;
        }
        return roles.contains(roleName);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String key : rights.keySet()) {
            sb.append("'");
            sb.append(key);
            sb.append("' => ");
            sb.append(rights.get(key));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

}
