/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author debuayanri_sd2022
 */
public class Customer implements UserInvolved {

    private String name;
    private String address;
    private String username;
    private String password;
    private int age;
    public int customerIDno;
    public String id;
    private static int count;

    public Customer() {

    }

    public Customer(String name, String address, String username, String password, int age) {
        this.name = name;
        this.address = address;
        this.username = username;
        this.password = password;
        this.age = age;
        count++;
        customerIDno = count;
        id = "CSD2022-" + customerIDno;
    }

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSenior() {
        return age >= 60;
    }

    public boolean isAdult() {
        return age >= 18 && age < 60;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return "CSD2022-" + customerIDno;
    }

    @Override
    public String toString() {
        return "CUSTOMER NAME: " + name + " ADDRESS: " + address + " AGE: " + age + " CUSTOMER ID: " + id;
    }

}
