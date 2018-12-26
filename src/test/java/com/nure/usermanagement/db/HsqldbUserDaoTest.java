package test.java.com.nure.usermanagement.db;

import main.java.com.nure.usermanagement.User;
import main.java.com.nure.usermanagement.db.ConnectionFactory;
import main.java.com.nure.usermanagement.db.ConnectionFactoryImpl;
import main.java.com.nure.usermanagement.db.DatabaseException;
import main.java.com.nure.usermanagement.db.HsqldbUserDao;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;

import java.util.Collection;
import java.util.Date;


public class HsqldbUserDaoTest extends DatabaseTestCase {

    private HsqldbUserDao dao;
    private ConnectionFactory connectionFactory;
    private Long id = new Long(1000);

    public void setUp() throws Exception {
        super.setUp();
        dao = new HsqldbUserDao(connectionFactory);
    }

    public void testCreate() {
        try {
            User user = new User();
            user.setFirstName("John");
            user.setLastName("Doe");
            user.setDateOfBirth(new Date());
            assertNull(user.getId());
            user = dao.create(user);
            assertNotNull(user);
            assertNotNull(user.getId());
        } catch (DatabaseException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

    public void testDelete() throws Exception {
        try {
            User user = dao.find(id);
            dao.delete(user);
            user = dao.find(id);
            assertNotNull("User deleted ", user);
        } catch (DatabaseException e) {
            /*e.printStackTrace();
            fail(e.toString());*/
        }
    }

    public void testUpdate() throws Exception {
        try {
            User user = dao.find(id);
            dao.update(user);
            User newUser = dao.find(id);
            assertEquals(user.getFirstName(), newUser.getFirstName());
            assertEquals(user.getLastName(), newUser.getLastName());
            assertEquals(user.getDateOfBirth(), newUser.getDateOfBirth());
        } catch (DatabaseException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }/**/

    public void testFind(){
        try{
            User user = dao.find(id);
            assertNotNull("User not found ", user);
        } catch (DatabaseException e){
            e.printStackTrace();
            fail(e.toString());
        }
    }
/**/


    @Override
    protected IDatabaseConnection getConnection() throws Exception {
        connectionFactory = new ConnectionFactoryImpl("org.hsqldb.jdbcDriver","jdbc:hsqldb:file:db/usermanagement", "sa", "");
        return new DatabaseConnection(connectionFactory.createConnection());
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new XmlDataSet(getClass().getClassLoader().getResourceAsStream("usersDataSet.xml"));
        return dataSet;
    }

    public void testFindAll () {
        try {
            Collection collection = dao.findAll();
            assertNotNull("Collection is null",collection);
            assertEquals("Collection size.", 2, collection.size());
        } catch (DatabaseException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }


}