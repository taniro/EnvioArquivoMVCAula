package tads.eaj.ufrn.envioarquivomvc.repository;


import org.springframework.data.repository.CrudRepository;
import tads.eaj.ufrn.envioarquivomvc.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, String> {
}
