package br.com.generation.projeto.ateliedigital.ateliedigital.planos;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Planos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private  String nome;

    @NotNull
    private Date duracao;

    @NotNull
    private BigDecimal valor;
}
