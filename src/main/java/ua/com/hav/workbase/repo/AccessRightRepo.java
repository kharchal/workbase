package ua.com.hav.workbase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.workbase.model.AccessRight;

public interface AccessRightRepo extends JpaRepository<AccessRight, Integer> {

    AccessRight findByMapping(String mapping);
}
