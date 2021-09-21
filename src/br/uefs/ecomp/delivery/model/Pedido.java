/*******************************************************************************
Autor: Jonathas Santos e Santos
Componente Curricular: Algoritmos II
Concluido em: 30/08/2021
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/
package br.uefs.ecomp.delivery.model;

import java.util.Date;

import br.uefs.ecomp.delivery.util.MyLinkedList;
import br.uefs.ecomp.delivery.model.Cliente;
import br.uefs.ecomp.delivery.model.ItemPedido;

/**
 * Gerencia as características dos pedidos. Contém atributos de pedidos como endereço e estado do pedido, podendo ser aberto ou fechado,
 * além de ter uma lista de itens do pedido.
 * @author Jonathas Santos e Santos
 *
 */
public class Pedido {
	
	private Cliente cliente;
	private Date date;
	private String endereco;
	private boolean estadoPedido;
	private ItemPedido itemPedido;
	private MyLinkedList listaIp;

	public Pedido(Cliente c1, Date date, String endereco, boolean estadoPedido) {
		this.estadoPedido = estadoPedido;
		this.cliente = c1;
		this.date = date;
		this.endereco = endereco;
		this.listaIp = new MyLinkedList();
	}
	
	public Date getDataHora() {
		return date;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public boolean getSituacao() {
		return estadoPedido;
	}
	
	public MyLinkedList getItens() {
		return this.listaIp;
	}
	
	/**
	 * Muda a quantidade de item pedido
	 * @param i quantidade que será adicionada
	 */
	public void setQuantidade(int i) {
		itemPedido.setQuantidade(i);
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	/**
	 * Altera o estado do pedido para fechado
	 */
	public void setFechado() {
		this.estadoPedido = false;
	}
	
	/**
	 * Soma os valores dos cardápios
	 * @return total da soma dos valores de cardápio
	 */
	public float getValorTotal(){
		
		float total = 0;
		for(int i = 0; i < this.listaIp.size(); i++) {
			for(int j = 0; j < ((ItemPedido) this.listaIp.get(i)).getQuantidade(); j++) {
				total+=((ItemPedido) this.listaIp.get(i)).getValor();				
			}
		}
		return total;
	}
}
