package ule.edi.queuewithrep;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.edi.exceptions.EmptyCollectionException;

//sgonl@unileon.es
//Tutorias:
//L: 18:00 - 20:30
//X: 19:00 - 20:00
//V: 18:00 - 20:30

public class ArrayQueueWithRepImpl<T> implements QueueWithRep<T> {
	
	// atributos
	
    private final int capacityDefault = 10;
	
	ElemQueueWithRep<T>[] data;
    private int count;
    
	// Clase interna 
    
	@SuppressWarnings("hiding")
	public class ElemQueueWithRep<T> {
		T elem;
		int num;
		public ElemQueueWithRep (T elem, int num){
			this.elem=elem;
			this.num=num;
		}
	}

	
	///// ITERADOR //////////
	@SuppressWarnings("hiding")
	public class ArrayQueueWithRepIterator<T> implements Iterator<T> {
		
		private int count;
		private int current;
		private T[] items;
					
		public ArrayQueueWithRepIterator(T[] cola, int count){
					this.items = cola;
					this.count = count;
					this.current = 0;
		}

		@Override
		public boolean hasNext() {			
			return (current < count);
		}

		@Override
		public T next() throws NoSuchElementException{
			if(!hasNext())throw new NoSuchElementException();
			
			current++;
			return items[current - 1];
		}
		
		

	}
	////// FIN ITERATOR
	
	
    // Constructores

	@SuppressWarnings("unchecked")
	public ArrayQueueWithRepImpl() {
		data =   new ElemQueueWithRep[capacityDefault];
		count=0;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueueWithRepImpl(int capacity) {
		data =  new ElemQueueWithRep[capacity];
		count=0;
	}
	
	
	 @SuppressWarnings("unchecked")
	 private void expandCapacity() {
		
			ElemQueueWithRep<T>[] nuevo= (ElemQueueWithRep<T>[]) new ElemQueueWithRep[data.length*2];
			
			// todo
		}
	 
	
			@Override
			public void add(T element, int times) {
				// TODO 
				if(times < 0) {
					throw new IllegalArgumentException("Error: El numero de repeticiones del elemento no puede ser menor que 0");
				}else if(element == null) {
					throw new NullPointerException("Error: El elemento no puede ser nulo");
				}else {
					data[count] = new ElemQueueWithRep(element, times);
					count++;
				}
			}
			

			@Override
			public void add(T element) {
				// TODO 
				if(element == null) {
					throw new NullPointerException("Error: El elemento no puede ser nulo");
				}else {
					data[count] = new ElemQueueWithRep(element, 1);
					count++;
				}
			}
				
			@Override
			public void remove(T element, int times) throws Exception {
				//todo
				if(count == 0) {
					throw new EmptyCollectionException("Error: El array ya estaba vacio\n");
				}else if(element == null){
					throw new NullPointerException("Error: El elemento no existe");
				}else if(times < 0 || times >= this.data.length) {
					throw new IllegalArgumentException("Error: Numero de apariciones del elemento incorrecto");
				}else {
					int i = 0;
					while(data[i] != element) {
						i++;
					}
					//Borrar numero de elementos pasados como param
					int aux = data[i].num - times;
					if(aux >= 0) {
						data[i].num = aux;
					}
				}
			}

			@Override
			public int remove() throws EmptyCollectionException {
				//todo
				if(count == 0) {
					throw new EmptyCollectionException("Error: El array ya estaba vacio\n");
				}else {
					data[0] = null;
					count--;
					return 0;
				}
				
			}

			@Override
			public void clear() {
				// TODO 
				data = null;
				
			}
			

			@Override
			public boolean contains(T element) {
				// TODO 
				int i = 0;
				
				while(data[i].elem != element && i < data.length) {
					i++;
				}
				if(data[i].elem == element){
					return true;
				}else {
					return false;
				}
			}

			@Override
			public boolean isEmpty() {
				// TODO 
				boolean result = true;
				int i = 0;
				while(i < data.length && result == true) {
					if(data[i] == null) {
						result = true;
					}else {
						result = false;
					}
				}
				return result;
			}

			@Override
			public long size() {
				// TODO
				int size = 0;
				for(int i = 0; i < data.length; i++) {
					if(data[i] != null) {
						size += data[i].num;
					}
				}
				return size;
			}

			@Override
			public int count(T element) {
				// TODO 
				int i = 0;
				int count = 0;
				
				while(i < data.length && data[i].elem.equals(element)) {
					i++;
				}
				
				if(data[i].elem.equals(element)) {
					count = data[i].num;
				}
				return count; 
			}

			@Override
			public Iterator<T> iterator() {
				// TODO 
				return new ArrayQueueWithRepIterator(this.data, this.count);
			}
			
			@Override
			public String toString() {
				
				final StringBuffer buffer = new StringBuffer();
				
				buffer.append("(");

				// TODO Ir añadiendo en buffer las cadenas para la representación de la cola. Ejemplo: (A, A, A, B )
				
				buffer.append(")");
				
				return buffer.toString();
			}

	
}
