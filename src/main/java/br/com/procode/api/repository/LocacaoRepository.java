package br.com.procode.api.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.procode.api.entity.Cliente;
import br.com.procode.api.entity.Locacao;
@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

	List<Locacao> findByCliente(Cliente cliente);

	List<Locacao> findByClienteAndDataPrevistaDevolucaoIsNull(Cliente cliente);

}
