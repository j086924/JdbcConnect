package example.dao.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private String driverClassName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf-8";
	private String userName = "root";
	private String password = "123456";
	
	private static ConnectionFactory connectionFactory=null;

	private ConnectionFactory() {
		
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public  Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url, userName, password);
		
	}
	
	public static ConnectionFactory getInstance()
	{   
		if (null==connectionFactory) {
			connectionFactory=new ConnectionFactory();
		}
		return connectionFactory;
		
	}
	
	

}
