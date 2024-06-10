package project.core;

public class ListaEncadeada<T> {
    private NoLista<T> primeiro;
    private NoLista<T> ultimo;
    private int tamanho = 0;
    
    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public NoLista<T> getPrimeiro() {
        return this.primeiro;
    }

    public void inserir(T info) {
        NoLista<T> novoNo = new NoLista<T>(info);

        if (estaVazia()) {
            this.primeiro = novoNo;
        } else {
            this.ultimo.setProximo(novoNo);
        }
        
        this.ultimo = novoNo;
        this.tamanho++;
    }

    public NoLista<T> buscar(T info) {
        NoLista<T> atual = this.primeiro;

        while(atual != null) {
            if (atual.getInfo().equals(info)) {
                return atual;
            }

            if (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.getProximo();
        }

        return null;
    }

    public void remover(T info) {
        NoLista<T> anterior = null;
        NoLista<T> atual = primeiro;

        while ((atual != null) && (!atual.getInfo().equals(info))) {
            anterior = atual;
            if (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
        }

        if (atual.getInfo().equals(info)) {
            if (atual == ultimo) {
                atual = anterior;
                ultimo = atual;
                anterior.setProximo(null);
            } else {
                anterior.setProximo(atual.getProximo());
            }
        }

        tamanho--;
    }

    public NoLista<T> obterNo(int posicao) {
        if ((posicao < 0) || (posicao > tamanho - 1)) {
            throw new IllegalArgumentException("Índice não existe.");
        }

        NoLista<T> aux = primeiro;
        for (int i = 0; i < posicao; i++) {
            aux = aux.getProximo();
        }

        return aux;
    }

    public int contarOcorrencias(T info) {
        int contador = 0;
        NoLista<T> atual = primeiro;
        while (atual != null) {
            if (atual.getInfo().equals(info)) {
                contador++;
            }
            atual = atual.getProximo();
        }
        return contador;
    }
}
