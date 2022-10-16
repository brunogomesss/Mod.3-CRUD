package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySql;
import modelo.Cliente;

public class ClienteDAO {
	
	//Create
	
	public static void save(cliente clientes) {
		
	String sql = "INSERT INTO cliente (nome_cliente, cpf_cliente, nasc_cliente, email_cliente, contato_cliente, endereco_cliente) VALUES (?, ?, ?, ?, ?, ?)";
		
		
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionMySql.createConnectionMySQL();
		
		pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, clientes.getNome_cliente());
		pstm.setString(2, clientes.getCpf_cliente());
		pstm.setString(3,  clientes.getnasc_cliente());
		pstm.setString(4, clientes.getEmail_cliente());
		pstm.setString(5, clientes.getcontato_cliente());
		pstm.setString(6, clientes.getEndereco_cliente());
		
		
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
	
	public List<cliente> getCliente() {
		
		String sql = "SELECT * FROM cliente";
		
		List<cliente> cliente = new ArrayList<cliente>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySql.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				cliente clientes = new cliente();
				
				clientes.setId_cliente(rset.getInt("id_cliente"));
				clientes.setNome_cliente(rset.getString("nome_cliente"));
				clientes.setCpf_cliente(rset.getString("cpf_cliente"));
				clientes.setNasc_cliente(rset.getString("nasc_cliente"));
				clientes.setEmail_cliente(rset.getString("email_cliente"));
				clientes.setTelefone_cliente(rset.getString("contato_cliente"));
				clientes.setEndereco_cliente(rset.getString("endereco_cliente"));
				
				cliente.add(clientes);
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
		return cliente;
		
		
	}
	//Update
	public void update(cliente clientes) {
		
		String sql = "UPDATE cliente SET nome_cliente = ?, cpf_cliente = ?, nasc_cliente, email_cliente, contato_cliente, endereco_cliente WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySql.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, clientes.getNome_cliente());
			pstm.setString(2, clientes.getCpf_cliente());
			pstm.setString(3, clientes.getNasc_cliente());
			pstm.setString(4, clientes.getEmail_cliente());
			pstm.setString(5, clientes.getcontato_cliente());
			pstm.setString(6, clientes.getEndereco_cliente());
			pstm.setInt(7, clientes.getId_cliente());
			
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
		
		String sql = "DELETE FROM cliente WHERE id_cliente = ?";
		
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