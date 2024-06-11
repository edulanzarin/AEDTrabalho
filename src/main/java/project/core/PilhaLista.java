package project.core;

import project.core.exceptions.*;

public class PilhaLista <T> implements Pilha<T> {
	
	private ListaEncadeada<T> lista = new ListaEncadeada<T>();

	@Override
	public void push(T info) {
		lista.inserir(info);
	}

	@Override
	public T pop() {
		T valor;
		valor = peek();
		lista.retirar(valor);
		
		return valor;
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new PilhaVaziaException();
		}
		return lista.getPrimeiro().getInfo();
	}

	@Override
	public boolean estaVazia() {
		return lista.estaVazia();
	}

	@Override
	public void liberar() {
		lista = new ListaEncadeada<>();

		// OU

//		while (!estaVazia()) {
//			pop();
//		}

	}
	
	
	@Override
	public String toString() {
		return lista.toString();
	}
	
	
}