package br.com.procode.api.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import br.com.procode.api.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepositoryImplementation<Cliente, Long > {

}
