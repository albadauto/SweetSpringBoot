package br.com.sweetspring.sweetspring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

    @Column(nullable = false)
    private int userid;

    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    @ManyToOne
    @JoinColumn(name = "USERID", nullable = false, referencedColumnName = "USUID", insertable = false, updatable = false) //Retira a capacidade de ter insert e update nessa propriedade
    private User user;

    @OneToOne(mappedBy = "menu")
    private Payment payment;

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
