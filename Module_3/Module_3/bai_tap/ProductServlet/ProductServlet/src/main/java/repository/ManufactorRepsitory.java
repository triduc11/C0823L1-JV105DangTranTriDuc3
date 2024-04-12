package repository;

import model.Manufactor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManufactorRepsitory implements IManufactorRepository {
    private final static String GET_ALL = "SELECT * FROM manufactor";
    private final static String FIND_BY_NAME = "SELECT * FROM ? WHERE name=?";
    private final static String SAVE = "INSERT INTO manufactor(name) VALUE (?)";
    private final static String LAST_INSERT_ID = "LAST_INSERT_ID()";


    @Override
    public List<Manufactor> findAll() {
        List<Manufactor> manufactorsList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = ConnectDB.getConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                manufactorsList.add(new Manufactor(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return manufactorsList;
    }

    @Override
    public Manufactor findByName(String name) {
        Connection conn = null;
        Manufactor found = null;
        try {
            conn = ConnectDB.getConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1,"product");
            preparedStatement.setString(2,"name");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                found = new Manufactor(id, name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return found;
    }

    @Override
    public boolean save(Manufactor manufactor) {
        Connection conn = null;
        int rowEffected = 0;
        try {
            conn = ConnectDB.getConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement preparedStatement =  conn.prepareStatement(SAVE);
            preparedStatement.setString(1, manufactor.getName());
            rowEffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rowEffected>0;
    }
}

