package br.ufma.portal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufma.portal.RunTimeException;
import br.ufma.portal.entidades.Contato;
import br.ufma.portal.repository.ContatoRepo;


@Service
public class ContatoService {
    @Autowired
    private ContatoRepo contatoRepository;

    public Contato salvarContato(Contato contato){
        return contatoRepository.save(contato);
    }

    public Contato searchbyId(Integer id){
        Optional<Contato> optional = contatoRepository.findById(id);

        if (optional.isEmpty()){
            throw new RunTimeException("Entidade não consta no banco de dados!");
        }

        return optional.get();

    }
    
}