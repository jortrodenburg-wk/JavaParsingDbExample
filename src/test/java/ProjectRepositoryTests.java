import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.workiva.satools.parsingdb.helpers.databaseconnector.ParsingDatabaseConnection;
import com.workiva.satools.parsingdb.models.Project;
import com.workiva.satools.parsingdb.repositories.ProjectRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DriverManager.class)
public class ProjectRepositoryTests {
    @InjectMocks
    private ParsingDatabaseConnection dbConnection;

    @Mock
    private DataSource dataSource;

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement statement;

    @Mock
    private ResultSet resultSet;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProjectById_Success() throws SQLException, ClassNotFoundException {
        org.junit.Assert.assertNotNull(dataSource);

        PowerMockito.mockStatic(DriverManager.class);

        when(connection.prepareStatement(any(String.class))).thenReturn(statement);
        when(DriverManager.getConnection(any(String.class), any(String.class), any(String.class))).thenReturn(connection);

        Project project = new Project();
        project.ProjectID = 921;

        when(resultSet.getString(1)).thenReturn(project.AccountID);
        when(statement.executeQuery()).thenReturn(resultSet);

        ProjectRepository projectRepository = new ProjectRepository();
        List<Project> result = projectRepository.getProjectsById(project.ProjectID);

        org.junit.Assert.assertNotNull(result);
        org.junit.Assert.assertEquals(1, result.size());
        org.junit.Assert.assertEquals(project.ProjectID, result.get(0).ProjectID);
    }
}
