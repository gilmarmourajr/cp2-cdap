package filas;

//Checkpoint 2 - 2SIPF
//Grupo: Gilmar Moura, RM 557292
//Eduardo Calo, RM 555933
//Fernando Nakasone, RM 558179
//Caique de Lacerda, RM 555532
//Vitor Garcia, 558516

public abstract class FilaInt {

	public final int N = 10;
	int dados[] = new int[N];
	int ini, fim, cont;

	public void init() {
		ini = fim = cont = 0;
	}
	public boolean isEmpty() {
		return (cont == 0);
	}
	public boolean isFull() {
		return (cont == N);
	}
	public void enqueue(int valor) {
		if (isFull())
			System.out.println("Fila cheia!");
		else {
			dados[fim] = valor;
			cont++;
			fim = (fim + 1) % N;
		}
	}

	public int first() {
		return dados[ini];
	}

}
