package br.com.bb.bb.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(
            min = 5,
            max = 100,
            message = "O nome deve ter no minimo {min} e no maximo {max} caracteres"
    )
    private String name;

    @NotNull
    @Min(18)
    private int age;

    @NotNull
    @Pattern(regexp = "^[A-Z]{2}\\d{9}$")
    private String vat;

    @NotNull
    @Email
    private String email;

    @ManyToOne
    private Categoria categoria;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        categoria.findById();
        //        this.categoria = categoria;
    }

}
