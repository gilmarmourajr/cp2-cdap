package aplicacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.DecimalFormat;

import entidades.Encomenda;
import entidades.Produto;
import filas.FilaEncomendas;
import filas.FilaProdutos;

// Checkpoint 2 - 2SIPF
// Grupo: Gilmar Moura, RM 557292
// Eduardo Calo, RM 555933
// Fernando Nakasone, RM 558179
// Caique de Lacerda, RM 555532
// Vitor Garcia, 558516

public class Distribuidor {
	public static Scanner le = new Scanner(System.in);

	public static void main(String[] args) {

		// Declara e inicia a filaEncomendas da classe FilaEncomenda
		//com a fila de encomendas armazenadas no arquivo ListaEncomendas.txt
		//usa a funcao ja implemetada a seguir para ler o arquivo e enfileirar as encomendas
		FilaEncomendas filaEncomendas = new FilaEncomendas();
		geraFilaEncomendas(filaEncomendas);

		int opcao;
		do {
			System.out.println("0 - Encerrar atendimento");
			System.out.println("1 - Inserir encomenda na fila para aguarda atendimento");
			System.out.println("2 - Atender uma encomenda");
			System.out.println("Opcao: ");
			opcao = le.nextInt();
			switch (opcao) {
			case 0:
				break;
			case 1:
				inserirEncomenda(filaEncomendas);
				break;
			case 2:
				if(!filaEncomendas.isEmpty()) {					
					atenderEncomenda(filaEncomendas);
				} else {
					System.out.println("Nao ha encomendas para serem atendidas\n");
				}
				break;
			default:
				System.out.println("Opcao Invalida\n");
			}

		} while (opcao != 0);

		le.close();

	}

	public static void geraFilaEncomendas(FilaEncomendas fila) {

		String caminhoDoArquivo = "src/arquivos/ListaEncomendas.txt";
		
		try {
			// Criar um objeto File com o caminho do arquivo
			File arquivo = new File(caminhoDoArquivo);

			// Criar um Scanner para ler o arquivo
			Scanner leArq = new Scanner(arquivo);

			// Loop para ler linha por linha ate o final do arquivo
			while (leArq.hasNextLine()) {

				// Ler a proxima linha
				String linha = leArq.nextLine();
				String[] partes = linha.split(",");
				Encomenda obj = new Encomenda();
				obj.clienteID = partes[0];
				obj.nomeArquivo = partes[1];
				fila.enqueue(obj);
			}
			// Fechar o objeto da classe Scanner le
			leArq.close();
		} catch (FileNotFoundException e) {
			// Caso o arquivo nao seja encontrado
			System.out.println("\nArquivo nao encontrado: " + e.getMessage());
		}
	}

	public static void geraFilaProdutos(FilaProdutos filaProd, String nomeArquivo) {
		
		String caminhoDoArquivo = "src/arquivos/";
		
		try {
			
			File arquivo = new File(caminhoDoArquivo + nomeArquivo);
			Scanner leArq = new Scanner(arquivo);

			while (leArq.hasNextLine()) {
				String linha = leArq.nextLine();
				String[] partes = linha.split(",");
				Produto produto = new Produto();
				produto.codigo = partes[0];
				produto.descricao = partes[1];
				produto.preco = Double.parseDouble(partes[2]);
				produto.localizacao = partes[3];
				filaProd.enqueue(produto);
				
			}
			leArq.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("\nArquivo nao encontrado: " + e.getMessage());
		}

	}
	
	public static void inserirEncomenda(FilaEncomendas filaEncomendas) {
		System.out.println("Informe o ID do cliente: ");
		String id = le.next();
		System.out.println("Nome do arquivo de produtos encomendados: ");
		String nomeArquivo = le.next();
		Encomenda encomenda = new Encomenda();
		encomenda.clienteID = id;
		encomenda.nomeArquivo = nomeArquivo;
		filaEncomendas.enqueue(encomenda);
		System.out.println("");
	}
	
	public static void atenderEncomenda(FilaEncomendas filaEncomendas) {
		DecimalFormat fM = new DecimalFormat("R$#0.00");
		FilaProdutos filaProd = new FilaProdutos();
		Encomenda encomenda = filaEncomendas.dequeue();
		geraFilaProdutos(filaProd, encomenda.nomeArquivo);
		
		if(filaProd.isEmpty()) {
			System.out.println("\nArquivo de encomenda nao presente\n");
		} else {
			double total = 0;
			
			System.out.println("\nAtendimento do pedido do cliente " + encomenda.clienteID + " esta iniciando\n");
			while(!filaProd.isEmpty()) {
				Produto prod = filaProd.dequeue();
				System.out.println("Produto [Codigo = " + prod.codigo + ", Descricao = " + prod.descricao + ", Preco = " + fM.format(prod.preco) + ", localizacao = " + prod.localizacao + "]\nO produto foi encontrado foi encontrado na prateleira? (1 - sim): ");
				int resp = Integer.parseInt(le.next());
				if(resp != 1) { // caso o produto nao esteja disponivel
					System.out.println("Voltar depois para colocar no carrinho");
					filaProd.enqueue(prod);
				} else {
					total += prod.preco;
				}
			}
			
			System.out.println("\nAtendimento da encomenda foi finalizada com sucesso\nValor total da compra: " + fM.format(total)+"\n");
		}
		
	}
}
