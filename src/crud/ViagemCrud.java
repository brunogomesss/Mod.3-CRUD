package crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import dao.ViagemDAO;
import modelo.viagem;

public class ViagemCrud {

	public static void main(String[] args) {
		
		ViagemDAO viagensDAO = new ViagemDAO();
		
		Scanner input = new Scanner(System.in);
		
		int opcao = 0;
		int posicao = 0;
		
		int id = 0;
		String destino = "";
		String ida = "";
		String volta="";
		String embarque="";
		String valor="";
		String transporte="";
		
		
		List<viagem> viagem = new ArrayList<viagem>();
		
		//Menu
		
		do {
			System.out.println("---- CRUD VIAGEM ----");
			System.out.println("1 - Cadastrar Viagem ");
			System.out.println("2 - Consultar Viagem");
			System.out.println("3 - Deletar Viagem");
			System.out.println("4 - Atualizar Viagem");
			System.out.println("0 - Sair");
			
			opcao = input.nextInt();
			
			switch (opcao) {
			case 1:
				viagem viagens = new viagem();
				
				System.out.println("**Cadastrar Viagem**");
				System.out.println("Digite o destino:");
				destino = input.nextLine();
				viagens.setDestino(destino);	
				
				System.out.println("Digite a Data de Partida:");
				ida = input.nextLine();
				viagens.setData_partida(ida);
				
				System.out.println("Digite a Data de Volta:");
				volta = input.nextLine();
				viagens.setData_volta(volta);
				
				System.out.println("Digite seu Local de Embarque:");
				embarque = input.nextLine();
				viagens.setLocal_partida(embarque);
				
				System.out.println("Digite o valor da Viagem:");
				valor = input.nextLine();
				viagens.setValor_viagem(valor);
				
				System.out.println("Digite o tipo de Transporte:");
				transporte = input.nextLine();
				viagens.setTipo_transporte(transporte);
				
				
				ViagemDAO.save(viagens);
				
				System.out.println("\n**Cliente Cadastrado**\n");
				break;
			case 2:
				for (viagem a : viagensDAO.getViagem()) {
					System.out.println("Id: " + a.getId_viagem() + ", Destino: " + a.getDestino() + ", Data ida: " + a.getData_partida() + ", Data Volta: " + a.getData_volta() + ", Embarque: " + a.getLocal_partida() + ", Valor da Viagem: " + a.getValor_viagem() + ", Tipo de transporte: " + a.getTipo_transporte());
				}
				
				System.out.println("*Consulta Finalizada*");
				break;
			case 3:
				System.out.println("ID para exclusão: ");
				posicao = input.nextInt();
				
				viagensDAO.deleteById(posicao);
				System.out.println("Viagem Excluído");
				break;
			case 4:
				System.out.println("**Atualizando cadastro da Viagem**");
				System.out.println("Digite o Id da viagem:");
				id = input.nextInt();
				System.out.println("Digite o novo Destino:");
				destino = input.nextLine();
				System.out.println("Digite a nova Data de partida:");
				ida = input.nextLine();
				System.out.println("Digite a nova Data de volta:");
				volta = input.nextLine();
				System.out.println("Digite o novo Local de Embarque:");
				embarque = input.nextLine();
				System.out.println("Digite o novo valor da Viagem:");
				valor = input.nextLine();
				System.out.println("Digite o novo Tipo de Transporte:");
				transporte = input.nextLine();
				
				
				viagem viagens1 = new viagem(id, destino,ida, volta, embarque, valor, transporte);
				viagensDAO.update(viagens1);
				break;				
			
			default:
				System.out.println(opcao != 0 ? "\n Opção inválida, tente novamente. \n" : "");	
				break;
			}
		} while (opcao != 0);
		input.close();
		System.out.println("*Finalizado");
	}

}