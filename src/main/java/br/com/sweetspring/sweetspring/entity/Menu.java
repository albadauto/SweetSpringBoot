package br.com.sweetspring.sweetspring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TMENU")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENID")
    private int Id;
  
    @Column(name = "MENITEM")
    private String Item;
   
    @Column(name = "MENPRECO")
    private double Preco;
    
    @Column(name = "MENTIPO")
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "USERID", nullable = false)
    private User user;

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

    public String getItem() {
        return Item;
    }
    public void setItem(String item) {
        Item = item;
    }

    

}
