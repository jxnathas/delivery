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
 * Gerencia características do item pedido. Tem como atributos quantidade do item pedido e uma observação.
 * @author Jonathas Santos e Santos
 */
public class ItemPedido {
	
    private String observacao;
    private int quantidade;
    private Pedido pedido;
    private Cardapio cardapio;

    public ItemPedido(Cardapio cardapio, int quantidade, String observacao) {
	this.observacao = observacao;
	this.quantidade = quantidade;
	this.cardapio = cardapio;		
    }
	
/**
* Recebe referência de um objeto do tipo pedido, e depois acessar um método de Pedido e se adiciona na lista
* @param p1 é a referência do objeto Pedido
*/
    public void setPedido(Pedido p1) {
	this.pedido = p1;
	pedido.getItens().add(this);
    }
	
    public Cardapio getOpcaoMenu() {
	return cardapio;
    }
	
    public Pedido getPedido() {
	return pedido;
    }
	
    public float getQuantidade() {
	return quantidade; 
    }
	
    public String getObservacao() {
	return observacao;
    }
	
    public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
    }
	
    public void setObservacao(String observacao) {
	this.observacao = observacao;
    }
	
    public double getValor() {
	return cardapio.getValor();
    }
}
