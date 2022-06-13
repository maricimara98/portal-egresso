package br.ufma.portal.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "egresso")
public class Egresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_egresso")
    private Integer id_curso;

    @OneToMany(mappedBy = "contato_id")
    private List<ContatoEgresso> contatosEgresso;

    @OneToMany(mappedBy = "egresso_id")
    private List<Depoimento> depoimentos;

    @OneToMany(mappedBy = "egresso_id")
    private List<ProfessorEgresso> professorEgresso;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "resumo")
    private String resumo;

    @Column(name = "url_foto")
    private String url_foto;

    @Builder.Default
    @OneToMany(mappedBy = "egresso", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<CursoEgresso> cursoEgressos = new ArrayList<CursoEgresso>();

    public String getEmail() {
        return email;
    }

    public String getCPF() {
        return cpf;
    }

}
