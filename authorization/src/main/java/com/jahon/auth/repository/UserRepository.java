package com.jahon.auth.repository;

import com.jahon.auth.model.Login;
import com.jahon.auth.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private static final Logger log = LoggerFactory.getLogger(UserRepository.class);
    private static final String SELECT_USERS = "SELECT * FROM USERS";
    private static final String INSERT_USER = "INSERT INTO USERS(login, password, first_name, last_name, email) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_USER_BY_LOGIN = "SELECT password FROM USERS WHERE login = ?";
    private static final String USER_ROLE = "SELECT r.role_name FROM users as u INNER JOIN roles as r ON r.id = u.role_id WHERE u.login = ?";

    @Autowired
    private DataSource dataSource;


    public void insertUser(User user) throws SQLException {
        log.debug("Start insert user {} to DB", user.getLogin());
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstm = conn.prepareStatement(INSERT_USER)) {
            pstm.setString(1, user.getLogin());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getFirstName());
            pstm.setString(4, user.getLastName());
            pstm.setString(5, user.getEmail());
            pstm.executeUpdate();
        }
        log.debug("End insert user {} to DB", user.getLogin());
    }


    public boolean isLogged(Login login) throws SQLException {
        log.debug("Start check user {}", login.getLogin());

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstm = conn.prepareStatement(GET_USER_BY_LOGIN)) {
            pstm.setString(1, login.getLogin());

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                String password = rs.getString(1);
                boolean isLogged = password.equals(login.getPassword());
                log.debug("End check user {}. Is logged {}", login.getLogin(), isLogged);
                return isLogged;
            } else {
                log.debug("End check user {}. User not found", login.getLogin());
                return false;
            }

        }
    }


    public String getUserRole(String login) throws SQLException {
        log.debug("Start find role of user {}", login);
        String role = null;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstm = conn.prepareStatement(USER_ROLE)
        ) {
            pstm.setString(1, login);

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                role = rs.getString(1);
            } else {
                throw new SQLException("Not found role for user " + login);
            }
        }

        log.debug("End find role of user {}. The role is {}", login, role);

        return role;
    }


    public List<User> getAllUsers() throws SQLException {

        List<User> users = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(SELECT_USERS)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                User user = new User(id, login, password, firstName, lastName, email);
                users.add(user);
            }

        }

        return users;
    }

}
