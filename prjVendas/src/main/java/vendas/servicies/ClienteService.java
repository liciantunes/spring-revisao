package vendas.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vendas.entities.Cliente;
import vendas.repositories.ClienteRepository;
@Service
public class ClienteService {

	@Autowired
	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public List<Cliente> getAllCliente() {
		return clienteRepository.findAll();
	}

	public Cliente getClienteByIdcliente(long idcliente) {
		return clienteRepository.findById(idcliente).orElse(null);
	}

	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public boolean deleteCliente(Long idcliente) {
		Optional<Cliente> clienteExistente = clienteRepository.findById(idcliente);
		if (clienteExistente.isPresent()) {
			clienteRepository.deleteById(idcliente);
			return true;
		} else {
			return false;
		}
	}

	
}


