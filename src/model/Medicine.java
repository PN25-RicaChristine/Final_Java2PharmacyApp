/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.logging.Logger;

/**
 *
 * @author debuayanri_sd2022
 */
public class Medicine {

    public String drugName;
    public String genericName;
    public String brandName;
    public int drugAvailability;
    public double drugPrice;
    public String expirationDate;
    public String manufacturedDate;
    public String manufacturer;
    public String category;
    public String drugID;

    public Medicine(String drugID, String drugName, String genericName, String brandName, int drugAvailability, double drugPrice, String expirationDate, String manufacturedDate, String manufacturer, String category) {
        this.drugID = drugID;
        this.drugName = drugName;
        this.genericName = genericName;
        this.brandName = brandName;
        this.drugAvailability = drugAvailability;
        this.drugPrice = drugPrice;
        this.expirationDate = expirationDate;
        this.manufacturedDate = manufacturedDate;
        this.manufacturer = manufacturer;
        this.category = category;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(double drugPrice) {
        this.drugPrice = drugPrice;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(String manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDrugID() {
        return drugID;
    }

    public void setDrugID(String drugID) {
        this.drugID = drugID;
    }

    public int getDrugAvailability() {
        return drugAvailability;
    }

    public void setDrugAvailability(int drugAvailability) {
        this.drugAvailability = drugAvailability;
    }

}
