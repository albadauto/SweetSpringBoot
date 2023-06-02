package br.com.sweetspring.sweetspring.dto;


public class PaymentDTO {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private int Id;
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    private double valor;
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    private int menid;
    public int getMenid() {
        return menid;
    }
    public void setMenid(int menid) {
        this.menid = menid;
    }
}
