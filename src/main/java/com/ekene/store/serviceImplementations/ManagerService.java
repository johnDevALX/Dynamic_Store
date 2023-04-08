package com.ekene.store.serviceImplementations;
import com.ekene.store.dao.CashierDao;
import com.ekene.store.dao.ManagerDao;
import com.ekene.store.dao.ProductDao;
import com.ekene.store.enumerations.Role;
import com.ekene.store.interfaces.ManagerInterface;
import com.ekene.store.models.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class ManagerService implements ManagerInterface {
    CashierDao cashierDao = new CashierDao();
    ProductDao productDao = new ProductDao();
    ManagerDao managerDao = new ManagerDao();

    @Override
    public Cashier hireACashier(Applicant applicant, int num) {
        Random random = new Random();
        num = random.nextInt(5);
        Cashier cashier = null;
        if (applicant.getAge() > 18 && applicant.getAge() < 30){
            if (applicant.getYearsOfExperience() > 3){
                cashier = new Cashier();
                cashier.setFirstName(applicant.getFirstName());
                cashier.setLastName(applicant.getLastName());
                cashier.setEmail(applicant.getEmail());
                cashier.setAge(applicant.getAge());
                cashier.setGender(applicant.getGender());
                cashier.setSalary(75000);
                cashier.setRole(applicant.getRoleAppliedFor());
                cashier.setId(num);
                cashier.setSuperId(111);
                try {
                    if (cashierDao.registerCashier(cashier) == 1){
                        Manager.CASHIER_LIST.add(cashier);
                        Manager.CASHIER_LIST.forEach(System.out::println);
                        System.out.println("#############Successfully Hired#################");
                        System.out.println(cashier);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.print("PROMPT ---> ");
                System.out.println("Sorry, You Are Inexperienced, Try Out Our Other Jobs Within Your Experience Level!");
            }
        }else {
            System.out.print("PROMPT ---> ");
            System.out.println("Sorry, Unacceptable Age!");
        }
        return cashier;
    }

    @Override
    public String fireACashier(String name) {
        if (findPositionOfCashier(name) > -1){
            Cashier cashier = Manager.CASHIER_LIST.get(findPositionOfCashier(name));
            try {
                if (cashierDao.fireCashier(name, cashier.getId())){
                    Manager.CASHIER_LIST.remove(cashier);
                    System.out.println("#######Prompt-----> " + name + " Your Contract Has Been Terminated");
                    return "Successful!!!";
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return "Unsuccessful!";
    }

    public void createProduct(Product product){
        productDao.createProduct(product);
        System.out.println("Product Created In Database Successfully");
    }

    public List<Product> printAllProduct(){
        return productDao.displayProduct();
    }

    private int findPositionOfCashier(String firstName){
        for (Cashier cashier: Manager.CASHIER_LIST) {
            if (cashier.getFirstName().equalsIgnoreCase(firstName) || cashier.getLastName().equalsIgnoreCase(firstName)){
                return Manager.CASHIER_LIST.indexOf(cashier);
            }
        }
        return -1;
    }
    public static boolean cLogin(String name, int id) throws SQLException, ClassNotFoundException {
        if (CashierDao.cashierLogin(name, id)){
            System.out.println("Login Successful");
            System.out.println(name + " from serv");
            return true;
        } else {
            System.out.println("Login Unsuccessful");
        }
        return false;
    }

    public boolean mLogin(String name, int id){
        if (managerDao.mLogin(name, id)){
            System.out.println("Login Successful");
            System.out.println(name + " from serv");
            return true;
        } else {
            System.out.println("Login Unsuccessful");
        }
        return false;
    }
}
