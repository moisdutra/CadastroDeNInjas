package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

// Entity transforma uma classe em uma entidade do DB
// JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column (name = "id")
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column (name = "imgUrl")
    private String imgUrl;

    @Column(name = "rank")
    private String rank;

    @Column (name = "idade")
    private int idade;

    // @ManyToOne - um ninja tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // ForeingKey
    private MissoesModel missoes;


}
