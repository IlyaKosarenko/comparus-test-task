package comparus.test.task.service;

import comparus.test.task.config.DataBaseConfigurationProperties;
import comparus.test.task.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserOrmService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserOrmService.class);

    private final DataBaseConfigurationProperties dataBaseConfigurationProperties;

    private static final String SELECT_ALL_QUERY = "SELECT * FROM %;";

    public UserOrmService(DataBaseConfigurationProperties dataBaseConfigurationProperties) {
        this.dataBaseConfigurationProperties = dataBaseConfigurationProperties;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        for(var source : dataBaseConfigurationProperties.getDatasources()) {
            users.addAll(getUsersFromSource(source));
        }

        return users;
    }

    private List<User> getUsersFromSource(DataBaseConfigurationProperties.DataSourceProperties properties) {
        String pathToTable = String.join(".", properties.getSchema(), properties.getTable());
        String selectQuery = SELECT_ALL_QUERY.replace("%", pathToTable);


        List<User> users = new ArrayList<>();

        try (Connection connection = getNewConnection(properties);
             PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            LOGGER.info("Excecuting SQL: " + selectQuery);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString(properties.getMapping().getId()));
                user.setName(resultSet.getString(properties.getMapping().getName()));
                user.setSurname(resultSet.getString(properties.getMapping().getSurname()));
                user.setUsername(resultSet.getString(properties.getMapping().getUsername()));
                users.add(user);
            }

        } catch (SQLException e) {
            LOGGER.warn("Unable to get users from DB: " + properties.getName(), e);
        }

        return users;

    }





    private Connection getNewConnection(DataBaseConfigurationProperties.DataSourceProperties properties) throws SQLException {

        return DriverManager.getConnection(properties.getUrl(),
                properties.getUsername(),
                properties.getPassword());
    }

}
