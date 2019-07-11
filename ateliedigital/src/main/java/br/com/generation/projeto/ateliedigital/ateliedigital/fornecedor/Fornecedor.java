package br.com.generation.projeto.ateliedigital.ateliedigital.fornecedor;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "email", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"}), @UniqueConstraint(columnNames = {"cpf"
    })
})
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String nome;

    @NotNull
    private String email;

    @NotNull
    private Integer cpf;

    @NotNull
    private Integer cep;

    @NotNull
    private Integer numero;

    @NotNull
    private  String senha;


//    @ManyToOne
//    @JoinColumn(name = "id",table = "planos")
    private Integer idPlano;


}
