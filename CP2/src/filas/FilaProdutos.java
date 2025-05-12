package filas;

import entidades.Produto;

//Checkpoint 2 - 2SIPF
//Grupo: Gilmar Moura, RM 557292
//Eduardo Calo, RM 555933
//Fernando Nakasone, RM 558179
//Caique de Lacerda, RM 555532
//Vitor Garcia, 558516

public class FilaProdutos extends FilaInt {
	public Produto dados[] = new Produto[N];
	
	public void enqueue(Produto produto) {
		if (isFull())
			System.out.println("Fila cheia!");
		else {
			dados[fim] = produto;
			cont++;
			fim = (fim + 1) % N;
		}
	}
	
	public Produto dequeue() {
		Produto valor = dados[ini];
		cont--;
		ini = (ini + 1) % N;
		return valor;
	}
}