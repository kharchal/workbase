package ua.com.hav.workbase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.workbase.model.Payment;

import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
    List<Payment> findByClient_IdOrderByDateDesc(Integer id);
//    List<Payment> findAllOrderByDateDesc();
}
