package br.com.sweetspring.sweetspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sweetspring.sweetspring.dto.PaymentDTO;
import br.com.sweetspring.sweetspring.entity.Payment;
import br.com.sweetspring.sweetspring.entity.ResponseHttpAPI;
import br.com.sweetspring.sweetspring.repository.PaymentRepository;

@RestController
@RequestMapping("/Payment")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/CreatePayment")
    public ResponseEntity<?> CreatePayment(@RequestBody Payment payment) {
        if (payment == null){
            return ResponseEntity.badRequest().body(new ResponseHttpAPI<>() {
                {
                    success = false;
                    data = null;
                    message = "É obrigatório a passagem de um objeto";
                }
            });
        }
            
        this.paymentRepository.save(payment);
        return ResponseEntity.ok().body(new ResponseHttpAPI<Payment>(){{
            success = true;
            data = payment;
            message = "Pagamento inserido com sucesso";
        }});
    }

    @GetMapping("/GetAllPayments")
    public List<Payment> GetAllPayments(){
        return this.paymentRepository.findAllPayments();
    }



}
