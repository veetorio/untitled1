package org.example.models;


import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Produtos {
    @Id
    private int id;

    @Transient
    private String nome;
    private double preco;

    public Produtos(int _id,String _nome,double _preco){
        this.nome = _nome;
        this.preco = _preco;
        this.id = _id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
