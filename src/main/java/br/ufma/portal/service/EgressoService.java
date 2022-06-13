package br.ufma.portal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufma.portal.RunTimeException;
import br.ufma.portal.entidades.Egresso;
import br.ufma.portal.repository.EgressoRepo;

@Service
public class EgressoService {
    @Autowired
    private EgressoRepo egressoRepository;

    public Egresso createEgresso(Egresso egresso) {
        validateEgresso(egresso);
        return egressoRepository.save(egresso);

    }

    public Egresso updateEgresso(Egresso egresso) {
        return egressoRepository.save(egresso);

    }

    public Egresso searchbyId(Integer id) {
        Optional<Egresso> optional = egressoRepository.findById(id);

        if (optional.isEmpty()) {
            throw new RunTimeException("Entidade não consta no banco de dados!");
        }

        return optional.get();
    }

    private void validateEgresso(Egresso egresso) {
        if (egresso == null) {
            throw new RunTimeException("Um Egresso válido deve ser inserido");
        } else if (egressoRepository.buscarEmail(egresso.getEmail())) {
            throw new RunTimeException("Email já cadastrado!");
        } else if (egressoRepository.buscarCPF(egresso.getCPF())) {
            throw new RunTimeException("CPF já cadastrado!");
        }
    }

}