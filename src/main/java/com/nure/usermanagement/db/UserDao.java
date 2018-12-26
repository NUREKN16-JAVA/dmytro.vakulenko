package main.java.com.nure.usermanagement.db;

import main.java.com.nure.usermanagement.User;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import java.util.Collection;


public interface UserDao {
    User create (User user) throws DatabaseException;
    void update (User user) throws DatabaseException;
    void delete (User user) throws DatabaseException;
    User find (Long id) throws DatabaseException;
    Collection findAll() throws DatabaseException;
    void setConnectionFactory(ConnectionFactory connectionFactory);
}
