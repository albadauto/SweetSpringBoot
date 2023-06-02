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
@Table(name = "TPAG")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAGID")
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Column(name = "PAGVAL")
    private double valor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Column(name = "userid")
    private int userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Column(name = "menid")
    private int menid;

    public int getMenid() {
        return menid;
    }

    public void setMenid(int menid) {
        this.menid = menid;
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "USUID", insertable = false, updatable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "menid", referencedColumnName = "MENID", insertable = false, updatable = false)
    private Menu menu;
}
