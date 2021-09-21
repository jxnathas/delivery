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
import java.util.Iterator;
import br.uefs.ecomp.delivery.model.Cardapio;
import br.uefs.ecomp.delivery.model.Cliente;

/**
 * Classe responsavel por gerenciar a lista encadeada. Tem como atributos sizeList, que armazena o tamanho da lista, e duas referências,
 * First para o início da lista e Last para o último.
 * @author Jonathas Santos e Santos
 *
 */

public class MyLinkedList implements IList {
	
	private Node First, Last;
	private int sizeList = 0;
	
	/**
	 * Responsavel por gerenciar os objetos que seram inseridos na lista
	 * @author Marcus Vinicius
	 *
	 */
    private class Node{
        private Object data;
        private Node next;

        public Node(Object data){
            this.data = data;
        }
        public Node getNext(){
            return next;
        }
        public void setNext(Node next){
            this.next = next;
        }
        public Object getData(){
            return data;
        }
    }

	@Override
	public int size() {
		return sizeList;
	}

	/**Insere o objeto na lista, sendo ela vazia ou não, e contém a referência para o primeiro e ultimo elemento da lista
	 * @param obj objeto que será inserido na lista
	 */
	@Override
	public void add(Object obj) {
		if(isEmpty()) {
			First = new Node(obj);
			Last = First;		
		}else {
			Node n = new Node(obj);
			Last.setNext(n);
			Last = n;
		}
		sizeList++;
	}

	/**
	 * @param pos posição que o objeto deve ser inserido e obj objeto que será inserido na lista
	 * @return true se foi possivel inserir o objeto na lista e false se nao foi possivel
	 */
	@Override
	public boolean add(int pos, Object obj) {
		
		if(pos < 0 || pos > sizeList) {
			return false;
		}else {
			if(isEmpty()) {
				First = new Node(obj);
				Last = First;
				sizeList++;
				return true;
			}
			else {
				Node a = First, b = null, c = null;
			
				for(int i = 0; i < pos; i++) {
					c = a;
					a = a.getNext();
				}
				b = new Node(obj);
				if(pos == 0) {
					b.setNext(First);
					First = b;
				}else {
					b.setNext(a);
					c.setNext(b);
				}			
				sizeList++;
				return true;
			}
		}
	}
	
	/**
	 * Remove um elemento da lista de uma posição desejada
	 * @param pos posição na qual se deseja remover o elemento da lista
	 * @return null se a lista estiver vazia ou b.getData() com o objeto que foi removido da lista
	 */
	@Override
	public Object remove(int pos) {
		
		if(isEmpty()) {
			return null;
		}else{
			Node a = First, b;
			if(pos == 0) {
				First = First.getNext();
				sizeList--;
				return a.getData();
			}else if(pos >= sizeList) {
				return null;
			}else {
				for(int i = 0; i < --pos; i++) {
					a = a.getNext();
				}
				b = a.getNext();
				a.setNext(b.getNext());
				sizeList--;
				return b.getData();
			}		
		}
	}

	/**
	 * Busca uma objrto na lista pela posição passada por parâmentro
	 * @param index: posição na qual deseja pegar o objeto
	 * @return null se não foi possivel pegar o objeto na posição pedida ou a.getData() sendo a referância para o objeto da posição
	 */
	@Override
	public Object get(int index) {
		Node a = First;
		if(isEmpty() || (index > sizeList || index < 0)) 
			return null;
		else{
			for (int i = 0; i < index; i++) {
				a = a.getNext();
			}
			return a.getData();	
		}
	}

	/**
	 * Verifica se a lista está vazia
	 */
	@Override
	public boolean isEmpty() {
		return First == null;
	}
	
	/**
	 * Instancia o objeto iterator para poder percorrer sobre os objetos da lista
	 * @return iteratorList referância do objeto
	 */
	@Override
	public Iterator iterator() {
        ListIterator iteratorlist = new ListIterator(this.First);
        return iteratorlist;
	}
	
	/**
	 * Responsável por verificar se a lista é vazia, alem de percorrer os elementos da lista
	 * @author Marcus Vinicius
	 *
	 */
    private class ListIterator  implements Iterator{
        private Node current;

        ListIterator(Node head){
            current = head;
        }

        @Override
        public boolean hasNext(){
            return  current != null;
        }

        @Override
        public Object next(){
        	if(hasNext()) {
	             Object data = current.getData();
	            current = current.getNext();
	            return data;       		
        	}
        	return null;
        } 
    }
    
    /**
     * Busca e remove o elemento da lista pelo número de telefone recebido
     * @param telefone: número de telefone a ser removido
     */
    public void removeByPhone(String telefone) {
    	String phone = "";
    	int i = 0;
    	Iterator it = iterator();
    	
    	while(it.hasNext()) {
    		phone = ((Cliente)it.next()).getPhone();
    		
    		if(telefone.equals(phone)) {
    			remove(i);
    			i--;
    		}
    		i++;
    	}	
    }
    
    /**
     * Percorre a lista de cardápio e concatena as descrições
     * @return descricão de todos os cardápios 
     */
    public Object showCardapio() {	
    	Iterator it = iterator();
    	String descricao = "";
    	
    	while(it.hasNext()) {
    		descricao += ((Cardapio)it.next()).getDescricao();
    		if(it.hasNext()) {
    			descricao += "\n";
    		}
    	}
    	return descricao;
    }
    
    /**
     * Busca por um nome ou letra na lista de clientes
     * @param nome que deseja pesquisar na lista
     * @return list.iterator() com a referência da lista contendo os objetos buscados
     */
    public Iterator searchClientebyName(String nome) {
    	Iterator it = iterator();
    	MyLinkedList list = new MyLinkedList();
    	Cliente aux = null;
    	
    	while(it.hasNext()) {
    		aux = (Cliente)it.next();
    		if(aux.getName().contains(nome)) {
    			list.add(aux);
    		}
    	}
    	return list.iterator();
    }
    
    /**
     * Busca cliente pelo número de telefone
     * @param telefone que deseja pesquisar na lista
     * @return list.iterator() com a referência da lista contendo os objetos buscados
     */
    public Iterator searchClientebyPhone(String telefone) {
    	Iterator it = iterator();
    	MyLinkedList list = new MyLinkedList();
    	Cliente aux = null;
    	
    	while(it.hasNext()) {
    		aux = (Cliente)it.next();
    		if(aux.getPhone().contains(telefone)) {
    			list.add(aux);
    		}   
    	}	
    	return list.iterator();
    }
}    

