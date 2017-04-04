package DAO;
//Classes necessárias para uso de Banco de dados //
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Início da classe de conexão//
public class ConexaoMySQL {
	public static String status = "Não conectou...";

	// Método Construtor da Classe//
	public ConexaoMySQL()
	{}

	// Método de Conexão//
	public static Connection getConexaoMySQL(){
		Connection connection = null; //atributo do tipo Connection
		try {
			// Carregando o JDBC Driver padrão
			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);

			//ENDEREÇO DO DB
			String url = "jdbc:mysql://200.18.65.9:3306/dimensionamento01";
			//USER DO DB
			String username = "dimensionamento";  
			//SENHA
			String password = "p4ss";
			
			connection = DriverManager.getConnection(url, username, password);
			
			
			//Testa sua conexão//  
			if (connection != null) {
				status = ("CONECTADO");
			}
			else {
				status = ("NÃO FOI POSSÍVEL CONECTAR");
			}
			
			return connection;
			
		}
	    catch(Exception e) {
	    	
	    	System.out.println("ERRO: Não conectado");
	    	
	    	return null;
	    	
	    }

	}

	// Método que retorna o status da sua conexão//
	public static String statusConection() {
		return status;
	}

	// Método que fecha sua conexão//
	public static boolean FecharConexao() {

		try {

			ConexaoMySQL.getConexaoMySQL().close();

			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	// Método que reinicia sua conexão//
	public static Connection ReiniciarConexao() {
		FecharConexao();
		return ConexaoMySQL.getConexaoMySQL();
	}
	
	
	public static void main(String[] args)
	{
		
		ConexaoMySQL.getConexaoMySQL();
		System.out.println(ConexaoMySQL.status);
		
		
	}
	

}
