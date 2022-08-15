package br.com.bb.bb.models;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;
    private String nome;


    public Categoria(){}
    public Categoria(long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                '}';
    }
}
