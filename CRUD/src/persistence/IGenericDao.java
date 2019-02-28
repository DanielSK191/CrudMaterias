package persistence;

import java.sql.Connection;
import java.sql.SQLException;

public interface IGenericDao {
	
	public Connection getconnection() throws ClassNotFoundException, SQLException;
	
}
