package main.java.com.nure.usermanagement.db;

import java.sql.Connection;


public interface ConnectionFactory {
    Connection createConnection() throws DatabaseException;
}
