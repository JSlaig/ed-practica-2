package ule.edi.queuewithrep;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.edi.exceptions.EmptyCollectionException;


public class LinkedQueueWithRepImpl<T> implements QueueWithRep<T> {
 
	// Atributos
	private QueueWithRepNode<T> front;
	int count;
	
	
	// Clase interna
	@SuppressWarnings("hiding")
	public class QueueWithRepNode<T> {
		T elem;
		int num;
		QueueWithRepNode<T> next;
		
		public QueueWithRepNode (T elem, int num){
			this.elem=elem;
			this.num=num;
		}
		
	}
	
	///// ITERADOR //////////
	@SuppressWarnings("hiding")
	public class LinkedQueueWithRepIterator<T> implements Iterator<T> {
		
	private int count;
	private QueueWithRepNode<T> current;
		
       	
		public LinkedQueueWithRepIterator(QueueWithRepNode<T> nodo) {
			this.current = nodo;
			this.count = 0;
		}
		
		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public T next() {
			if (! hasNext()) throw new NoSuchElementException();
				
			T result = current.elem;
			current = current.next;
			return result;
		}
	}
	////// FIN ITERATOR
	
	public LinkedQueueWithRepImpl() {
		//Preguntar por el atributo front
		count = 0;		
	}

	/////////////
	@Override
	public void add(T element) {
		//todo
		if(!(contains(element))) {
	
		}		
	}
	
	@Override
	public void add(T element, int times) {
		//todo

		}


	@Override
	public void remove(T element, int times) {
		//todo

		
	}

	
	@Override
	public boolean contains(T element) {
		//todo

		
	}

	@Override
	public long size() {
		//todo
		return this.count;
	}

	@Override
	public boolean isEmpty() {
		//todo
		boolean result = false;
		if(this.count == 0) {
			result = true;
		}
		return result;
	}

	@Override
	public int remove() throws EmptyCollectionException {
		//todo

		
	}

	@Override
	public void clear() {
		//todo
		this.front = null;
	}

	@Override
	public int count(T element) {
		//todo
	
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO 
		return new LinkedQueueWithRepIterator(front);
	}


	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("(");
		
		// TODO Ir añadiendo en buffer las cadenas para la representación de la cola. Ejemplo: (A, A, A, B )
		
		
		buffer.append(")");
		return buffer.toString();
	}

	
	

}
