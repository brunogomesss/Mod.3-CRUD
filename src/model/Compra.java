package model;

public class Compra
{
	private int id_cliente;
	private int id_viagem;
	
	public Compra() {
		
	}
	public Compra(int id_cliente, int id_viagem) {
		super();
		this.id_cliente = id_cliente;
		this.id_viagem = id_viagem;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public int getId_viagem() {
		return id_viagem;
	}
	public void setId_viagem(int id_viagem) {
		this.id_viagem = id_viagem;
	}
   
	 
	
}