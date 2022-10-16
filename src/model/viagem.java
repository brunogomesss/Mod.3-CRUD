package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class viagem
{
	
	private int id_viagem;

	private String destino;
	
	private String tipo_transporte;
	
	private LocalDate data_ida;
	
	private LocalDate data_volta;
	
	private String local_ida;
	
	private double valor_viagem;
	
	public viagem () {
	}

	public viagem(int id_viagem, String destino, String tipo_transporte, LocalDate data_ida, LocalDate data_volta,
			String local_ida, double valor_viagem) {
		super();
		this.id_viagem = id_viagem;
		this.destino = destino;
		this.tipo_transporte = tipo_transporte;
		this.data_ida = data_ida;
		this.data_volta = data_volta;
		this.local_ida = local_ida;
		this.valor_viagem = valor_viagem;
	}

	public int getId_viagem() {
		return id_viagem;
	}

	public void setId_viagem(int id_viagem) {
		this.id_viagem = id_viagem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getTipo_transporte() {
		return tipo_transporte;
	}

	public void setTipo_transporte(String tipo_transporte) {
		this.tipo_transporte = tipo_transporte;
	}

	public LocalDate getData_ida() {
		return data_ida;
	}

	public void setData_ida(LocalDate data_ida) {
		this.data_ida = data_ida;
	}

	public LocalDate getData_volta() {
		return data_volta;
	}

	public void setData_volta(LocalDate data_volta) {
		this.data_volta = data_volta;
	}

	public String getLocal_ida() {
		return local_ida;
	}

	public void setLocal_ida(String local_ida) {
		this.local_ida = local_ida;
	}

	public double getValor_viagem() {
		return valor_viagem;
	}

	public void setValor_viagem(double valor_viagem) {
		this.valor_viagem = valor_viagem;
	}
	 
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	}