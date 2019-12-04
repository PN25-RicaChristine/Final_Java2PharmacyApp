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
public class Pharmacist implements UserInvolved {

    private String name;
    private String address;
    private String username;
    private String password;
    public int pharmacistID;
    public String id;
    private static int count;

    public Pharmacist() {

    }

    public Pharmacist(String name, String address, String username, String password) {
        this.name = name;
        this.address = address;
        this.username = username;
        this.password = password;
        count++;
        pharmacistID = count;
        id = "PhD-SD2022-" + pharmacistID;
    }

    public String getId() {
        return "PhD-SD2022-" + pharmacistID;
    }

    public Pharmacist(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "Pharmacist: " + name + ",Pharm.D. Pharmacist ID: "+ id;
    }
}
