package vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import vendas.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	
	
}
