package br.com.universomagic.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.universomagic.entidade.Carts;

public interface CartsRepository extends CrudRepository<Carts, Integer>{
	
 List<Carts> findByNameIgnoreCaseContaining(String nome);
}
