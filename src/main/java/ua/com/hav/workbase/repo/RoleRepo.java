package ua.com.hav.workbase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.workbase.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByValue(String value);
}
