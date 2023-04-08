package com.ekene.store.dao;

import com.ekene.store.configuration.ConnectionConfig;
import com.ekene.store.models.Cashier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CashierDao {
    public int registerCashier(Cashier cashier) throws ClassNotFoundException {
        int result = 0;
        try {
            PreparedStatement pr = ConnectionConfig.getConnection().
                    prepareStatement("INSERT INTO cashier VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pr.setInt(1, cashier.getId());
            pr.setString(2, cashier.getFirstName());
            pr.setString(3, cashier.getLastName());
            pr.setString(4, cashier.getEmail());
            pr.setInt(5, cashier.getAge());
            pr.setString(6, String.valueOf(cashier.getGender()));
            pr.setInt(7, cashier.getSalary());
            pr.setString(8, String.valueOf(cashier.getRole()));
            pr.setInt(9, cashier.getSuperId());
            result = pr.executeUpdate();
            System.out.println("result of hire cashier: " + result);

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean fireCashier(String name, int employeeId) throws ClassNotFoundException {
        try {
            PreparedStatement pr = ConnectionConfig.getConnection()
                    .prepareStatement("DELETE FROM cashier WHERE firstName = ? AND employeeId = ?");
            pr.setString(1, name);
            pr.setInt(2, employeeId);
            int result = pr.executeUpdate();
            if (result > 0){
                System.out.println("result of fire cashier: " + result);
                return true;
            }
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean cashierLogin(String name, int employeeId) throws ClassNotFoundException, SQLException {
        boolean status = false;
        System.out.println(name + " from dao");
        Connection con = ConnectionConfig.getConnection();
        PreparedStatement pr = con.prepareStatement("SELECT firstName, employeeId FROM cashier WHERE firstName = ? AND employeeId = ?");
        pr.setString(1, name);
        pr.setInt(2, employeeId);
        ResultSet resultSet = pr.executeQuery();
        status = resultSet.next();
//        int row = resultSet.getRow();
//        System.out.println("current row number: " + row);
//        if (row > 0){
//            System.out.println(row);
//            return true;
//        }
//        return false;
        System.out.println(status);
        return status;


//        while (resultSet.next()){
//            String name2 = resultSet.getString(1);
//            int anInt = resultSet.getInt(2);
//            System.out.println(name2);
//            System.out.println(anInt);
//        }
    }
}
