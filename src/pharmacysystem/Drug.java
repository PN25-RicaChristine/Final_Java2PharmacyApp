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
public abstract class Drug {

 

    abstract String getGenericName();

    abstract void setGenericName(String genericName);

    abstract String getBrandName();

    abstract void setBrandName(String brandName);

    abstract String getExpirationDate();

    abstract void setExpirationDate(String expirationDate);

    abstract String getManufacturedDate();

    abstract void setManufacturedDate(String manufacturedDate); 

    abstract int getDrugAvailability();

    abstract void setDrugAvailability(int drugAvailibility);

    abstract double getDrugPrice();

    abstract void setDrugPrice(double drugPrice);

    abstract int getDrugID();

    abstract void setDrugID(int drugID);

    abstract String getDrugName();

    abstract void setDrugName(String drugName);

    abstract String getManufacturer();

    abstract void setManufacturer(String manufacturer);
}
