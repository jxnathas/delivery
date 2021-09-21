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

/**
 *
 * @author Jonathas Santos e Santos
 */
public class Cardapio {
	
	private String descricao;
	private double valor;

	public Cardapio(String descricao, double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	/**
	 * Compara os atributos do cardapio atual com os atributos do objeto passado
	 * @param obj que será comparado
	 * @return true se forem iguais e false se forem diferentes
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Cardapio) {
			Cardapio cliente = (Cardapio) obj;
			if ((this.getDescricao().equals(cliente.getDescricao()) && this.getValor() == cliente.getValor()))
				return true;
		}	
		return false;
	}

}

