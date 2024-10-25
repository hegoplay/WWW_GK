package connectDB;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectDB {
	public  EntityManagerFactory entityFactory;
	public  EntityManager manager;
	public static final String split = "_";
	
	public static ConnectDB instance = new ConnectDB();
	
	private ConnectDB() {
		entityFactory = Persistence.createEntityManagerFactory("jpa-hibernate-tuan05");
		manager = entityFactory.createEntityManager();
	}
	public void closeConnection() {
		manager.close();
		entityFactory.close();
	}
	public void inputValues() {
		
	}
}