package ua.com.hav.workbase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.workbase.model.Level;

public interface LevelRepo extends JpaRepository<Level, Integer> {
}
