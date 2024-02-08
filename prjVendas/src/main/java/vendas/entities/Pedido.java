package vendas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	
     	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idpedido;
		
		@Column(name = "data")
		private String data;
		
		@Column(name = "valor")
		private double valor;
		
		@ManyToOne
		private Cliente cliente;

		public Long getIdpedido() {
			return idpedido;
		}

		public void setIdpedido(Long idpedido) {
			this.idpedido = idpedido;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public double getValor() {
			return valor;
		}

		public void setValor(double valor) {
			this.valor = valor;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
		
		

}