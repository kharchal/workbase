package ua.com.hav.workbase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.workbase.model.Client;

import java.util.List;

public interface ClientRepo extends JpaRepository<Client, Integer> {
    List<Client> findAllByIdGreaterThan(Integer id);
}
