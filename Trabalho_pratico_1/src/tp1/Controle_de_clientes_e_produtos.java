package tp1;
import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;

public class Controle_de_clientes_e_produtos {
	
	public static Scanner get = new Scanner(System.in);
	public static DecimalFormat mascara = new DecimalFormat("0.000");
	
	final static int TOTAL_DE_CLIENTES = 1000;
	final static int TOTAL_DE_PRODUTOS = 1000;
	
	static Clientes[] pessoa = new Clientes[TOTAL_DE_CLIENTES];
	static Produtos[] produto = new Produtos[TOTAL_DE_PRODUTOS];
	
	public static int total_cli_cadastrados = 0;
	public static int total_pro_cadastrados = 0;
	
	public static void main(String[] args) {
	
		for (int x = 0; x < TOTAL_DE_CLIENTES; x++) {
			pessoa[x] = new Clientes();
		}
		
		for (int x = 0; x < TOTAL_DE_PRODUTOS; x++) {
			produto[x] = new Produtos();
		}
		
		cadastro_cli_aleatorio();
		cadastro_pro_aleatorio(); 
		
		boolean menuloop = true;
		int opcao = 0; 
		
		while (true) {
			
			limpatela(2);
			System.out.println("bem vindo ao sistema de controle logistico, para continuar informe somente o numero da opcao desejada:\n");
			System.out.println("(1) - cadastrar novo cliente");
			System.out.println("(2) - buscar por cliente");
			System.out.println("(3) - cadastro de novo produto");
			System.out.println("(4) - pesquisar por produto");
			System.out.println("(5) - registro de venda");
			System.out.println("(6) - mostrar produtos em estoque");
			System.out.println("(7) - para encerrar o programa");
			opcao = get.nextInt();
		
			switch (opcao) {
				case 1:
					entrada_de_clientes();		
					break;
				case 2:
					busca_de_clientes();
					break;
				case 3:
					entrada_de_produtos();
					break;
				case 4:
					busca_de_produtos();
					break;
				case 5:
					registro_vendas();
				case 6:
					lista_de_produtos();
					break;
				case 7:
					System.out.println("Encerrando o programa... tchau :)");
			        System.exit(0);
			        break;
				default:
					System.out.println("\nOpção Inválida!");
					break;
			}
		
		}
		
		
	}
	
	public static void entrada_de_clientes() {
		
		System.out.println("Informe a quantidade de clientes a serem cadastrados");
		int quantdecli= get.nextInt();
		
		for(int i = 0; i < (quantdecli + total_cli_cadastrados); i++) {
			if (pessoa[i].nome.equals("padrao")) {
				System.out.println("Informe os dados do " + (i + 1) + "º cliente a ser cadastrado:");
				System.out.println("Nome do cliente:");
				pessoa[i].nome = get.next();
				System.out.println("Endereco:");
				pessoa[i].endereco = get.next();
				System.out.println("Telefone:");
				pessoa[i].telefone = get.next();
			}
		}
		total_cli_cadastrados += quantdecli;
	
	}
	
	public static void busca_de_clientes() {
		
		boolean achou = false;
		int i;
		
		System.out.println("Qual o nome do cliente que deseja pesquisar? ");
		String pesquisa_nome = get.next();
		
		for(i = 0; i < TOTAL_DE_CLIENTES; i++) {
			if (pessoa[i].nome.equals(pesquisa_nome)) {
				achou = true;
				break;
			}
		}
		
		if(achou) {
			System.out.println("cliente com numero de cadastro "+ (i+1) +" encontrado");
			System.out.println("nome: " + pessoa[i].nome);
			System.out.println("endereco: " + pessoa[i].endereco);
			System.out.println("telefone: " + pessoa[i].telefone);
			limpatela(1);
			System.out.println("deseja atualizar os dados do cliente?(s/n)");
			char atualiza = get.next().charAt(0);
			if(atualiza == 's') {
				System.out.println("nome do " + (i + 1) + "º cliente:");
				pessoa[i].nome = get.next();
				System.out.println("endereco do " + (i + 1) + "º cliente:");
				pessoa[i].endereco = get.next();
				System.out.println("telefone do " + (i + 1) + "º cliente:");
				pessoa[i].telefone = get.next();
			}
		}else {
			System.out.println("Cliente não encontrado!");
		}
			
	}
	
	public static void entrada_de_produtos() {
		
		System.out.println("Informe a quantidade de produtos a serem cadastrados");
		int quantdepro= get.nextInt();
		
//		limpatela(10);
		for(int i = 0; i < (quantdepro + total_pro_cadastrados); i++) {
			
			if (produto[i].nome.equals("padrao")) {
				
				System.out.println("Informe os dados do " + (i + 1) + "º produto a ser cadastrado: ");
				System.out.println("nome: ");
				produto[i].nome = get.next(); 
			
				System.out.println("descricao do produto: ");
				produto[i].descricao = get.next();
			
				System.out.println("preco ");
				produto[i].preco = get.nextFloat();
			
				System.out.println("percentual de lucro: ");
				produto[i].porcentlucro = get.nextFloat();
			
				System.out.println("quantidade do produto:");
				produto[i].quantidade = get.nextInt();
			}
			
		}
		total_pro_cadastrados += quantdepro;
	}
	
	public static void busca_de_produtos() {
		
		boolean achou = false;
		int i;
		
		System.out.println("Qual o nome do produto que deseja pesquisar? ");
		String pesquisa_nome = get.next();
		
		for(i = 0; i < TOTAL_DE_PRODUTOS; i++) {
			if (produto[i].nome.equals(pesquisa_nome)) {
				achou = true;
				break;
			}
		}
		if(achou) {
			System.out.println("Produto com numero de cadastro "+ (i+1) +" encontrado");
			System.out.println("Nome: " + produto[i].nome);
			System.out.println("Descricao: " + produto[i].descricao);
			System.out.println("Preco: " + produto[i].preco);
			System.out.println("Porcetlucro: " + produto[i].porcentlucro);
			System.out.println("Quantidade em estoque: " + produto[i].quantidade);
			limpatela(2);
			System.out.println("deseja atualizar os dados do produto? (s/n)");
			char atualiza = get.next().charAt(0);
			if(atualiza == 's') {
				System.out.println("Nome: ");
				produto[i].nome = get.next(); 
				
				System.out.println("Descricao: ");
				produto[i].descricao = get.next();
				
				System.out.println("Preco: ");
				produto[i].preco = get.nextFloat();
				
				System.out.println("Percentual de lucro: ");
				produto[i].porcentlucro = get.nextFloat();
				
				System.out.println("Quantidade: ");
				produto[i].quantidade = get.nextInt();
			}
		}else {
			System.out.println("Produto não encontrado!");
		}
	}
	
	public static void registro_vendas() {
		boolean continuar = true;
		
		if (total_cli_cadastrados > 0) {
			System.out.println("Digite o numero de cadastro correspondente ao comprador:");
			for(int i = 0; i < total_cli_cadastrados; i++) {
				System.out.println("(" + (i + 1) + ") " + pessoa[i].nome);
			}
			
			int x = get.nextInt();
			while(continuar){
				System.out.println("Qual produto o cliente ira levar?");
				System.out.println("nome ------------------------------ quantidade");
				for(int i = 0; i < total_pro_cadastrados; i++) {
					System.out.println("(" + (i + 1) + ") " + produto[i].nome + " ------------------------------ " + produto[i].quantidade);
				}
				int y = get.nextInt();
			
				System.out.println("Quantas unidades o cliente vai levar?");
				
				int quantos = get.nextInt();
				
				if(produto[y-1].quantidade >= quantos){
					produto[y-1].quantidade -= quantos;
				}else {
					System.out.println("Quantidade indisponivel!");
				}
				
				System.out.println("Deseja cadastrar uma nova venda para esse mesmo cliente? (s/n)");
				char opc = get.next().charAt(0);
				if(opc == 'n') {
					continuar = false;
				}
				}
		}
		else {
			System.out.println("Sem clientes cadastrados...");
		}
	}
	
	public static void lista_de_produtos() {
		
		if (total_pro_cadastrados > 0) {
			
			for(int i = 0; i < total_pro_cadastrados; i++) {
				System.out.println(produto[i].nome + " ------------------------------ " + produto[i].quantidade);
			}
			
		}
		else {
			System.out.println("Sem protudos cadastrados...");
		}
	}
	
	static public void limpatela(int x) 
	{
		for(int i = 0; i < x; i++)
		System.out.println();
	}
	
	static public void cadastro_cli_aleatorio(){
		
		pessoa[0].nome = "kevin";
		pessoa[1].nome = "ana";
		pessoa[2].nome = "Roberta";
		pessoa[3].nome = "Lucas";
		pessoa[4].nome = "Alberto";
		pessoa[5].nome = "Rodrigo";
		pessoa[6].nome = "Maria";
		pessoa[7].nome = "Carla";
		pessoa[8].nome = "Beatriz";
		pessoa[9].nome = "Andreia";
		
		for (int i = 0; i < 10; i++) {
			pessoa[i].endereco = "CRS504";
			pessoa[i].telefone = "61999484377";
		}
		total_cli_cadastrados = 10;
	}
	
	static public void cadastro_pro_aleatorio() {
		
		Random gera_numero = new Random();
		
		produto[0].nome = "Guarda-chuva";
		produto[1].nome = "Bola";
		produto[2].nome = "Celular";
		produto[3].nome = "Calculadora";
		produto[4].nome = "Teclado";
		produto[5].nome = "Frigideira";
		produto[6].nome = "Geladeira";
		produto[7].nome = "Monitor";
		produto[8].nome = "Kalimba";
		produto[9].nome = "Trompete";
		
		for (int i = 0; i < 10; i++) {
			produto[i].descricao = "Melhor custo beneficio do mercado, pode confiar";
			produto[i].preco = (gera_numero.nextFloat()) * 100;
			produto[i].porcentlucro = (gera_numero.nextFloat()) * 100;
			produto[i].quantidade = gera_numero.nextInt(100);
		}
		
		total_pro_cadastrados = 10;
	}
	

}
