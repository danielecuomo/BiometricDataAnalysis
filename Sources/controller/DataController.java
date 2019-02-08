package controller;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Persistence;
import javax.persistence.SynchronizationType;
import javax.transaction.SystemException;
import model.Connection;
import model.Entity;

/**
 * This class provides the user with the basic CRUD operations.
 *
 * @author Daniele Cuomo N8601346
 */
public class DataController{

    /**
     * Try accessing a mongo database.
     * 
     * @param db  database name
     * @param ip  host address
     * @param usr username
     * @param pwd password
     * @return    true if the connection is successful, false otherwise
     */
    public static boolean access(String db, String ip, String usr, String pwd) {        
        Map<String, String> persistenceMap = new HashMap<>();

        persistenceMap.put("hibernate.ogm.datastore.database", db);
        persistenceMap.put("hibernate.ogm.datastore.host", ip);
        persistenceMap.put("hibernate.ogm.datastore.username", usr);
        persistenceMap.put("hibernate.ogm.datastore.password", pwd);

        try{
            Connection.EMF = Persistence.createEntityManagerFactory("ogm-jpa-mongo", persistenceMap);
            Connection.EM = Connection.EMF.createEntityManager(SynchronizationType.UNSYNCHRONIZED);
            Connection.TM = com.arjuna.ats.jta.TransactionManager.transactionManager();
            Connection.TM.setTransactionTimeout(3600);
        }
        catch( Exception e ){
            ViewController.showException(e);
            return false;
        }       
        return true;
    }

    /**
     * Make an instance managed and persistence
     * 
     * @param <T> a class with @Entity annotation
     * @param x   entity instance
     * @return    the entity, synchronized with the database
     */
    public static <T extends Entity> T create(T x) {
        try {
            Connection.TM.begin();
            Connection.EM.persist(x);
            Connection.TM.commit();
            return x;
        } catch (Exception e){
            ViewController.showException(e);
            try{ Connection.TM.rollback(); }
            catch (SystemException ex){ }
            return null;
        }
    }    
    
    /**
     * Remove the entity instance
     * 
     * @param <T> a class with @Entity annotation
     */
    public static <T extends Entity> void delete( T x ) {
        try {
            Connection.TM.begin();
            Connection.EM.remove(x);
            Connection.TM.commit();
        } catch (Exception e) {
            ViewController.showException(e);
            try {
                Connection.TM.suspend();
            } catch (SystemException ex) {
            }
        }
    }
    
    public static <T extends Entity> void update(T x, Method m, Object ... args){
        try{ m.invoke(x, args); }
        catch(Exception e){ throw new RuntimeException(e.getMessage()); }
        
        DataController.flush();
    }
    
    /**
     * Get an instance, whose state may be lazily fetched.
     * 
     * @param <T> a class with @Entity annotation
     * @param c   entity class
     * @param id  primary key
     * @return    the found entity instance
     */
    public static <T extends Entity> T getReference(Class<? extends T> c, Object id) {
        return Connection.EM.getReference(c, id);
    }

    /**
     * Synchronize the persistence context to the underlying database.
     */
    public static void flush(){
        try {
            Connection.TM.begin();
            Connection.EM.flush();
            Connection.TM.commit();
        } catch (Exception e) {
            ViewController.showException(e);
            try {
                Connection.TM.suspend();
            } catch (SystemException ex) {
            }
        }
    }
    
    /**
     * Clear the persistence context, 
     * causing all managed entities to become detached.
     */
    public static void clear(){ Connection.EM.clear();}
    
    /**
     * Execute a named query
     * 
     * @param <T> entity type
     * @param namedQuery the name of a query defined in metadata
     * @return result list
     */
    public static <T extends Entity> List<T> execNamedQuery(String namedQuery){
        try{
            Connection.TM.begin();
            List<T> table = Connection.EM.createNamedQuery(namedQuery).getResultList();
            Connection.TM.commit();
            return table;
        }
        catch(Exception e){
            ViewController.showException( e );
            try{ Connection.TM.suspend(); }
            catch(SystemException ex){ }
            return null;
        }
    }
}