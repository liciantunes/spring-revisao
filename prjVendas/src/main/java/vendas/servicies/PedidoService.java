package vendas.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vendas.entities.Pedido;
import vendas.repositories.PedidoRepository;
@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> getAllPedido() {
		return pedidoRepository.findAll();
	}

	public Pedido getPedidoByIdpedido(long idpedido) {
		return pedidoRepository.findById(idpedido).orElse(null);
	}

	public Pedido savePedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public boolean deletePedido(Long idpedido) {
		Optional<Pedido> pedidoExistente = pedidoRepository.findById(idpedido);
		if (pedidoExistente.isPresent()) {
			pedidoRepository.deleteById(idpedido);
			return true;
		} else {
			return false;
		}
	}

	public Pedido updatePedido(Long idpedido, Pedido novoPedido) {
		Optional<Pedido> pedidoOptional = pedidoRepository.findById(idpedido);
		if (pedidoOptional.isPresent()) {
			Pedido pedidoExistente = pedidoOptional.get();
			pedidoExistente.setIdpedido(novoPedido.getIdpedido());
			pedidoExistente.setData(novoPedido.getData());
			pedidoExistente.setValor(novoPedido.getValor());

			
			if (novoPedido.getCliente() != null) {
				pedidoExistente.setCliente(novoPedido.getCliente());
			}		
			return pedidoRepository.save(pedidoExistente);
		} else {
			return null; 
		}
	}
}
