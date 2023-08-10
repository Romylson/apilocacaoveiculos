package br.com.procode.api.repository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import br.com.procode.api.entity.Veiculos;

@Repository
public interface VeiculosRepository extends JpaRepositoryImplementation<Veiculos, Long>  {
	Veiculos findByPlaca(String placa);
}
