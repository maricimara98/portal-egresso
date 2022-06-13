package br.ufma.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ufma.portal.entidades.Cargo;

@Repository
public interface CargoRepo  extends JpaRepository<Cargo, Integer> {
    @Query(value="SELECT c FROM Cargo c join c.profissoes p join p.egresso e WHERE e.id = ?1")
    public List<Cargo> getEgresso(Long egresso_id);

    @Query(value="SELECT COUNT(e) FROM Egresso e join e.profissoes p WHERE p.cargo.id = ?1")
    public Integer getIDEgresso(Long cargo_id);
}
