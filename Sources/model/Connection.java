package model;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.TransactionManager;

/**
 * The connection to database, structured according to the singleton pattern
 * with lazy initialization.
 * 
 * @author Daniele Cuomo
 */
public class Connection{

    public static EntityManagerFactory EMF;
    public static EntityManager EM;
    public static TransactionManager TM;

    public static MongoClient MC;
    public static MongoDatabase MD;

    private Connection(){} 

    private static class Container{
      private final static Connection INSTANCE = new Connection();
    }

    /**
     * Access point to connection
     * 
     * @return the corresponding connection
     */
    public static Connection getInstance(){
      return Container.INSTANCE;
    }
}