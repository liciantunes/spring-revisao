package vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import vendas.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Long>{
	
	
}
