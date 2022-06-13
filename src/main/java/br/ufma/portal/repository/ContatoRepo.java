package br.ufma.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.ufma.portal.entidades.Contato;

@Repository
public interface ContatoRepo extends JpaRepository<Contato, Integer>{
    boolean buscarNome(String nome);
}
