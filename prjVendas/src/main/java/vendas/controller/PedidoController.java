package vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vendas.entities.Pedido;
import vendas.servicies.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

private final PedidoService pedidoService;
	
	@Autowired
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findPedidobyId(@PathVariable Long idpedido) {
		Pedido pedido = pedidoService.getPedidoByIdpedido(idpedido);
		if (pedido != null) {
			return ResponseEntity.ok(pedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Pedido>> findAllUsuarioscontrol() {
		List<Pedido> pedido = pedidoService.getAllPedido();
		return ResponseEntity.ok(pedido);
	}

	@PostMapping("/")
	public ResponseEntity<Pedido> insertUsuariosControl(@RequestBody Pedido pedido) {
		Pedido novopedido = pedidoService.savePedido(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(novopedido);
	}

	@PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long funcodigo, @RequestBody Pedido pedido) {
		Pedido pedidoAtualizado = pedidoService.updatePedido(funcodigo, pedido);
        if (pedidoAtualizado != null) {
            return ResponseEntity.ok(pedidoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	@DeleteMapping("/id")
	public ResponseEntity<String> deleteUsuarioControl(@PathVariable Long funcodigo) {
		boolean remover = pedidoService.deletePedido(funcodigo);
		if (remover) {
			return ResponseEntity.ok().body("pedido Excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
