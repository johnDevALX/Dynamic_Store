package com.ekene.store.dao;

import com.ekene.store.configuration.ConnectionConfig;
import com.ekene.store.models.Manager;
import com.ekene.store.models.Product;

import java.sql.*;

public class ManagerDao {
    public int registerManager(Manager manager) throws ClassNotFoundException {
        Connection connection = ConnectionConfig.getConnection();
        int result = 0;
        String sql = "INSERT INTO manager VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, manager.getId());
            pr.setString(2, manager.getFirstName());
            pr.setString(3, manager.getLastName());
            pr.setString(4, manager.getEmail());
            pr.setString(5, String.valueOf(manager.getGender()));
            pr.setInt(6, manager.getSalary());
            pr.setString(7, String.valueOf(manager.getRole()));
            System.out.println(pr);
            result = pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean mLogin(String name, int mgrId){
        boolean status = false;
        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT firstName, mgrId FROM manager WHERE firstName = ? AND mgrId = ?")){
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, mgrId);
            ResultSet resultSet = preparedStatement.executeQuery();
            status = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

}
