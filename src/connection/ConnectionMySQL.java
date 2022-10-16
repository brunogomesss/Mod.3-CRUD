package connection;

import java.sql.Connection;
import java.sql.DriverManager; 
	
	public class ConnectionMySQL {
		puclic static Connection createConnectionMySQL() throws Exception {
			
			//Carregar a classe pelo JVM
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//conexao banco
			Connection connection = DriverManager.getConnection("jdbc:mysql://3306/AgenciaBG?user=root&password=");
			
			return connection;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		Connection con= createConnectionMySQL();
		
		if (con!=null) {
			System.out.println(con + "\n** Conexao bem sucedida**\n");
			
			con.close();
		}
	}
}
