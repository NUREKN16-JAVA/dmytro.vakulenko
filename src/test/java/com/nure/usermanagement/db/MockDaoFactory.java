package test.java.com.nure.usermanagement.db;

import com.mockobjects.dynamic.Mock;
import main.java.com.nure.usermanagement.db.DaoFactory;
import main.java.com.nure.usermanagement.db.UserDao;


public class MockDaoFactory extends DaoFactory {

    private Mock mockUserDao;

    public MockDaoFactory() throws InstantiationException, IllegalAccessException {
        super();
        mockUserDao = new Mock(UserDao.class);
    }

    public Mock getMockUserDao() {
        return mockUserDao;
    }

    @Override
    public UserDao getUserDao() {
        return (UserDao) mockUserDao.proxy();
    }
}
