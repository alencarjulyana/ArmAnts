package br.edu.ifpb.pweb2.armants.model.concreto;

import br.edu.ifpb.pweb2.armants.model.abstrato.PessoaFisica;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"candidaturas", "competencias", "estagio"})
public class Aluno extends PessoaFisica {
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "aluno_competencia",
            joinColumns = @JoinColumn(name = "id_aluno"),
            inverseJoinColumns = @JoinColumn(name = "id_competencia")
    )
    private List<Competencia> competencias = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "candidato")
    private List<Candidatura> candidaturas = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estagio")
    private EstagioEfetivado estagio;
}
