/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacysystem;

/**
 *
 * @author debuayanri_sd2022
 */
public class Headache extends Drug {
  private int drugID;
    private String drugName;
    private String genericName;
    private String brandName;
    private int drugAvailability;
    private double drugPrice;
    private String expirationDate;
    private String manufacturedDate;
    private String manufacturer;

    private static int count;

    public Headache() {
    }

   

    public Headache(String drugName, String genericName, String brandName, int drugAvailability, double drugPrice, String expirationDate, String manufacturedDate, String manufacturer) {
        this.drugName = drugName;
        this.genericName = genericName;
        this.brandName = brandName;
        this.drugAvailability = drugAvailability;
        this.drugPrice = drugPrice;
        this.expirationDate = expirationDate;
        this.manufacturedDate = manufacturedDate;
        this.manufacturer = manufacturer;
        count++;
        drugID = count;
    }
    
    

    @Override
    public String getGenericName() {
        return genericName;
    }

    @Override
    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    @Override
    public String getBrandName() {
        return brandName;
    }

    @Override
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String getExpirationDate() {
        return expirationDate;
    }

    @Override
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String getManufacturedDate() {
        return manufacturedDate;
    }

    @Override
    public void setManufacturedDate(String manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    

    @Override
    public int getDrugAvailability() {
        return drugAvailability;
    }

    @Override
    public void setDrugAvailability(int drugAvailability) {
        this.drugAvailability = drugAvailability;
    }

    @Override
    public double getDrugPrice() {
        return drugPrice;
    }

    @Override
    public void setDrugPrice(double drugPrice) {
        this.drugPrice = drugPrice;
    }

    @Override
    public int getDrugID() {
        return drugID;
    }

    @Override
    public void setDrugID(int drugID) {
        this.drugID = drugID;
    }

    
    @Override
    public String getDrugName() {
        return drugName;
    }

    @Override
    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    
     @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}

