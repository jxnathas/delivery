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

import br.uefs.ecomp.delivery.util.MyQueue;

/**
 * Gerencia nome, telefone e email de cliente, e também uma fila de pedidos.
 * @author Jonathas Santos e Santos
 */
public class Cliente {
	
	private String nome, telefone, email;
	private MyQueue filaPedido = new MyQueue();

	public Cliente(String nome, String telefone, String email) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public String getName() {
		return nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public String getPhone() {
		return telefone;
	}

	public void setPhone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int size() {
		return filaPedido.size();
	}
	
	public Object get(int i) {
		return filaPedido.getPos(i);
	}

	/**
	 * Compara os atributos do cliente atual com os atributos do objeto passado
	 * @param obj que será comparado
	 * @return true se forem iguais e false se forem diferentes
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Cliente) {
			Cliente cliente = (Cliente) obj;
			if (this.getName().equals(cliente.getName()) && this.getEmail().contentEquals(cliente.getEmail()) && this.getPhone().equals(cliente.getPhone()))
				return true;
		}	
		return false;
	}
	
}
