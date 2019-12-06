/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JFrame;
import javax.swing.JTable;
import model.Medicine;
import model.MedicineDatabase;

/**
 *
 * @author debuayanri_sd2022
 */
public class MedicineController {
    MedicineDatabase mdb = new MedicineDatabase();
    
    public void getAllMed(JTable table){
        mdb.retrieveMedicine(table);
    }
    
    public void addMed(Medicine m, String drug_id, JFrame frame){
        mdb.createMed(m, drug_id, frame);
    }
    
    public void modifyMed(Medicine m){
        mdb.updateMed(m);
    }
    
    public void delMed(String id){
        mdb.deleteMed(id);
    }
}
