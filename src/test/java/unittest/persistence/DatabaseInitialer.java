package unittest.persistence;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileInputStream;

/**
 * User: tienhd
 * Date: 8/14/13
 * Time: 5:33 PM
 */
public class DatabaseInitialer extends JdbcDaoSupport
{
    public static final String JDBC_DRIVER = org.postgresql.Driver.class.getName();
    public static final String JDBC_URL = "jdbc:postgresql://localhost:5432/tictactoe";

    public static final String JDBC_USERNAME = "tictactoe_user";
    public static final String JDBC_PASSWORD = "123456";

    private IDatabaseTester databaseTester;
    private static final String resourcePath = new File("").getAbsolutePath() + "/src/test/resources";

    @PostConstruct
    public void load() throws Exception
    {
        cleanInsertData();
    }

    public void cleanInsertData() throws Exception
    {
        databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        IDataSet dataSet = importData();
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    public IDataSet importData() throws Exception
    {
        String dataFile = resourcePath + "/data.xml";
        return new FlatXmlDataSetBuilder().build(new FileInputStream(dataFile));
    }

    @PreDestroy
    public void clean() throws Exception
    {
        databaseTester.setTearDownOperation(DatabaseOperation.DELETE);
        databaseTester.onTearDown();
    }
}
