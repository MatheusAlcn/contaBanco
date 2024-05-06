package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContaController contas = new ContaController();
		Scanner leia = new Scanner(System.in);
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestinto;
		String titular;
		float saldo, limite, valor = 0;
		
		ContaCorrente cc1 = new ContaCorrente (1, 123, 1, "José da Silva", 110.0f, 500.0f);
		cc1.visualizar();
		cc1.sacar(100.0f);
		cc1.visualizar();
		cc1.depositar(50.0f);
		cc1.visualizar();

		ContaPoupanca cp1 = new ContaPoupanca(2, 123, 2, "Paola de Andrade", 1000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(50.0f);
		cp1.visualizar();
		
		while (true) {
			
			System.out.println(Cores.TEXT_RED + Cores.ANSI_BLACK_BACKGROUND + "*****************************************************");
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
			
			try {
				opcao = leia.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}
			
			if (opcao == 9) {
				System.out.println("\nBanco do Brazil - O seu futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
				
				
				int numeroDestino;
				switch (opcao) {
				case 1 :
					System.out.println(Cores.TEXT_WHITE + "Cria Conta\n");
					
					System.out.println("Digite o Numero da Agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o nome do titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					do {
						System.out.println("Digite o Tipo da Conta (1 - CC ou 2 - CP): ");
						tipo = leia.nextInt();
					} while(tipo < 1 && tipo > 2);
						System.out.println("Digiteo Saldo da COnta (R$): ");
						saldo = leia.nextFloat();
						
						switch(tipo) {
						case 1 -> {
							System.out.println("Digite o Limite de Crédito (R$): ");
							limite = leia.nextFloat();
							contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.println("Digite o Aniversário da Conta: ");
							aniversario = leia.nextInt();
							contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
						}
					}
					KeyPress();
					break;
				case 2 :
					System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n");
					contas.listarTodas();
					KeyPress();
					break;
				case 3 :
					System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta -  por número\n");
					
					System.out.println("Digite o número da conta");
					numero = leia.nextInt();
					
					contas.procurarPorNumero(numero);
					
					KeyPress();
					break;
				case 4 :
					System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n");
					
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					
					var buscaConta = contas.buscarNaCollection(numero);
					
					if(buscaConta != null) {
						tipo = buscaConta.getTipo();
						
						System.out.println("Digite o Número da Âgencia: ");
						agencia = leia.nextInt();
						System.out.println("Nome do Titular: ");
						leia.skip("\\R");
						titular = leia.nextLine();
						
						System.out.println("Digite o saldo da Conta (R$): ");
						saldo = leia.nextFloat();
						
						switch (tipo) {
						case 1 -> {
							System.out.println("Digite o Limite da Crédito (R$): ");
							limite = leia.nextFloat();
							
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.println("Digite o dia do Aniversário da Conta: ");
							aniversario = leia.nextInt();
							
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, aniversario));
							
						}
						default -> {
							System.out.println("Tipo de conta Inválido!");
							}
						}
					} else {
						System.out.println("A conta não foi encontrada!");
					}
					KeyPress();
					break;
				case 5 :
					System.out.println(Cores.TEXT_WHITE + "Apagar Conta\n");
					
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					
					contas.deletar(numero);
					
					KeyPress();
					break;
				case 6 :
					System.out.println(Cores.TEXT_WHITE + "Saque\n");
					
					System.out.println("Digite o número da Conta: ");
					numero = leia.nextInt();
					
					do {
						System.out.println("Digite o valor do Saque (R$): ");
						valor = leia.nextInt();
					} while(valor <= 0);
					
					contas.sacar(numero, valor);
					
					KeyPress();
					break;
				case 7 :
					System.out.println(Cores.TEXT_WHITE + "Depósito\n");
					
					System.out.println("Digite o npumero da conta: ");
					numero = leia.nextInt();
					
					do {
						System.out.println("Digite o valor do Depósito (R$): ");
					}while(valor <= 0);
					
					contas.depositar(numero, valor);
					KeyPress();
					break;
				case 8 :
					System.out.println(Cores.TEXT_WHITE + "Transferência\n");
					
					System.out.println("Digite o Número da Conta de Origem: ");
					numero = leia.nextInt();
					System.out.println("Digite o Npumero da Conta de Destino: ");
					numeroDestino = leia.nextInt();
					
					do {
						System.out.println("Digite o valor da Transferência (R$): ");	
						valor = leia.nextFloat();
					}while(valor <= 0);
					
					contas.transferir(numero, numeroDestino, valor);
					KeyPress();
					break;
				case 9 :
					System.out.println(Cores.TEXT_WHITE + "\nOpção Inválida\n");
					
					KeyPress();
					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
					
					KeyPress();
					break;
				}
			}
		}
	}
		private static void KeyPress() {
		// TODO Auto-generated method stub
	
	}
		public static void sobre() {
			System.out.println("\n*********************************************************");
			System.out.println("Projeto Desenvolvido por: Matheus Alcântara ");
			System.out.println("Generation Brasil - generation@generation.org");
			System.out.println("github.com/MatheusAlcn");
			System.out.println("*********************************************************");
			
	}
		
		public static void KeyPrees() {
			
			try {
				
				System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
				System.in.read();
				
			}catch (IOException e) {
				
				System.out.println("Você pressionou uma tecla diferente de Enter!");
				
		}		
	}
}
