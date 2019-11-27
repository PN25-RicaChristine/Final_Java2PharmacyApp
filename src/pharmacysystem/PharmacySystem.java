/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacysystem;

import java.util.ArrayList;
import java.util.Scanner;
//import java.util.Scanner;

/**
 *
 * @author debuayanri_sd2022
 */
public class PharmacySystem extends DrugItem {

    //  Scanner sc = new Scanner(System.in);
    private Pharmacist pharmacist;
    private Customer customer;
    ArrayList<Pharmacist> pharmacistList = new ArrayList<>();
    ArrayList<Customer> customerList = new ArrayList<>();

    //----------------------------------------------for ordering datas--------------------------------------------     
    ArrayList<String> customerOrderMed = new ArrayList<>();// private String[] orderList;
    ArrayList<Double> customerOrderPrice = new ArrayList<>();//private double[] unitPrice;
    ArrayList<Integer> customerOrderQty = new ArrayList<>();//private int[] qtyList;    
    ArrayList<Double> subPrices = new ArrayList<>();// private double[] subPrices;
    ArrayList<String> coOther = new ArrayList<>();

    boolean ordering = true;
    private int quantity;
    private double subTotal;
    public double totalAmount = 0;
    private double itemPrice;
    public double disPrice;
    private String payment;
    private double per;
    boolean madeOrder = false;
    static Scanner input = new Scanner(System.in);

    //------------------------------------------------------------------------------------------------------------------ 
    public PharmacySystem() {
        customerList.add(new Customer("Mike Debrie Debuayan", "Cebu City, Cebu", "mdebrie", "mddd", 19));
        customerList.add(new Customer("Erlinda Wenceslao", "Isabel, Leyte", "nene", "lola", 70));
        customerList.add(new Customer("Khen Arjie Debuayan", "Dalaguete, Cebu", "khena", "kadd", 18));
        pharmacistList.add(new Pharmacist("Rica Christine Debuayan", "Moscow, Russia", "chrisca_debs", "admin"));

    }

    public boolean logIn(Pharmacist p) {
        for (Pharmacist pharmacistList1 : pharmacistList) {
            if (pharmacistList1.getUsername().equals(p.getUsername()) && pharmacistList1.getPassword().equals(p.getPassword())) {
                p.setName(pharmacistList1.getName());
                return true;
            }
        }
        return false;
    }

    public boolean logIn(Customer c) {

        for (Customer customerList1 : customerList) {
            if (customerList1.getUsername().equals(c.getUsername()) && customerList1.getPassword().equals(c.getPassword())) {
                c.setName(customerList1.getName());
                c.setAge(customerList1.getAge());
                c.setPassword(customerList1.getPassword());
                c.setAddress(customerList1.getAddress());
                c.setUsername(customerList1.getUsername());
                c.customerIDno = customerList1.customerIDno;

                return true;
            }
        }
        return false;
    }

    public void customerOption() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("\n㊂㊂㊂ Choose Transaction: ㊂㊂㊂\n\n☛1.View Medicines\n☛2.View Order\n☛3.Place Order\n☛0. Log Out\n");
        System.out.println("\n---------------------------------------------------");
    }

    public void pharmacistOption() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("\n㊂㊂㊂ Choose Transaction:㊂㊂㊂\n\n☛1.View Medicines\n☛2.Control Medicines\n☛3.View Customer\n☛4.View Customer Orders\n☛0. Log Out\n");
        System.out.println("\n---------------------------------------------------");
    }

    public void SignUp(Customer c) {
        customerList.add(c);
        int i = customerList.indexOf(c);
        System.out.println(customerList.get(i));
    }

    public void SignUp(Pharmacist p) {
        pharmacistList.add(p);
        int n = pharmacistList.indexOf(p);
        System.out.println(pharmacistList.get(n));
    }

    public void viewCustomers() {
        int c = 1;
        System.out.println("\n---------------------------------------------------------------------------------|");
        System.out.print("Here are the LIST of our VALUED CUSTOMERS: \n");
        System.out.println("\n---------------------------------------------------------------------------------|");
        System.out.printf("   %-42s|%-23s\n", "NAME", "CATEGORY");
        System.out.println("---------------------------------------------------------------------------------|");
        for (int i = 0; i < customerList.size(); ++i) {
            if (customerList.get(i).isSenior() == true) {
                System.out.printf("❍" + c + ". %-40s %-23s\n", customerList.get(i).getName(), "SENIOR");
            } else if (customerList.get(i).isAdult() == true) {
                System.out.printf("❍" + c + ". %-40s %-23s\n", customerList.get(i).getName(), "ADULT");
            }
            System.out.println("---------------------------------------------------------------------------------|");
            c++;
        }
    }

    public void viewSenior() {
        int c = 1;
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.print("Here are the LIST of our SENIOR CITIZEN CUSTOMERS\n (who gets 20% discount automatically when purchasing medicines): ");
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("   %-42s|%-23s|%-23s|%-23s\n", "NAME", "ADDRESS", "USERNAME", "AGE");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------|");
        for (int i = 0; i < customerList.size(); ++i) {
            if (customerList.get(i).isSenior() == true) {
                System.out.printf("❍" + c + ". %-40s %-23s %-23s %-23s\n", customerList.get(i).getName(), customerList.get(i).getAddress(), customerList.get(i).getUsername(), customerList.get(i).getAge());
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------|");
                c++;
            }
        }

    }

    public void viewAdult() {
        int c = 1;
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.print("Here are the LIST of our ADULT CUSTOMERS: ");
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("   %-42s|%-23s|%-23s|%-23s\n", "NAME", "ADDRESS", "USERNAME", "AGE");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------|");
        for (int i = 0; i < customerList.size(); ++i) {
            if (customerList.get(i).isAdult() == true) {
                System.out.printf("❍" + c + ". %-40s %-23s %-23s %-23s\n", customerList.get(i).getName(), customerList.get(i).getAddress(), customerList.get(i).getUsername(), customerList.get(i).getAge());
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------|");
                c++;
            }
        }

    }

    //----------------------------------------------for ordering methods-------------------------------------------- 
    public void menu() {
        System.out.println("\t\tPlease choose the item number of your orders from our list below:\n");
        super.showMed();
        System.out.println("Press '0' if you're done.\n");
    }

    public double itemPrice(int medItem) {
        int i;
        boolean q = true;
        i = medItem - 1;
        System.out.println("You've ordered " + super.allMedList.get(i));

        do {
            System.out.print("Enter quantity: ");
            quantity = input.nextInt();
            if (quantity > super.allMedStockList.get(i) && super.allMedStockList.get(i) > 0) {
                System.out.println("Orderd medicine quantity is greater than the available stock!");

            } else if (quantity <= super.allMedStockList.get(i) && super.allMedStockList.get(i) > 0) {
                itemPrice = super.allMedPriceList.get(i);
                customerOrderMed.add(super.allMedList.get(i));
                customerOrderPrice.add(itemPrice);
                coOther.add(super.otherDetails.get(i));
                subTotal(quantity, itemPrice);
                customerOrderQty.add(quantity);
                super.allMedStockList.set(i, super.allMedStockList.get(i) - quantity);

//                update stock
                for (int k = 0; k < super.allergiesList.size(); k++) {
                    if (super.allMedList.get(i).equals(super.allergiesList.get(k).getDrugName())) {
                        super.allergiesList.get(k).setDrugAvailability(super.allMedStockList.get(i));

                    }
                }

                for (int k = 0; k < super.bodypainList.size(); k++) {
                    if (super.allMedList.get(i).equals(super.bodypainList.get(k).getDrugName())) {
                        super.bodypainList.get(k).setDrugAvailability(super.allMedStockList.get(i));
                    }
                }

                for (int k = 0; k < super.coughList.size(); k++) {
                    if (super.allMedList.get(i).equals(super.coughList.get(k).getDrugName())) {
                        super.coughList.get(k).setDrugAvailability(super.allMedStockList.get(i));
                    }
                }

                for (int k = 0; k < super.headacheList.size(); k++) {
                    if (super.allMedList.get(i).equals(super.headacheList.get(k).getDrugName())) {
                        super.headacheList.get(k).setDrugAvailability(super.allMedStockList.get(i));
                    }
                }

                break;
            } else if (super.allMedStockList.get(i) == 0) {
                System.out.println("Medicine OUT OF STOCK!\n");
                q = false;
                break;
            }
        } while (q);

//        quantity();
        System.out.println("");
        return itemPrice;
    }

    public double subTotal(int quantity, double itemPrice) {
        subTotal = quantity * itemPrice;
        totalAmount += subTotal;
        System.out.println("Subtotal: " + subTotal);
        subPrices.add(subTotal);
        return subTotal;
    }

    public void done(double totalAmount) {
        ordering = false;
        madeOrder = true;
        payment();

    }

    public boolean discount(Customer c) {
        this.disPrice = totalAmount;

        if (c.isSenior() == true) {
            per = disPrice * 0.20;
            disPrice -= per;
            return true;
        }
        return false;
    }

    public void receipt(Customer c) {
        if (logIn(c) == true) {
            int count = 0;
            System.out.println("\n----------------------------------------------------------------------------------------------");
            System.out.println("USERNAME: " + c.getName() + "\t\tCUSTOMER ID: CSD2022-" + c.customerIDno);
            System.out.printf("\n\t\t\tHere is a copy of your order...\n%-42s|%-18s|%-18s|%-10s\n", "ORDERED MEDICINES", "UNIT PRICE", "QUANTITY", "AMOUNT TOTAL");
            for (int i = count; i < customerOrderMed.size(); ++i) {
                System.out.printf("%-42s|%-18.2f|%-18s|%-10.2f\n", customerOrderMed.get(i), customerOrderPrice.get(i), customerOrderQty.get(i), subPrices.get(i));
            }
            if (discount(c) == true) {
                System.out.printf("\n\t\t\t\t\t\tORIGINAL AMOUNT: Php %.2f", totalAmount);
                System.out.printf("\n\t\t\t\t\t\tDISCOUNT 20%%: Php %.2f", per);
                System.out.printf("\n\t\t\t\t\t\tTOTAL AMOUNT: Php %.2f", disPrice);
            } else {
                System.out.printf("\n\t\t\t\t\t\tTOTAL AMOUNT: Php %.2f", totalAmount);
            }
            System.out.println("\n----------------------------------------------------------------------------------------------");
        }

    }

    public void viewCustomerOrder(Customer c) {
        if (logIn(c) == true) {
            int count = 0;
            System.out.println("\n----------------------------------------------------------------------------------------------");
            System.out.println(c.toString());
            System.out.printf("\n\t\t\tTHE FOLLOWING ARE YOUR MEDICINE ORDERs...\n%-42s|%-18s|%-18s|%-10s\n\n", "ORDERED MEDICINES", "UNIT PRICE", "QUANTITY", "AMOUNT TOTAL");
            System.out.println("\n----------------------------------------------------------------------------------------------");
            for (int i = count; i < customerOrderMed.size(); ++i) {
                System.out.printf("%-42s|%-18.2f|%-18s|%-10.2f\n", customerOrderMed.get(i), customerOrderPrice.get(i), customerOrderQty.get(i), subPrices.get(i));
                System.out.println(coOther.get(i));
                System.out.println("▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️");
            }

            if (discount(c) == true) {

                System.out.printf("\n\t\t\t\t\t\tORIGINAL AMOUNT: Php %.2f", totalAmount);
                System.out.printf("\n\t\t\t\t\t\tDISCOUNT 20%%: Php %.2f", per);
                System.out.printf("\n\t\t\t\t\t\tTOTAL AMOUNT: Php %.2f", disPrice);

            } else {
                System.out.printf("\n\t\t\t\t\t\tTOTAL AMOUNT: Php %.2f", totalAmount);

            }
            System.out.println("\n\t\t\t\t\t\tPAYMENT OPTION: " + payment);
            System.out.println("\n----------------------------------------------------------------------------------------------");

        }

    }

    public void viewOrder(Customer c) {
        if (logIn(c) == true) {
            int count = 0;
            System.out.println("\n----------------------------------------------------------------------------------------------");
            System.out.println(c.toString());
            System.out.printf("\n\t\t\tMEDICINE ORDERs...\n%-42s|%-18s|%-18s|%-10s\n\n", "ORDERED MEDICINES", "UNIT PRICE", "QUANTITY", "AMOUNT TOTAL");
            System.out.println("\n----------------------------------------------------------------------------------------------");
            for (int i = count; i < customerOrderMed.size(); ++i) {
                System.out.printf("%-42s|%-18.2f|%-18s|%-10.2f\n", customerOrderMed.get(i), customerOrderPrice.get(i), customerOrderQty.get(i), subPrices.get(i));
                System.out.println(coOther.get(i));
                System.out.println("▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️▫️");
            }

            if (discount(c) == true) {

                System.out.printf("\n\t\t\t\t\t\tORIGINAL AMOUNT: Php %.2f", totalAmount);
                System.out.printf("\n\t\t\t\t\t\tDISCOUNT 20%%: Php %.2f", per);
                System.out.printf("\n\t\t\t\t\t\tTOTAL AMOUNT: Php %.2f", disPrice);

            } else {
                System.out.printf("\n\t\t\t\t\t\tTOTAL AMOUNT: Php %.2f", totalAmount);

            }
            System.out.println("\n\t\t\t\t\t\tPAYMENT OPTION: " + payment);
            System.out.println("\n----------------------------------------------------------------------------------------------");

        }

    }

    public String payment() {

        boolean pay = true;
        String select;
        System.out.println("\n\t\tPAYMENT OPTION:\n☛1.Cash On Delivery\n☛2.Credit Card\n");
        do {
            System.out.print("Select: ");
            int sel = input.nextInt();
            switch (sel) {
                case 1:
                    payment = "CASH ON DELIVERY";
                    pay = false;
                    break;
                case 2:

                    payment = "CREDIT CARD";

                    pay = false;
                    break;
                default:
                    System.out.println("Inavalid Input!");
                    break;
            }
        } while (pay);
        System.out.println("You have place your order(s) via " + payment + " payment method.");
        return payment;
    }

//    --------------------------------------------------------end order methods-----------------------
    public String customerNotifications(String message) {
        return message;
    }

    public String pharmacistNotifications(String message) {
        return message;
    }

    public static void main(String[] args) {
        Botica botica = new Botica();
    }

}
