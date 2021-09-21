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
package br.uefs.ecomp.delivery.util;

import br.uefs.ecomp.delivery.model.Pedido;

/**
 * Esta classe gerencia uma fila, e usa alguns metodos do MyLinkedList para inserir, remover ou pegar um objeto, além de conter
 * uma fila para os pedidos fechados.
 * @author Jonathas Santos e Santos
 *
 */

public class MyQueue implements IQueue {
	
	private MyLinkedList Head = new MyLinkedList();
	private MyLinkedList PedidoFechado = new MyLinkedList();

	/**Insere um objeto na fila
	 * @param data objeto a ser inserido na fila
	 */
	@Override
	public void enqueue(Object data) {
		Head.add(data);
	}

	/**Remove o primeiro objeto da fila
	 * @return Head.remove(0) o objeto removido
	 */
	@Override
	public Object dequeue() {
		return Head.remove(0);
	}

	/**
	 * Pega o primeiro objeto da fila
	 * @return Head.get(0) o objeto da primeira posição
	 */
	@Override
	public Object peek() {
		return Head.get(0);
	}

	/**
	 * Pega o ultimo objeto da fila
	 * @return Head.get(Head.size()-1) antes de retornar o ultimo objeto da fila, ele verifica o tamanho da fila, 
	 * subtrai 1 e passa essa posição para ser buscada na fila
	 */
	@Override
	public Object last() {
		return Head.get(Head.size()- 1);
	}

	@Override
	public int size() {
		return Head.size();
	}

	@Override
	public boolean isEmpty() {
		return Head.isEmpty();
	}

	/**
	 * Pega um objeto pela posição passada
	 * @param pos posição que deseja pegar o objeto
	 * @return o objeto buscado
	 */
	public Object getPos(int pos) {
		
		MyQueue Q = null, N = null;
		MyLinkedList L = new MyLinkedList();	
		MyLinkedList aux = Head;	
		int i = 0;
		
		if(pos == 0) {
			return aux;			
		}		
		
		while(Head != null) {
			L.add(Q.dequeue());
			if(i == pos) {
				N = Q;
			}			
			i++;	
		}
		
		while(Q != null) {
			Head.add(Q.dequeue());
		}		
		return N;
	}
	
	/**
	 * Muda o estado do pedido para fechado
	 */
	public void setNexttoPedidoFechado() {
		// pegar o objeto da lista aberto e coloca na lista de fechado, e set
		Pedido aux = (Pedido) this.peek();
		
		aux.setFechado();
		this.dequeue();		
		PedidoFechado.add(aux);
	}
	
	public MyLinkedList getlistFechado() {
		return PedidoFechado;
	}
	
	/**
	 * Pega um objeto pela posição passada
	 * @param i posição que deseja pegar o objeto
	 * @return o objeto buscado
	 */
	public Object get(int i) {
		MyQueue obj;
		obj = (MyQueue) getPos(i);
		return obj;
	}
	
}
