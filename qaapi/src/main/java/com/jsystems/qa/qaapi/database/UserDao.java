package com.jsystems.qa.qaapi.database;

import com.jsystems.qa.qaapi.model.user.UserDb;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static UserDb getOneById(Long id) {
        String sql = "select * from testuser where id = " + id;

        UserDb userDb = new UserDb();
        try {
            Statement statement = DatabaseConnector.getConnection().createStatement();
            ResultSet wynik = statement.executeQuery(sql);

            while (wynik.next()) {
                userDb.setId(wynik.getLong(1));
                userDb.setName(wynik.getString(2));
                userDb.setSurname(wynik.getString(3));
            }
            wynik.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDb;
    }

    public static List<UserDb> getAllUsers() {
        List<UserDb> userDbs = new ArrayList<>();
        String sql = "select * from testuser";
        ResultSet wynik = null;
        Statement statement = null;

        try {
            statement = DatabaseConnector.getConnection().createStatement();
            wynik = statement.executeQuery(sql);

            while (wynik.next()) {
                UserDb userDb = new UserDb(wynik.getLong(1), wynik.getString(2), wynik.getString(3));
                userDbs.add(userDb);
            }

        } catch (Exception e) {

        } finally {
            try {
                wynik.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userDbs;
    }

    public static void SaveUser(UserDb userDb) {
        String sql = "insert into testuser (id, name, surname) values (" + userDb.getId() +
                ", '" + userDb.getName() + "', '" + userDb.getSurname() + "')";
        try {
            Statement statement = DatabaseConnector.getConnection().createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


