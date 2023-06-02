package br.com.sweetspring.sweetspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sweetspring.sweetspring.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
    
}
