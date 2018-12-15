package main.java.com.nure.usermanagement.db;


import main.java.com.nure.usermanagement.User;

import java.io.IOException;
import java.util.Properties;

public abstract class DaoFactory {
    protected static final String USER_DAO = "dao.com.nure.usermanagement.db.UserDao";
    private static final String DAO_FACTORY = "dao.factory";
    protected static Properties properties;

    private static DaoFactory instance;

    static {
        properties = new Properties();
        try {
            properties.load(DaoFactory.class.getClassLoader().getResourceAsStream("settings.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized DaoFactory getInstance() {
        if (instance == null){
            try {
                Class factoryClass = Class.forName(properties
                        .getProperty(DAO_FACTORY));
                instance = (DaoFactory) factoryClass.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }

    protected DaoFactory() throws IllegalAccessException, InstantiationException {
    }

    public static void init(Properties prop) {
        properties = prop;
        instance = null;
    }



    protected ConnectionFactory getConnectionFactory() {
        return new ConnectionFactoryImpl(properties);
    }

    public abstract UserDao getUserDao();
}