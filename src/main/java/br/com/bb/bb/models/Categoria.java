package br.com.bb.bb.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoriaCode;
    private String nome;

    @OneToMany(mappedBy = "categoriaCode", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cliente> clientes;


    public Categoria(){}
    public Categoria(long categoriaCode, String nome) {
        this.categoriaCode = categoriaCode;
        this.nome = nome;
    }

    public long getCodigo() {
        return categoriaCode;
    }

    public void setCodigo(long categoriaCode) {
        this.categoriaCode = categoriaCode;
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
                "categoriaCode=" + categoriaCode +
                ", nome='" + nome + '\'' +
                '}';
    }
}
