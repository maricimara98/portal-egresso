package br.ufma.portal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufma.portal.RunTimeException;
import br.ufma.portal.entidades.Curso;
import br.ufma.portal.repository.CursoRepo;

@Service
public class CursoService {
    @Autowired
    CursoRepo cursoRepository;

    public Curso createCurso(Curso curso){
        validateCurso(curso);
        return cursoRepository.save(curso);
    }

    public Curso updateCurso(Curso curso){
        return cursoRepository.save(curso);
    }

    public Curso searchbyId(Integer id){
        Optional<Curso> optional = cursoRepository.findById(id);

        if (optional.isEmpty()){
            throw new RunTimeException("Entidade não consta no banco de dados!");
        }

        return optional.get();
    }

    private void validateCurso(Curso curso){
        if (curso == null){
            throw new RunTimeException("Um Curso válido deve ser inserido");
        }else if(cursoRepository.buscarNome(curso.getNome())){
            throw new RunTimeException("Curso com mesmo nome já está cadastrado!");
        }
    } 
    
}