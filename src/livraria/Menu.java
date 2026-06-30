package livraria;

import java.util.*;

import livraria.controller.ProdutoController;
import livraria.model.Ebook;
import livraria.model.LivroFisico;
import livraria.model.Produto;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	
	private static final ProdutoController produtoController = new ProdutoController();

	public static void main(String[] args) {

		int opcao;
		
		criarProdutosTeste();

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("             BOOKVERSE - LIVRARIA ONLINE             ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Livro                        ");
			System.out.println("            2 - Listar todos os Livros             ");
			System.out.println("            3 - Buscar Livro por ID                ");
			System.out.println("            4 - Atualizar Dados do Livro           ");
			System.out.println("            5 - Apagar Livro                      ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro entre 0 e 5");
				leia.nextLine();
			}

			if (opcao == 0) {
				System.out.println("\nBookVerse - Sua livraria online para todos os leitores.");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar Livro\n\n");
				cadastrarProduto();
				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os Livros\n\n");
				listarProdutos();
				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados do Livro - por ID\n\n");
				procurarProdutoPorId();
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados do Livro\n\n");
				atualizarProduto();
				keyPress();
				break;
			case 5:
				System.out.println("Apagar o Livro\n\n");
				deletarProduto();
				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				keyPress();
				break;
			}
		}

	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Nayara");
		System.out.println("Nayara Bastos Porto - bastosnayara24@gmail.com");
		System.out.println("github.com/nayarabastos           ");
		System.out.println("*********************************************************");

	}

	public static void keyPress() {
		System.out.println("\n\nPressione Enter para continuar...");
		leia.nextLine();
	}
	
	private static void criarProdutosTeste() {
		produtoController
				.cadastrar(new LivroFisico(produtoController.gerarId(), "O Senhor dos Anéis","J. R. R. Tolkien", 1, 89.90f, 1216));
		produtoController
				.cadastrar(new Ebook(produtoController.gerarId(), "Clean Code","Robert C. Martin",2, 50.00f, 12));
	}

	private static void listarProdutos() {
		produtoController.listarTodas();
	}

	private static void cadastrarProduto() {

		System.out.print("Digite o Título do Livro: ");
		String titulo = leia.nextLine();
		
		System.out.print("Digite o Autor do Livro: ");
		String autor = leia.nextLine();

		System.out.print("Digite o Categoria do Livro (1 - Livro Físico | 2 - E-book): ");
		int categoria = leia.nextInt();

		System.out.print("Digite o Preço do Livro: ");
		float preco = leia.nextFloat();

		switch (categoria) {
		case 1 -> {
			System.out.print("Digite a Quantidade de Páginas: ");
			leia.skip("\\R");
			int numeroPaginas = leia.nextInt();
			
			produtoController.cadastrar(new LivroFisico(produtoController.gerarId() ,titulo, autor, categoria, preco, numeroPaginas));
		}
		case 2 -> {
			System.out.print("Digite o tamanho do Arquivo: ");
			leia.skip("\\R");
			int tamanhoArquivo = leia.nextInt();
			
			produtoController.cadastrar(new Ebook(produtoController.gerarId(), titulo, autor, categoria, preco, tamanhoArquivo));
		}
		default -> System.out.println("Categoria de produto inválido!");
		}
	}

	private static void procurarProdutoPorId() {

		System.out.print("Digite o Id do Livro: ");
		int id = leia.nextInt();
		leia.nextLine();

		produtoController.procurarPorId(id);
	}

	private static void deletarProduto() {

		System.out.print("Digite o Id do Livro: ");
		int id = leia.nextInt();
		leia.nextLine();

		Produto produto = produtoController.buscarNaCollection(id);

		if (produto != null) {

			System.out.print("\nTem certeza que deseja excluir o livro? (S/N): ");
			String confirmacao = leia.nextLine();

			if (confirmacao.equalsIgnoreCase("S")) {
				produtoController.deletar(id);
			} else {
				System.out.println("\nOperação cancelada!");
			}

		} else {
			System.out.printf("\nO produto Id %d não foi encontrado!", id);
		}
	}

	private static void atualizarProduto() {

		System.out.print("Digite o Id do Livro: ");
		int id = leia.nextInt();
		leia.nextLine();

		Produto produto = produtoController.buscarNaCollection(id);

		if (produto != null) {

			String titulo = produto.getTitulo();
			String autor = produto.getAutor();
			int categoria = produto.getCategoria();
			float preco = produto.getPreco();

			System.out.printf(
					"titulo atual: %s\nDigite o novo título do Livro (Pressione ENTER para manter o valor atual): ", titulo);
			String entrada = leia.nextLine();
			titulo = entrada.isEmpty() ? titulo : entrada;
			
			System.out.printf(
					"titulo atual: %s\nDigite o novo Autor (Pressione ENTER para manter o valor atual): ", autor);
			entrada = leia.nextLine();
			autor = entrada.isEmpty() ? autor : entrada;

			System.out.printf("Preço atual: %.2f\nDigite o novo Preço (Pressione ENTER para manter o valor atual): ",
					preco);
			entrada = leia.nextLine();
			preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada.replace(",", "."));

			switch (categoria) {
			case 1 -> {
				int numeroPaginas = ((LivroFisico) produto).getNumeroPaginas();
				
				System.out.printf(
						"O Número de Páginas Atual é: %s\nDigite o novo Número de Páginas (Pressione ENTER para manter o valor atual): ",
						numeroPaginas);
				entrada = leia.nextLine();
				numeroPaginas = entrada.isEmpty() ? numeroPaginas : Integer.parseInt(entrada);
				produtoController.atualizar(new LivroFisico(id, titulo, autor, categoria, preco, numeroPaginas));

			}

			case 2 -> {
				int tamanhoArquivo = ((Ebook) produto).getTamanhoArquivo();

				System.out.printf(
						"O Tamanho de Arquivo Atual é: %s\nDigite o novo Tamanho do Arquivo (Pressione ENTER para manter o valor atual): ",
						tamanhoArquivo);
				entrada = leia.nextLine();
				tamanhoArquivo = entrada.isEmpty() ? tamanhoArquivo : Integer.parseInt(entrada);
				produtoController.atualizar(new Ebook(id, titulo, autor, categoria, preco, tamanhoArquivo));
			}
			default -> System.out.println("Categoria de produto inválido!");
			}

		} else {
			System.out.printf("\nA produto número %d não foi encontrado!", id);
		}
	}
}
