package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Conta c1 = new Conta(1, 234, 1, "Matheus", 10000.0f);
		c1.visualizar();
		c1.sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		Scanner leia = new Scanner(System.in);
		
		int opcao;
		
		while (true) {
			
			System.out.println(Cores.TEXT_RED + Cores.ANSI_BLACK_BACKGROUND);
			
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            BANCO DO BRAZIL COM Z                    ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
			
			opcao = leia.nextInt();
			
			if (opcao == 9) {
				System.out.println("\nBanco do Brazil - O seu futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
				
				
				switch (opcao) {
				case 1 :
					System.out.println("Cria Conta\n");
					
					break;
				case 2 :
					System.out.println("Listar todas as Contas\n");
					
					break;
				case 3 :
					System.out.println("Consultar dados da Conta -  por número\n");
					
					break;
				case 4 :
					System.out.println("Atualizar dados da Conta\n");
					
					break;
				case 5 :
					System.out.println("Apagar Conta\n");
					
					break;
				case 6 :
					System.out.println("Saque\n");
					
					break;
				case 7 :
					System.out.println("Depósito\n");
					
					break;
				case 8 :
					System.out.println("Transferência\n");
					
					break;
				case 9 :
					System.out.println("\nOpção Inválida\n");
					
					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
					break;
				}
			}
		}
	}
		public static void sobre() {
			System.out.println("\n*********************************************************");
			System.out.println("Projeto Desenvolvido por: Matheus Alcântara ");
			System.out.println("Generation Brasil - generation@generation.org");
			System.out.println("github.com/MatheusAlcn");
			System.out.println("*********************************************************");
			
	}

}
