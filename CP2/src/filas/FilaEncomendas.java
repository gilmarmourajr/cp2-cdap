package filas;

import entidades.Encomenda;

//Checkpoint 2 - 2SIPF
//Grupo: Gilmar Moura, RM 557292
//Eduardo Calo, RM 555933
//Fernando Nakasone, RM 558179
//Caique de Lacerda, RM 555532
//Vitor Garcia, 558516

public class FilaEncomendas extends FilaInt {
	public Encomenda dados[] = new Encomenda[N];

	public void enqueue(Encomenda encomenda) {
		if (isFull())
			System.out.println("Fila cheia!");
		else {
			dados[fim] = encomenda;
			cont++;
			fim = (fim + 1) % N;
		}
	}
	
	public Encomenda dequeue() {
		Encomenda valor = dados[ini];
		cont--;
		ini = (ini + 1) % N;
		return valor;
	}
}