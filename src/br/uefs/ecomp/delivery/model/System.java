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

import br.uefs.ecomp.delivery.util.MyLinkedList;
import br.uefs.ecomp.delivery.util.MyQueue;
import java.util.Iterator;

/**
 * Gerencia e opera outras classes(Cliente, Cardapio, Pedido).
 * @author Jonathas Santos e Santos
 *
 */
public class System {
	
	private MyLinkedList listCliente = new MyLinkedList();
	private MyLinkedList listCardapio = new MyLinkedList();
	private MyQueue filaPedidos = new MyQueue();
	
	/**
	 * Retorna um atributo do tipo clientes
	 * @return listaCliente referência para o objeto clientes
	 */
	public MyLinkedList getClientes() {
		return listCliente;
	}
	
	/**
	 * Retorna um atributo do tipo cardápio
	 * @return listCardapio referência para o objeto cardápio
	 */
	public MyLinkedList getCardapio() {
		return listCardapio;
	}

	/**
	 * Acessa o objeto cliente e retorn seu iterator
	 * @return listCliente.iterator() referência para o iterator
	 */
	public Iterator iterator() {
		return listCliente.iterator();
	}
	
	/**
	 * Retorna um atributo do tipo pedido
	 * @return filaPedidos referência para o objeto pedido
	 */
	public MyQueue getPedidosAbertos() {
		return filaPedidos;
	}	
	
	/**
	 * Acessa e retorna a lista de pedidos fechados
	 * @return filaPedidos.getlistFechado() referência para a lista de pedidos fechados
	 */
	public MyLinkedList getPedidosFechados() {
		return filaPedidos.getlistFechado();
	}
}
