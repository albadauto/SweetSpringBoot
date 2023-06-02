package br.com.sweetspring.sweetspring.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sweetspring.sweetspring.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
    @Query(value = "SELECT T.PAGID, T.USERID, U.USUNAME, T.PAGVAL, T.MENID FROM TPAG T INNER JOIN TUSU U ON T.USERID = U.USUID", nativeQuery = true)
    List<Payment> findAllPayments(); 

    @Query(value = "SELECT T.PAGVAL, U.USUNAME FROM TPAG T INNER JOIN TUSU U ON T.USERID = U.USUID", nativeQuery = true)
    List<Payment> findPayments();
}
