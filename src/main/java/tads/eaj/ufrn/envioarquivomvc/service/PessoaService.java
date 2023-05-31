package tads.eaj.ufrn.envioarquivomvc.service;

import org.springframework.stereotype.Service;
import tads.eaj.ufrn.envioarquivomvc.model.Pessoa;
import tads.eaj.ufrn.envioarquivomvc.repository.PessoaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public void save (Pessoa p){
        this.repository.save(p);
    }

    public List<Pessoa> listAll(){
        List<Pessoa> pessoas = new ArrayList<>();
        repository.findAll().forEach(pessoas :: add);

        return pessoas;
    }
}
