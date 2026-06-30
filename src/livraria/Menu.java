package livraria;

import java.util.*;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                    LIVRARIA ONLINE                  ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Produto                        ");
			System.out.println("            2 - Listar todos os Produtos             ");
			System.out.println("            3 - Buscar Produto por ID                ");
			System.out.println("            4 - Atualizar Dados do Produto           ");
			System.out.println("            5 - Apagar Produto                       ");
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
				System.out.println("Criar Produto\n\n");

				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os Produtos\n\n");

				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados do Produto - por ID\n\n");

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados do Produto\n\n");

				keyPress();
				break;
			case 5:
				System.out.println("Apagar o Produto\n\n");

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

}
