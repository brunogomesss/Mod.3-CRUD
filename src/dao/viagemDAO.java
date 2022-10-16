package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionMySql;
import modelo.viagem;

public class viagemDAO {
	
	//Create
	
	public static void save(viagem viagens) {
		
	String sql = "INSERT INTO viagem (destino, data_ida, data_volta, local_partida, valor_viagem, tipo_transporte) VALUES (?, ?, ?, ?, ?, ?)";
		
		
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionMySql.createConnectionMySQL();
		
		pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, viagens.getDestino());
		pstm.setString(2, viagens.getData_partida());
		pstm.setString(3,  viagens.getData_ida());
		pstm.setString(4, viagens.getLocal_partida());
		pstm.setString(5, viagens.getValor_viagem());
		pstm.setString(6, viagens.getTipo_transporte());
		
		
		pstm.execute();
		
	}catch (Exception e) {
		
		e.printStackTrace();
				
	} finally {
		
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	}
	
	//Read
	
	public List<viagem> getViagem() {
		
		String sql = "SELECT * FROM viagem";
		
		List<viagem> viagem = new ArrayList<viagem>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySql.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				viagem viagens = new viagem();
				
				viagens.setId_viagem(rset.getInt("id_viagem"));
				viagens.setDestino(rset.getString("destino"));
				viagens.setData_partida(rset.getString("data_ida"));
				viagens.setData_volta(rset.getString("data_volta"));
				viagens.setLocal_partida(rset.getString("local_partida"));
				viagens.setValor_viagem(rset.getString("valor_viagem"));
				viagens.setTipo_transporte(rset.getString("tipo_transporte"));
				
				viagem.add(viagens);
			}
			
		} catch (Exception e){
			
			e.printStackTrace();
			
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return viagem;
		
		
	}
	//Update
	public void update(viagem viagens) {
		
		String sql = "UPDATE viagem SET destino = ?, data_ida = ?, data_volta, local_partida, valor_viagem, tipo_transporte WHERE id_viagem = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySql.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, viagens.getDestino());
			pstm.setString(2, viagens.getData_ida());
			pstm.setString(3, viagens.getData_volta());
			pstm.setString(4, viagens.getLocal_partida());
			pstm.setString(5, viagens.getValor_viagem());
			pstm.setString(6, viagens.getTipo_transporte());
			pstm.setInt(7, viagens.getId_viagem());
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			}
	}
	
	//Delete
	public void deleteById(int id) {
		
		String sql = "DELETE FROM viagem WHERE id_viagem = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySql.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			
			pstm.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			}
		
	}
	
}