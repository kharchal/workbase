package ua.com.hav.workbase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.workbase.model.Obj;

public interface DateRepo extends JpaRepository<Obj, Long> {
}
