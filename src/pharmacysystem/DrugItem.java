/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacysystem;

import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author debuayanri_sd2022
 */
public class DrugItem {

    private Allergies allergies;
    private BodyPain bodypain;
    private Cough cough;
    private Headache headache;

    ArrayList<Allergies> allergiesList = new ArrayList<>();
    ArrayList<BodyPain> bodypainList = new ArrayList<>();
    ArrayList<Cough> coughList = new ArrayList<>();
    ArrayList<Headache> headacheList = new ArrayList<>();
    
    ArrayList<String> allMedList = new ArrayList<>();
    ArrayList<Double> allMedPriceList = new ArrayList<>();
    ArrayList<Integer> allMedStockList = new ArrayList<>();
    ArrayList<String> otherDetails = new ArrayList<>();
    // private int[] allMedPriceStockList;

    Scanner sc = new Scanner(System.in);

    public DrugItem() {
        allergiesList.add(new Allergies("Cetirizine 10Mg Tablet – RiteMed", "Cetirizine", "Ritemed", 100, 20.75, "December 9,2025", "December 9,2018", "Unique Pharmaceutical Laboratories"));
        allergiesList.add(new Allergies("Allerta 10Mg Tablet", "Loratadine", "Allerta", 100, 22.15, "December 9,2025", "December 9,2018", "Amherst Laboratories, Inc."));
        allergiesList.add(new Allergies("ELICA 0.01% CREAM 5GM", "Mometasone Furoate", "Elica", 100, 429.00, "December 9,2025", "December 9,2018", "PT. Schering-Plough Indonesia Tbk."));

        bodypainList.add(new BodyPain("FLANAX 275MG TABLET (9+1)", "Naproxen Sodium", "Flanax", 200, 105.75, "December 9,2025", "December 9,2018", "Interphil Laboratories, Inc."));
        bodypainList.add(new BodyPain("SALONPAS GEL 15GM", "Methyl Salicylate-Menthol", "Salonpas", 200, 78.50, "December 9,2025", "December 9,2018", "PT. Hisamitsu Pharma Indonesia"));
        bodypainList.add(new BodyPain("ALAXAN FR 200mg/325mg CAPSULE", "Ibuprofen+Paracetamol", "Alaxan", 200, 8.00, "December 9,2025", "December 9,2018", "PT Medifarma Laboratories"));

        coughList.add(new Cough("ROBITUSSIN DM SYRUP 120 ML", "Dextromethorphan", "Robitussin", 300, 165.00, "December 9,2025", "December 9,2018", "Interphil Laboratories, Inc."));
        coughList.add(new Cough("AMBROXOL 30MG TABLET – RITEMED", "Ambroxol", "Ritemed", 300, 5.25, "December 9,2025", "December 9,2018", "Amherst Laboratories, Inc."));
        coughList.add(new Cough("SOLMUX 500MG CAPSULE", "Carbocisteine", "Solmux", 300, 10.50, "December 9,2025", "December 9,2018", "United Laboratories,. Inc."));

        headacheList.add(new Headache("Aspilets Ec 80mg Tablet", "Aspirin", "Aspilets", 400, 3.75, "December 9,2025", "December 9,2018", "Amherst Laboratories, Inc."));
        headacheList.add(new Headache("ADVIL LIQUID 200mg GEL CAPSULE", "Ibuprofen", "Advil", 400, 8.50, "December 9,2025", "December 9,2018", "Catalent Australia Pty Ltd"));
        headacheList.add(new Headache("TEMPRA 120MG/5ML SYRUP BUBBLEGUM 60ML", "Paracetamol", "Tempra", 400, 97.00, "December 9,2025", "December 9,2018", "PT Taisho Pharmaceutical Indonesia Tbk"));

    }

    public DrugItem(Allergies allergies, BodyPain bodypain, Cough cough, Headache headache) {
        this.allergies = allergies;
        this.bodypain = bodypain;
        this.cough = cough;
        this.headache = headache;
    }
//        System.out.print("Drug Name: ");
//        cough.setDrugName(sc.nextLine());
//        System.out.print("Brand Name: ");
//        cough.setBrandName(sc.nextLine());
//        System.out.print("Generic Name: ");
//        cough.setGenericName(sc.nextLine());
//        System.out.print("Expiration Date: ");
//        cough.setExpirationDate(sc.nextLine());
//        System.out.print("Manufactured Date: ");
//        cough.setManufacturedDate(sc.nextLine());
//        System.out.print("Manufacturer: ");
//        cough.setManufacturer(sc.nextLine());
//        System.out.print("Availabilty: ");
//        cough.setDrugAvailability(sc.nextInt());
//        System.out.print("Price: ");
//        cough.setDrugPrice(sc.nextDouble());
    public void addMed(Allergies a) {
        allergiesList.add(a);
    }

    public void addMed(BodyPain a) {
        bodypainList.add(a);
    }

    public void addMed(Cough a) {
        coughList.add(a);
    }

    public void addMed(Headache a) {
        headacheList.add(a);
    }
//delte function

    public void deleteAllergiesMed(int i) {
       allergiesList.remove(i);

    }

    public void deleteBodyPainMed(int i) {
        bodypainList.remove(i);
    }

    public void deleteCoughMed(int i) {
        coughList.remove(i);
    }

    public void deleteHeadacheMed(int i) {
        headacheList.remove(i);
    }

    public void viewCoughMed() {
        int c = 1;
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.print("Here are our available medicines for COUGHS: \n");
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("   %-42s|%-23s|%-23s|%-10s|%-10s|%-20s|%-20s|%-30s\n", "MEDICINEs", "GENERIC NAME", "BRAND NAME","STOCKs" ,"PRICEs", "EXPIRATION DATE", "MANUFACTURED DATE", "MANUFACTURER");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        for (int i = 0; i < coughList.size(); ++i) {

            System.out.printf("❍" + c + ". %-40s %-23s %-23s %-10d %-10.2f %-20s %-20s %-30s\n", coughList.get(i).getDrugName(), coughList.get(i).getGenericName(), coughList.get(i).getBrandName(), coughList.get(i).getDrugAvailability(),coughList.get(i).getDrugPrice(), coughList.get(i).getExpirationDate(), coughList.get(i).getManufacturedDate(), coughList.get(i).getManufacturer());
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
            c++;
        }
    }

    public void viewAllergiesMed() {
        int c = 1;
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.print("Here are our available medicines for ALLERGIES: \n");
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("   %-42s|%-23s|%-23s|%-10s|%-10s|%-20s|%-20s|%-30s\n", "MEDICINEs", "GENERIC NAME", "BRAND NAME","STOCKs" ,"PRICEs", "EXPIRATION DATE", "MANUFACTURED DATE", "MANUFACTURER");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        for (int i = 0; i < allergiesList.size(); ++i) {

            System.out.printf("❍" + c + ". %-40s %-23s %-23s %-10d %-10.2f %-20s %-20s %-30s\n", allergiesList.get(i).getDrugName(), allergiesList.get(i).getGenericName(), allergiesList.get(i).getBrandName(),allergiesList.get(i).getDrugAvailability(),allergiesList.get(i).getDrugPrice(), allergiesList.get(i).getExpirationDate(), allergiesList.get(i).getManufacturedDate(), allergiesList.get(i).getManufacturer());
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
            c++;
        }
    }

    public void viewHeadacheMed() {
        int c = 1;
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.print("Here are our available medicines for HEADACHES: \n");
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("   %-42s|%-23s|%-23s|%-10s|%-10s|%-20s|%-20s|%-30s\n", "MEDICINEs", "GENERIC NAME", "BRAND NAME", "STOCKs","PRICEs", "EXPIRATION DATE", "MANUFACTURED DATE", "MANUFACTURER");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        for (int i = 0; i < headacheList.size(); ++i) {

            System.out.printf("❍" + c + ". %-40s %-23s %-23s %-10d %-10.2f %-20s %-20s %-30s\n", headacheList.get(i).getDrugName(), headacheList.get(i).getGenericName(), headacheList.get(i).getBrandName(),headacheList.get(i).getDrugAvailability(),headacheList.get(i).getDrugPrice(), headacheList.get(i).getExpirationDate(), headacheList.get(i).getManufacturedDate(), headacheList.get(i).getManufacturer());
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
            c++;
        }
    }

    public void viewBodyPainMed() {
        int c = 1;
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.print("Here are our available medicines for BODY PAINS: \n");
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("   %-42s|%-30s|%-18s|%-10s|%-10s|%-20s|%-20s|%-30s\n", "MEDICINEs", "GENERIC NAME", "BRAND NAME", "STOCKs", "PRICEs", "EXPIRATION DATE", "MANUFACTURED DATE", "MANUFACTURER");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        for (int i = 0; i < bodypainList.size(); ++i) {

            System.out.printf("❍" + c + ". %-40s %-30s %-18s %-10d %-10.2f %-20s %-20s %-30s\n", bodypainList.get(i).getDrugName(), bodypainList.get(i).getGenericName(), bodypainList.get(i).getBrandName(), bodypainList.get(i).getDrugAvailability(),bodypainList.get(i).getDrugPrice(), bodypainList.get(i).getExpirationDate(), bodypainList.get(i).getManufacturedDate(), bodypainList.get(i).getManufacturer());
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
            c++;
        }

    }

    public void showMed() {
        int c = 1;
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.print("HERE ARE ALL OUR AVAILALBLE MEDICINEs IN STORE: \n");
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("   %-42s|%-30s|%-18s|%-10s|  %-12s| %-18s\n", "MEDICINEs", "GENERIC NAME", "BRAND NAME", "STOCKs", "PRICEs", "CATEGORY");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------|");
        for (int i = 0; i < allergiesList.size(); ++i) {
            System.out.printf("❍" + c + ". %-40s %-30s %-10s %14d %14.2f\t  Allergies\n", allergiesList.get(i).getDrugName(), allergiesList.get(i).getGenericName(), allergiesList.get(i).getBrandName(), allergiesList.get(i).getDrugAvailability(), allergiesList.get(i).getDrugPrice());
            allMedList.add(allergiesList.get(i).getDrugName());
            allMedPriceList.add(allergiesList.get(i).getDrugPrice());
            allMedStockList.add(allergiesList.get(i).getDrugAvailability());
            otherDetails.add("BRAND NAME: "+allergiesList.get(i).getBrandName()+"\nGENERIC NAME: "+allergiesList.get(i).getGenericName()+"\nExp.Date: "+allergiesList.get(i).getExpirationDate()+"\nMfd.Date: "+allergiesList.get(i).getManufacturedDate());
            c++;
        }

        for (int i = 0; i < bodypainList.size(); ++i) {
            System.out.printf("❍" + c + ". %-40s %-30s %-10s %14d %14.2f\t  Body Pains\n", bodypainList.get(i).getDrugName(), bodypainList.get(i).getGenericName(), bodypainList.get(i).getBrandName(), bodypainList.get(i).getDrugAvailability(), bodypainList.get(i).getDrugPrice());
            allMedList.add(bodypainList.get(i).getDrugName());
            allMedPriceList.add(bodypainList.get(i).getDrugPrice());
            allMedStockList.add(bodypainList.get(i).getDrugAvailability());
            otherDetails.add("BRAND NAME: "+bodypainList.get(i).getBrandName()+"\nGENERIC NAME: "+bodypainList.get(i).getGenericName()+"\nExp.Date: "+bodypainList.get(i).getExpirationDate()+"\nMfd.Date: "+bodypainList.get(i).getManufacturedDate());
            c++;
        }

        for (int i = 0; i < coughList.size(); ++i) {
            System.out.printf("❍" + c + ". %-40s %-30s %-10s %14d %14.2f\t  Coughs\n", coughList.get(i).getDrugName(), coughList.get(i).getGenericName(), coughList.get(i).getBrandName(), coughList.get(i).getDrugAvailability(), coughList.get(i).getDrugPrice());
            allMedList.add(coughList.get(i).getDrugName());
            allMedPriceList.add(coughList.get(i).getDrugPrice());
            allMedStockList.add(coughList.get(i).getDrugAvailability());
            otherDetails.add("BRAND NAME: "+coughList.get(i).getBrandName()+"\nGENERIC NAME: "+coughList.get(i).getGenericName()+"\nExp.Date: "+coughList.get(i).getExpirationDate()+"\nMfd.Date: "+coughList.get(i).getManufacturedDate());
            c++;
        }

        for (int i = 0; i < headacheList.size(); ++i) {
            System.out.printf("❍" + c + ". %-39s %-30s %-10s %14d %14.2f\t  Headaches\n", headacheList.get(i).getDrugName(), headacheList.get(i).getGenericName(), headacheList.get(i).getBrandName(), headacheList.get(i).getDrugAvailability(), headacheList.get(i).getDrugPrice());
            allMedList.add(headacheList.get(i).getDrugName());
            allMedPriceList.add(headacheList.get(i).getDrugPrice());
            allMedStockList.add(headacheList.get(i).getDrugAvailability());
            otherDetails.add("BRAND NAME: "+headacheList.get(i).getBrandName()+"\nGENERIC NAME: "+headacheList.get(i).getGenericName()+"\nExp.Date: "+headacheList.get(i).getExpirationDate()+"\nMfd.Date: "+headacheList.get(i).getManufacturedDate());
            c++;
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------|");
    }

    public static void main(String[] args) {

        DrugItem d = new DrugItem();
        Allergies a = new Allergies("Cetirizine 10Mg Tablet – RiteMed", "Cetirizine", "Ritemed", 100, 20.75, "December 9,2025", "December 9,2018", "Unique Pharmaceutical Laboratories");

       
        d.showMed();
        System.out.println(d.allMedList);
        System.out.println(d.allergiesList.get(0).getClass());

    }

}
