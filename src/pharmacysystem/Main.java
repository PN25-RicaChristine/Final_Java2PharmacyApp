/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacysystem;

import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupB
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PharmacySystem s = new PharmacySystem();
        Customer c = new Customer();
        Pharmacist a = new Pharmacist();
 
        int op, logOp, signOp, custOp, ag;
        String uname, pwd, n, ad, u, p;
        boolean sign = true, in = true, ent = true, x = true, custOpBol = true;

        do {
            System.out.println("💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 \n\n\t\tWelcome to SD202 Online Pharmacy!");
            System.out.println("\n\n☛Press 1 to Sign Up\n☛Press 2 to Log In\n☛Press 0 to Exit\n");
            System.out.print("Select: ");
            op = sc.nextInt();
            switch (op) {
                case 0:
                    System.out.println("\nThank you for using our system!☻☻");
                    System.out.println("💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻");
                    ent = false;
                    break;
                case 1:
                    do {
                        System.out.println("\n\n☛Press 1 to sign up as new customer\n☛Press 2 to sign as new admin\n☛Press 0 to Back\n");
                        System.out.print("Select: ");
                        signOp = sc.nextInt();
                        switch (signOp) {
                            case 0:
                                sign = false;

                                break;
// -------------------------------------CUSTOMER SIGN UP----------------------------------------------------------------                              
                            case 1:
                                System.out.println("\nSIGN UP AS NEW CUSTOMER\n");
                                Scanner input = new Scanner(System.in);
                                System.out.print("Name: ");
                                n = input.nextLine();
                                System.out.print("Address: ");
                                ad = input.nextLine();
                                System.out.print("Username: ");
                                u = input.nextLine();
                                System.out.print("Password: ");
                                p = input.nextLine();
                                System.out.print("Age: ");
                                ag = input.nextInt();
                                if (ag >= 18) {
                                    Customer b = new Customer(n, ad, u, p, ag);
                                    s.SignUp(b);
                                    System.out.println("\n☻Successfully Registered☻\n");
                                    String ask;
                                    System.out.print("Do you want to log in, yes or no? ");
                                    ask = sc.next();
                                    if ("yes".equals(ask.toLowerCase())) {
                                        // -------------------------------------CUSTOMER LOG IN after SIGN UP------------------------------------------
                                        System.out.print("\n\n--------CUSTOMER LOGGING IN--------\n\n");
                                        do {
                                            System.out.print("\nUsername: ");
                                            uname = sc.next();
                                            System.out.print("Password: ");
                                            pwd = sc.next();
                                            c.setUsername(uname);
                                            c.setPassword(pwd);
                                            if (s.logIn(c) == true) {
                                                System.out.println("\n☻Successfully Logged In!☻\n");
                                                System.out.println("Good day, " + c.getName() + " ☻!\n");
                                                do {
                                                    s.customerOption();
                                                    System.out.print("Select: ");
                                                    custOp = sc.nextInt();
                                                    switch (custOp) {
                                                        case 0:
                                                            custOpBol = false;
                                                            break;
                                                        case 1:
                                                            int vm;
                                                            boolean vmb = true;

                                                            do {
                                                                System.out.println("\n---------------------------------------------------");
                                                                System.out.println("\t≣ VIEW MEDICINES");
                                                                System.out.println("\n☛Press 1 to view Allergies Medicines\n☛Press 2 to view Body Pain Medicines\n☛Press 3 to view Cough Medicines\n☛Press 4 to view Headache Medicines\n☛Press 0 to Back\n");
                                                                System.out.println("---------------------------------------------------");
                                                                System.out.print("➛Select: ");
                                                                vm = sc.nextInt();
                                                                switch (vm) {
                                                                    case 0:
                                                                        vmb = false;
                                                                        break;
                                                                    case 1:
                                                                        s.viewAllergiesMed();
                                                                        break;
                                                                    case 2:
                                                                        s.viewBodyPainMed();
                                                                        break;
                                                                    case 3:
                                                                        s.viewCoughMed();
                                                                        break;
                                                                    case 4:
                                                                        s.viewHeadacheMed();
                                                                        break;
                                                                    default:
                                                                        System.out.println("Invalid option!\n");
                                                                        break;
                                                                }
                                                            } while (vmb);
                                                            break;
                                                        case 2:

                                                            //----------------------VIEW ORDER------------------------------------
                                                            if (s.madeOrder == false) {
                                                                System.out.println("----------------------------------------------------------");
                                                                System.out.println(c.getName() + " you have not yet place your orders. Place order now!");
                                                                System.out.println("----------------------------------------------------------");
                                                            } else {
                                                                s.viewCustomerOrder(c);
                                                            }
                                                            break;
                                                        case 3:
//----------------------------------------PLACE ORDER--------------------------------------------------------------
                                                            s.menu();
                                                            int menuOption;
                                                            int medItem;
                                                            Scanner inp = new Scanner(System.in);
                                                            do {
                                                                System.out.print("Enter item no: ");
                                                                medItem = inp.nextInt();
                                                                switch (medItem) {
                                                                    case 0:
                                                                        s.done(s.totalAmount);

                                                                        if (s.discount(c) == true) {
                                                                            System.out.printf("\nThank you for ordering medicines!\nAs a senior citizen customer, the total amount of your orders is now Php %.2f .", s.disPrice);
                                                                        } else {
                                                                            System.out.printf("\nThank you for ordering ordering medicines!\nThe total amount of your orders is Php %.2f .", s.totalAmount);
                                                                        }

                                                                        break;
                                                                    default:
                                                                        if (medItem > s.allMedList.size()) {
                                                                            System.out.println("Invalid option.");
                                                                        } else {
                                                                            s.itemPrice(medItem);
                                                                        }

                                                                        break;
                                                                }
                                                            } while (s.ordering);
                                                            if (s.customerOrderMed.isEmpty()) {
                                                                System.out.println("\n\nNO ORDERS MADE!");
                                                            } else {
                                                                s.receipt(c);
                                                            }
                                                            s.ordering = true;
//----------------------------------------END PLACE ORDER--------------------------------------------------------------
                                                            break;
                                                        default:
                                                            System.out.println("Invalid option!\n");
                                                            break;
                                                    }
                                                } while (custOpBol);

                                                x = false;
                                                break;

                                            } else {
                                                System.out.println("\n\n✖Password and Username do not exist or mismatch! Try again!\n");
                                            }
                                        } while (x);

                                        //end point customer login after sign up
                                    } else {

                                        System.out.println("Thank you for using our system!☻☻");
                                        System.out.println("💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻");
                                        break;
                                    }
                                } else {
                                    System.out.println("\n✖Sorry, only adults (18 yrs. old and above) are allowed to use this system!\n");
                                    System.out.println("Thank you for using our system!☻☻");
                                    System.out.println("💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻");
                                    sign = false;
                                    ent = false;
                                    break;
                                }

                                sign = false;
                                break;

// -------------------------------------PHARMACIST SIGN UP  ----------------------------------------------------------------                                
                            case 2:
                                System.out.println("\nSIGN UP AS PHARMACIST\n");
                                Scanner input2 = new Scanner(System.in);
                                System.out.print("Name: ");
                                n = input2.nextLine();
                                System.out.print("Address: ");
                                ad = input2.nextLine();
                                System.out.print("Username: ");
                                u = input2.nextLine();
                                System.out.print("Password: ");
                                p = input2.nextLine();
                                Pharmacist b = new Pharmacist(n, ad, u, p);
                                s.SignUp(b);
                                System.out.println("\n☻Successfully Registered☻\n");
                                String ask;
                                System.out.print("Do you want to log in, yes or no? ");
                                ask = sc.next();
                                if ("yes".equals(ask.toLowerCase())) {
                                    // -------------------------------------PHARMACIST login after sign up  ---------------     
                                    System.out.print("\n\n--------PHARMACIST LOGGING IN--------\n\n");
                                    boolean y = true;
                                    do {
                                        System.out.print("\nUsername: ");
                                        uname = sc.next();
                                        System.out.print("Password: ");
                                        pwd = sc.next();
                                        a.setUsername(uname);
                                        a.setPassword(pwd);
                                        if (s.logIn(a) == true) {
                                            System.out.println("\n☻Successfully Logged In!☻\n");
                                            System.out.println("Good day, " + a.getName() + "☻!\n");
                                            int phOp;
                                            boolean phOpBol = true;
                                            do {
                                                s.pharmacistOption();
                                                System.out.print("Select: ");
                                                phOp = sc.nextInt();
                                                switch (phOp) {
                                                    case 0:
                                                        phOpBol = false;
                                                        break;
                                                    //VIEW MEDICINE OPTIOn
                                                    case 1:
                                                        int vm;
                                                        boolean vmb = true;

                                                        do {
                                                            System.out.println("\n---------------------------------------------------");
                                                            System.out.println("\t≣VIEW MEDICINES");
                                                            System.out.println("\n☛Press 1 to view Allergies Medicines\n☛Press 2 to view Body Pain Medicines\n☛Press 3 to view Cough Medicines\n☛Press 4 to view Headache Medicines\n☛Press 0 to Back\n");
                                                            System.out.println("---------------------------------------------------");
                                                            System.out.print("➛Select: ");
                                                            vm = sc.nextInt();
                                                            switch (vm) {
                                                                case 0:
                                                                    vmb = false;
                                                                    break;
                                                                case 1:
                                                                    s.viewAllergiesMed();
                                                                    break;
                                                                case 2:
                                                                    s.viewBodyPainMed();
                                                                    break;
                                                                case 3:
                                                                    s.viewCoughMed();
                                                                    break;
                                                                case 4:
                                                                    s.viewHeadacheMed();
                                                                    break;
                                                                default:
                                                                    System.out.println("Invalid option!\n");
                                                                    break;
                                                            }
                                                        } while (vmb);
                                                        break;

                                                    //CONTROL MEDICINE OPTION
                                                    case 2:

                                                        int cm;
                                                        boolean cmmed = true;
                                                        do {
                                                            System.out.println("\t≣ CONTROL MEDICINES");
                                                            System.out.println("\n☛Press 1 to Add Medicine\n☛Press 2 to Modify Medicine\n☛Press 3 to Delete Medicine\n☛Press 0 to Back\n");
                                                            System.out.print("Select: ");
                                                            cm = sc.nextInt();
                                                            switch (cm) {
                                                                case 0:
                                                                    cmmed = false;
                                                                    break;
                                                                case 1:
                                                                    int add;
                                                                    boolean addM = true;
                                                                    do {
                                                                        System.out.println("\t≣ ADD MEDICINE\n");
                                                                        System.out.println("\n☛Press 1 to add Allergies Medicines\n☛Press 2 to add Body Pain Medicines\n☛Press 3 to add Cough Medicines\n☛Press 4 to add Headache Medicines\n☛Press 0 to Back\n");
                                                                        System.out.print("Select: ");
                                                                        add = sc.nextInt();
                                                                        switch (add) {
                                                                            case 0:
                                                                                addM = false;
                                                                                break;
                                                                            case 1:
                                                                                Scanner aller = new Scanner(System.in);
                                                                                System.out.println("\n ADD new ALLERGIES MEDICINE\n");
                                                                                double Aprice;
                                                                                int Astock;
                                                                                String Adn,
                                                                                 Abn,
                                                                                 Agn,
                                                                                 Aed,
                                                                                 Amd,
                                                                                 Am;

                                                                                System.out.print("Drug Name: ");
                                                                                Adn = aller.nextLine();
                                                                                System.out.print("Brand Name: ");
                                                                                Abn = aller.nextLine();
                                                                                System.out.print("Generic Name: ");
                                                                                Agn = aller.nextLine();
                                                                                System.out.print("Expiration Date: ");
                                                                                Aed = aller.nextLine();
                                                                                System.out.print("Manufactured Date: ");
                                                                                Amd = aller.nextLine();
                                                                                System.out.print("Manufacturer: ");
                                                                                Am = aller.nextLine();
                                                                                System.out.print("Availabilty: ");
                                                                                Astock = aller.nextInt();
                                                                                System.out.print("Price: ");
                                                                                Aprice = aller.nextDouble();
                                                                                Allergies aa = new Allergies(Adn, Abn, Agn, Astock, Aprice, Aed, Amd, Am);
                                                                                s.addMed(aa);
                                                                                System.out.println(aa.getDrugName() + " successfully added!\n");
                                                                                break;
                                                                            case 2:
                                                                                Scanner Bo = new Scanner(System.in);
                                                                                System.out.println("\n ADD new BODY PAIN MEDICINE\n");
                                                                                double Bprice;
                                                                                int Bstock;
                                                                                String Bdn,
                                                                                 Bbn,
                                                                                 Bgn,
                                                                                 Bed,
                                                                                 Bmd,
                                                                                 Bm;

                                                                                System.out.print("Drug Name: ");
                                                                                Bdn = Bo.nextLine();
                                                                                System.out.print("Brand Name: ");
                                                                                Bbn = Bo.nextLine();
                                                                                System.out.print("Generic Name: ");
                                                                                Bgn = Bo.nextLine();
                                                                                System.out.print("Expiration Date: ");
                                                                                Bed = Bo.nextLine();
                                                                                System.out.print("Manufactured Date: ");
                                                                                Bmd = Bo.nextLine();
                                                                                System.out.print("Manufacturer: ");
                                                                                Bm = Bo.nextLine();
                                                                                System.out.print("Availabilty: ");
                                                                                Bstock = Bo.nextInt();
                                                                                System.out.print("Price: ");
                                                                                Bprice = Bo.nextDouble();
                                                                                BodyPain bp = new BodyPain(Bdn, Bbn, Bgn, Bstock, Bprice, Bed, Bmd, Bm);
                                                                                s.addMed(bp);
                                                                                System.out.println(bp.getDrugName() + " successfully added!\n");
                                                                                break;
                                                                            case 3:
                                                                                Scanner Co = new Scanner(System.in);
                                                                                System.out.println("\n ADD new COUGH MEDICINE\n");
                                                                                double Cprice;
                                                                                int Cstock;
                                                                                String Cdn,
                                                                                 Cbn,
                                                                                 Cgn,
                                                                                 Ced,
                                                                                 Cmd,
                                                                                 Cm;

                                                                                System.out.print("Drug Name: ");
                                                                                Cdn = Co.nextLine();
                                                                                System.out.print("Brand Name: ");
                                                                                Cbn = Co.nextLine();
                                                                                System.out.print("Generic Name: ");
                                                                                Cgn = Co.nextLine();
                                                                                System.out.print("Expiration Date: ");
                                                                                Ced = Co.nextLine();
                                                                                System.out.print("Manufactured Date: ");
                                                                                Cmd = Co.nextLine();
                                                                                System.out.print("Manufacturer: ");
                                                                                Cm = Co.nextLine();
                                                                                System.out.print("Availabilty: ");
                                                                                Cstock = Co.nextInt();
                                                                                System.out.print("Price: ");
                                                                                Cprice = Co.nextDouble();
                                                                                Cough coug = new Cough(Cdn, Cbn, Cgn, Cstock, Cprice, Ced, Cmd, Cm);
                                                                                s.addMed(coug);
                                                                                System.out.println(coug.getDrugName() + " successfully added!\n");
                                                                                break;
                                                                            case 4:
                                                                                Scanner He = new Scanner(System.in);
                                                                                System.out.println("\n ADD new HEADACHE MEDICINE\n");
                                                                                double Hprice;
                                                                                int Hstock;
                                                                                String Hdn,
                                                                                 Hbn,
                                                                                 Hgn,
                                                                                 Hed,
                                                                                 Hmd,
                                                                                 Hm;

                                                                                System.out.print("Drug Name: ");
                                                                                Hdn = He.nextLine();
                                                                                System.out.print("Brand Name: ");
                                                                                Hbn = He.nextLine();
                                                                                System.out.print("Generic Name: ");
                                                                                Hgn = He.nextLine();
                                                                                System.out.print("Expiration Date: ");
                                                                                Hed = He.nextLine();
                                                                                System.out.print("Manufactured Date: ");
                                                                                Hmd = He.nextLine();
                                                                                System.out.print("Manufacturer: ");
                                                                                Hm = He.nextLine();
                                                                                System.out.print("Availabilty: ");
                                                                                Hstock = He.nextInt();
                                                                                System.out.print("Price: ");
                                                                                Hprice = He.nextDouble();
                                                                                Headache head = new Headache(Hdn, Hbn, Hgn, Hstock, Hprice, Hed, Hmd, Hm);
                                                                                s.addMed(head);
                                                                                System.out.println(head.getDrugName() + " successfully added!\n");
                                                                                break;
                                                                            default:
                                                                                System.out.println("Invalid Option!");
                                                                                break;
                                                                        }
                                                                    } while (addM);
                                                                    break;
                                                                //modify 
                                                                case 2:
                                                                    System.out.println("\t≣ MODIFY MEDICINE\n");
                                                                    System.out.println("\nNO FUNCTION YET...UNDERCONSTRUCTION!\n\n");
                                                                    break;

                                                                //delete medicine
                                                                case 3:
                                                                    int delete;
                                                                    boolean delM = true;
                                                                    do {
                                                                        System.out.println("\t≣ DELETE MEDICINE\n");
                                                                        System.out.println("\n☛Press 1 to delete Allergies Medicines\n☛Press 2 to delete Body Pain Medicines\n☛Press 3 to delete Cough Medicines\n☛Press 4 to delete Headache Medicines\n☛Press 0 to Back\n");
                                                                        System.out.print("Select: ");
                                                                        delete = sc.nextInt();
                                                                        switch (delete) {
                                                                            case 0:
                                                                                delM = false;
                                                                                break;
                                                                            case 1:
                                                                                boolean delA = true;
                                                                                s.viewAllergiesMed();
                                                                                System.out.println("Press 0 if done..");
                                                                                do {
                                                                                    System.out.print("Select medicine no. to delete: ");
                                                                                    int dam = sc.nextInt();
                                                                                    switch (dam) {
                                                                                        case 0:
                                                                                            delA = false;
                                                                                            System.out.println("You are done deleting medicines!\n");
                                                                                            break;
                                                                                        default:
                                                                                            if (dam > s.allergiesList.size()) {
                                                                                                System.out.println("Invalid Input!");
                                                                                            } else {
                                                                                                System.out.println("You deleted " + s.allergiesList.get(dam - 1).getDrugName() + " succesfully!");
                                                                                                s.deleteAllergiesMed(dam - 1);
                                                                                            }
                                                                                            break;
                                                                                    }

                                                                                } while (delA);

                                                                                break;
                                                                            case 2:
                                                                                boolean delB = true;
                                                                                s.viewBodyPainMed();
                                                                                System.out.println("Press 0 if done..");
                                                                                do {
                                                                                    System.out.print("Select medicine no. to delete: ");
                                                                                    int dBm = sc.nextInt();
                                                                                    switch (dBm) {
                                                                                        case 0:
                                                                                            delB = false;
                                                                                            System.out.println("You are done deleting medicines!\n");
                                                                                            break;
                                                                                        default:
                                                                                            if (dBm > s.bodypainList.size()) {
                                                                                                System.out.println("Invalid Input!");
                                                                                            } else {
                                                                                                System.out.println("You deleted " + s.bodypainList.get(dBm - 1).getDrugName() + " succesfully!");
                                                                                                s.deleteBodyPainMed(dBm - 1);
                                                                                            }
                                                                                            break;
                                                                                    }

                                                                                } while (delB);
                                                                                break;

                                                                            case 3:
                                                                                boolean delC = true;
                                                                                s.viewCoughMed();
                                                                                System.out.println("Press 0 if done..");
                                                                                do {
                                                                                    System.out.print("Select medicine no. to delete: ");
                                                                                    int dCm = sc.nextInt();
                                                                                    switch (dCm) {
                                                                                        case 0:
                                                                                            delC = false;
                                                                                            System.out.println("You are done deleting medicines!\n");
                                                                                            break;
                                                                                        default:
                                                                                            if (dCm > s.coughList.size()) {
                                                                                                System.out.println("Invalid Input!");
                                                                                            } else {
                                                                                                System.out.println("You deleted " + s.coughList.get(dCm - 1).getDrugName() + " succesfully!");
                                                                                                s.deleteCoughMed(dCm - 1);
                                                                                            }
                                                                                            break;
                                                                                    }

                                                                                } while (delC);
                                                                                break;

                                                                            case 4:
                                                                                boolean delH = true;
                                                                                s.viewHeadacheMed();
                                                                                System.out.println("Press 0 if done..");
                                                                                do {
                                                                                    System.out.print("Select medicine no. to delete: ");
                                                                                    int dHm = sc.nextInt();
                                                                                    switch (dHm) {
                                                                                        case 0:
                                                                                            delH = false;
                                                                                            System.out.println("You are done deleting medicines!\n");
                                                                                            break;
                                                                                        default:
                                                                                            if (dHm > s.headacheList.size()) {
                                                                                                System.out.println("Invalid Input!");
                                                                                            } else {
                                                                                                System.out.println("You deleted " + s.headacheList.get(dHm - 1).getDrugName() + " succesfully!");
                                                                                                s.deleteHeadacheMed(dHm - 1);
                                                                                            }
                                                                                            break;
                                                                                    }

                                                                                } while (delH);
                                                                                break;

                                                                            default:
                                                                                System.out.println("Invalid Option!");
                                                                                break;
                                                                        }
                                                                    } while (delM);

                                                                    break;
                                                                default:
                                                                    System.out.println("Invalid Option!");
                                                                    break;
                                                            }
                                                        } while (cmmed);
                                                        break;
                                                    //VIEW CUSTOMER
                                                    case 3:
                                                        int vc;
                                                        boolean vcb = true;
                                                        s.viewCustomers();
                                                        do {
                                                            System.out.println("\n---------------------------------------------------");
                                                            System.out.println("\t≣VIEW CUSTOMERS");

                                                            System.out.println("\n☛Press 1 to view ADULT details\n☛Press 2 to view SENIOR details\n☛Press 0 to Back\n");
                                                            System.out.println("---------------------------------------------------");
                                                            System.out.print("➛Select: ");
                                                            vc = sc.nextInt();
                                                            switch (vc) {
                                                                case 0:
                                                                    vcb = false;
                                                                    break;
                                                                case 1:
                                                                    s.viewAdult();
                                                                    break;
                                                                case 2:
                                                                    s.viewSenior();
                                                                    break;

                                                                default:
                                                                    System.out.println("Invalid option!\n");
                                                                    break;
                                                            }
                                                        } while (vcb);

                                                        break;

                                                    //VIEW CUSTOMER ORDERS
                                                    case 4:
                                                        System.out.println("\nNO FUNCTION YET...UNDERCONSTRUCTION!\n\n");
                                                        s.viewCustomers();
                                                        System.out.println("Press 0 if done...");
                                                        int vco;
                                                        boolean vcoB = true;
                                                        do {
                                                            System.out.print("Select customer no. to view his/her orders:");
                                                            vco = sc.nextInt();
                                                            switch (vco) {
                                                                case 0:
                                                                    vcoB = false;
                                                                    break;
                                                                default:
                                                                    if (vco > s.customerList.size()) {
                                                                        System.out.println("Invalid Input!");
                                                                    } else {
                                                                        if (s.madeOrder == false) {
                                                                            System.out.println("----------------------------------------------------------");
                                                                            System.out.println(s.customerList.get(vco - 1).getName() + " have not yet place orders!");
                                                                            System.out.println("----------------------------------------------------------");
                                                                        } else {
                                                                            s.viewOrder(s.customerList.get(vco - 1));
                                                                        }
                                                                    }
                                                                    break;
                                                            }

                                                        } while (vcoB);

                                                        break;
                                                    default:
                                                        System.out.println("Invalid option!\n");
                                                        break;
                                                }
                                            } while (phOpBol);

                                            y = false;
                                            break;
                                        } else {
                                            System.out.println("\n\n✖Password and Username do not exist or mismatch! Try again!\n");
                                        }
                                    } while (y);
                                    // -------------------------------------PHARMACIST login after sign up  end poin-----
                                } else {

                                    System.out.println("Thank you for using our system!☻☻");
                                    System.out.println("💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻 💻💻💻");
                                    break;
                                }

                                sign = false;
                                break;
                            default:
                                System.out.println("Invalid option!");
                                break;
                        }
                    } while (sign);

                    break;

//-------------------------------------LOG IN SYSTEM  ----------------------------------------------------------------                     
//-------------------------------------LOG IN SYSTEM  ----------------------------------------------------------------                     
                case 2:
                    do {
                        System.out.println("\n\n☛Press 1 to log in as customer\n☛Press 2 to log in as admin\n☛Press 0 to Back\n");
                        System.out.print("Select: ");
                        logOp = sc.nextInt();
                        switch (logOp) {
                            case 0:

                                in = false;
                                break;

// -------------------------------------CUSTOMER LOG IN----------------------------------------------------------------         
                            case 1:
                                System.out.print("\n\n--------LOG IN AS CUSTOMER--------\n\n");
                                do {
                                    System.out.print("\nUsername: ");
                                    uname = sc.next();
                                    System.out.print("Password: ");
                                    pwd = sc.next();
                                    c.setUsername(uname);
                                    c.setPassword(pwd);
                                    if (s.logIn(c) == true) {
                                        System.out.println("\n☻Successfully Logged In!☻\n");
                                        System.out.println("Good day, " + c.getName() + " ☻!\n");
                                        do {
                                            s.customerOption();
                                            System.out.print("Select: ");
                                            custOp = sc.nextInt();
                                            switch (custOp) {
                                                case 0:
                                                    custOpBol = false;
                                                    break;
                                                case 1:
                                                    int vm;
                                                    boolean vmb = true;

                                                    do {
                                                        System.out.println("\n---------------------------------------------------");
                                                        System.out.println("\t≣ VIEW MEDICINES");
                                                        System.out.println("\n☛Press 1 to view Allergies Medicines\n☛Press 2 to view Body Pain Medicines\n☛Press 3 to view Cough Medicines\n☛Press 4 to view Headache Medicines\n☛Press 0 to Back\n");
                                                        System.out.println("---------------------------------------------------");
                                                        System.out.print("➛Select: ");
                                                        vm = sc.nextInt();
                                                        switch (vm) {
                                                            case 0:
                                                                vmb = false;
                                                                break;
                                                            case 1:
                                                                s.viewAllergiesMed();
                                                                break;
                                                            case 2:
                                                                s.viewBodyPainMed();
                                                                break;
                                                            case 3:
                                                                s.viewCoughMed();
                                                                break;
                                                            case 4:
                                                                s.viewHeadacheMed();
                                                                break;
                                                            default:
                                                                System.out.println("Invalid option!\n");
                                                                break;
                                                        }
                                                    } while (vmb);
                                                    break;
                                                case 2:

                                                    //----------------------VIEW ORDER------------------------------------
                                                    if (s.madeOrder == false) {
                                                        System.out.println("----------------------------------------------------------");
                                                        System.out.println(c.getName() + " you have not yet place your orders. Place order now!");
                                                        System.out.println("----------------------------------------------------------");
                                                    } else {
                                                        s.viewCustomerOrder(c);
                                                    }
                                                    break;
                                                case 3:
//----------------------------------------PLACE ORDER--------------------------------------------------------------
                                                    s.menu();
                                                    int menuOption;
                                                    int medItem;
                                                    Scanner input = new Scanner(System.in);
                                                    do {
                                                        System.out.print("Enter item no: ");
                                                        medItem = input.nextInt();
                                                        switch (medItem) {
                                                            case 0:
                                                                s.done(s.totalAmount);

                                                                if (s.discount(c) == true) {
                                                                    System.out.printf("\nThank you for ordering medicines!\nAs a senior citizen customer, the total amount of your orders is now Php %.2f .", s.disPrice);
                                                                } else {
                                                                    System.out.printf("\nThank you for ordering ordering medicines!\nThe total amount of your orders is Php %.2f .", s.totalAmount);
                                                                }

                                                                break;
                                                            default:
                                                                if (medItem > s.allMedList.size()) {
                                                                    System.out.println("Invalid option.");
                                                                } else {
                                                                    s.itemPrice(medItem);
                                                                }

                                                                break;
                                                        }
                                                    } while (s.ordering);
                                                    if (s.customerOrderMed.isEmpty()) {
                                                        System.out.println("\n\nNO ORDERS MADE!");
                                                    } else {
                                                        s.receipt(c);
                                                    }
                                                    s.ordering = true;
//----------------------------------------END PLACE ORDER--------------------------------------------------------------
                                                    break;
                                                default:
                                                    System.out.println("Invalid option!\n");
                                                    break;
                                            }
                                        } while (custOpBol);

                                        x = false;
                                        break;

                                    } else {
                                        System.out.println("\n\n✖Password and Username do not exist or mismatch! Try again!\n");
                                    }
                                } while (x);

                                break;

// -------------------------------------PHARMACIST LOG IN----------------------------------------------------------------                               
                            case 2:
                                System.out.print("\n\n--------LOG IN AS PHARMACIST--------\n\n");
                                boolean y = true;
                                do {
                                    System.out.print("\nUsername: ");
                                    uname = sc.next();
                                    System.out.print("Password: ");
                                    pwd = sc.next();
                                    a.setUsername(uname);
                                    a.setPassword(pwd);
                                    if (s.logIn(a) == true) {
                                        System.out.println("\n☻Successfully Logged In!☻\n");
                                        System.out.println("Good day, " + a.getName() + "☻!\n");
                                        int phOp;
                                        boolean phOpBol = true;
                                        do {
                                            s.pharmacistOption();
                                            System.out.print("Select: ");
                                            phOp = sc.nextInt();
                                            switch (phOp) {
                                                case 0:
                                                    phOpBol = false;
                                                    break;
                                                //VIEW MEDICINE OPTIOn
                                                case 1:
                                                    int vm;
                                                    boolean vmb = true;

                                                    do {
                                                        System.out.println("\n---------------------------------------------------");
                                                        System.out.println("\t≣VIEW MEDICINES");
                                                        System.out.println("\n☛Press 1 to view Allergies Medicines\n☛Press 2 to view Body Pain Medicines\n☛Press 3 to view Cough Medicines\n☛Press 4 to view Headache Medicines\n☛Press 0 to Back\n");
                                                        System.out.println("---------------------------------------------------");
                                                        System.out.print("➛Select: ");
                                                        vm = sc.nextInt();
                                                        switch (vm) {
                                                            case 0:
                                                                vmb = false;
                                                                break;
                                                            case 1:
                                                                s.viewAllergiesMed();
                                                                break;
                                                            case 2:
                                                                s.viewBodyPainMed();
                                                                break;
                                                            case 3:
                                                                s.viewCoughMed();
                                                                break;
                                                            case 4:
                                                                s.viewHeadacheMed();
                                                                break;
                                                            default:
                                                                System.out.println("Invalid option!\n");
                                                                break;
                                                        }
                                                    } while (vmb);
                                                    break;

                                                //CONTROL MEDICINE OPTION
                                                case 2:

                                                    int cm;
                                                    boolean cmmed = true;
                                                    do {
                                                        System.out.println("\t≣ CONTROL MEDICINES");
                                                        System.out.println("\n☛Press 1 to Add Medicine\n☛Press 2 to Modify Medicine\n☛Press 3 to Delete Medicine\n☛Press 0 to Back\n");
                                                        System.out.print("Select: ");
                                                        cm = sc.nextInt();
                                                        switch (cm) {
                                                            case 0:
                                                                cmmed = false;
                                                                break;
                                                            case 1:
                                                                int add;
                                                                boolean addM = true;
                                                                do {
                                                                    System.out.println("\t≣ ADD MEDICINE\n");
                                                                    System.out.println("\n☛Press 1 to add Allergies Medicines\n☛Press 2 to add Body Pain Medicines\n☛Press 3 to add Cough Medicines\n☛Press 4 to add Headache Medicines\n☛Press 0 to Back\n");
                                                                    System.out.print("Select: ");
                                                                    add = sc.nextInt();
                                                                    switch (add) {
                                                                        case 0:
                                                                            addM = false;
                                                                            break;
                                                                        case 1:
                                                                            Scanner aller = new Scanner(System.in);
                                                                            System.out.println("\n ADD new ALLERGIES MEDICINE\n");
                                                                            double Aprice;
                                                                            int Astock;
                                                                            String Adn,
                                                                             Abn,
                                                                             Agn,
                                                                             Aed,
                                                                             Amd,
                                                                             Am;

                                                                            System.out.print("Drug Name: ");
                                                                            Adn = aller.nextLine();
                                                                            System.out.print("Brand Name: ");
                                                                            Abn = aller.nextLine();
                                                                            System.out.print("Generic Name: ");
                                                                            Agn = aller.nextLine();
                                                                            System.out.print("Expiration Date: ");
                                                                            Aed = aller.nextLine();
                                                                            System.out.print("Manufactured Date: ");
                                                                            Amd = aller.nextLine();
                                                                            System.out.print("Manufacturer: ");
                                                                            Am = aller.nextLine();
                                                                            System.out.print("Availabilty: ");
                                                                            Astock = aller.nextInt();
                                                                            System.out.print("Price: ");
                                                                            Aprice = aller.nextDouble();
                                                                            Allergies aa = new Allergies(Adn, Abn, Agn, Astock, Aprice, Aed, Amd, Am);
                                                                            s.addMed(aa);
                                                                            System.out.println(aa.getDrugName() + " successfully added!\n");
                                                                            break;
                                                                        case 2:
                                                                            Scanner Bo = new Scanner(System.in);
                                                                            System.out.println("\n ADD new BODY PAIN MEDICINE\n");
                                                                            double Bprice;
                                                                            int Bstock;
                                                                            String Bdn,
                                                                             Bbn,
                                                                             Bgn,
                                                                             Bed,
                                                                             Bmd,
                                                                             Bm;

                                                                            System.out.print("Drug Name: ");
                                                                            Bdn = Bo.nextLine();
                                                                            System.out.print("Brand Name: ");
                                                                            Bbn = Bo.nextLine();
                                                                            System.out.print("Generic Name: ");
                                                                            Bgn = Bo.nextLine();
                                                                            System.out.print("Expiration Date: ");
                                                                            Bed = Bo.nextLine();
                                                                            System.out.print("Manufactured Date: ");
                                                                            Bmd = Bo.nextLine();
                                                                            System.out.print("Manufacturer: ");
                                                                            Bm = Bo.nextLine();
                                                                            System.out.print("Availabilty: ");
                                                                            Bstock = Bo.nextInt();
                                                                            System.out.print("Price: ");
                                                                            Bprice = Bo.nextDouble();
                                                                            BodyPain bp = new BodyPain(Bdn, Bbn, Bgn, Bstock, Bprice, Bed, Bmd, Bm);
                                                                            s.addMed(bp);
                                                                            System.out.println(bp.getDrugName() + " successfully added!\n");
                                                                            break;
                                                                        case 3:
                                                                            Scanner Co = new Scanner(System.in);
                                                                            System.out.println("\n ADD new COUGH MEDICINE\n");
                                                                            double Cprice;
                                                                            int Cstock;
                                                                            String Cdn,
                                                                             Cbn,
                                                                             Cgn,
                                                                             Ced,
                                                                             Cmd,
                                                                             Cm;

                                                                            System.out.print("Drug Name: ");
                                                                            Cdn = Co.nextLine();
                                                                            System.out.print("Brand Name: ");
                                                                            Cbn = Co.nextLine();
                                                                            System.out.print("Generic Name: ");
                                                                            Cgn = Co.nextLine();
                                                                            System.out.print("Expiration Date: ");
                                                                            Ced = Co.nextLine();
                                                                            System.out.print("Manufactured Date: ");
                                                                            Cmd = Co.nextLine();
                                                                            System.out.print("Manufacturer: ");
                                                                            Cm = Co.nextLine();
                                                                            System.out.print("Availabilty: ");
                                                                            Cstock = Co.nextInt();
                                                                            System.out.print("Price: ");
                                                                            Cprice = Co.nextDouble();
                                                                            Cough coug = new Cough(Cdn, Cbn, Cgn, Cstock, Cprice, Ced, Cmd, Cm);
                                                                            s.addMed(coug);
                                                                            System.out.println(coug.getDrugName() + " successfully added!\n");
                                                                            break;
                                                                        case 4:
                                                                            Scanner He = new Scanner(System.in);
                                                                            System.out.println("\n ADD new HEADACHE MEDICINE\n");
                                                                            double Hprice;
                                                                            int Hstock;
                                                                            String Hdn,
                                                                             Hbn,
                                                                             Hgn,
                                                                             Hed,
                                                                             Hmd,
                                                                             Hm;

                                                                            System.out.print("Drug Name: ");
                                                                            Hdn = He.nextLine();
                                                                            System.out.print("Brand Name: ");
                                                                            Hbn = He.nextLine();
                                                                            System.out.print("Generic Name: ");
                                                                            Hgn = He.nextLine();
                                                                            System.out.print("Expiration Date: ");
                                                                            Hed = He.nextLine();
                                                                            System.out.print("Manufactured Date: ");
                                                                            Hmd = He.nextLine();
                                                                            System.out.print("Manufacturer: ");
                                                                            Hm = He.nextLine();
                                                                            System.out.print("Availabilty: ");
                                                                            Hstock = He.nextInt();
                                                                            System.out.print("Price: ");
                                                                            Hprice = He.nextDouble();
                                                                            Headache head = new Headache(Hdn, Hbn, Hgn, Hstock, Hprice, Hed, Hmd, Hm);
                                                                            s.addMed(head);
                                                                            System.out.println(head.getDrugName() + " successfully added!\n");
                                                                            break;
                                                                        default:
                                                                            System.out.println("Invalid Option!");
                                                                            break;
                                                                    }
                                                                } while (addM);
                                                                break;
                                                            //modify 
                                                            case 2:
                                                                System.out.println("\t≣ MODIFY MEDICINE\n");
                                                                System.out.println("\nNO FUNCTION YET...UNDERCONSTRUCTION!\n\n");
                                                                break;

                                                            //delete medicine
                                                            case 3:
                                                                int delete;
                                                                boolean delM = true;
                                                                do {
                                                                    System.out.println("\t≣ DELETE MEDICINE\n");
                                                                    System.out.println("\n☛Press 1 to delete Allergies Medicines\n☛Press 2 to delete Body Pain Medicines\n☛Press 3 to delete Cough Medicines\n☛Press 4 to delete Headache Medicines\n☛Press 0 to Back\n");
                                                                    System.out.print("Select: ");
                                                                    delete = sc.nextInt();
                                                                    switch (delete) {
                                                                        case 0:
                                                                            delM = false;
                                                                            break;
                                                                        case 1:
                                                                            boolean delA = true;
                                                                            s.viewAllergiesMed();
                                                                            System.out.println("Press 0 if done..");
                                                                            do {
                                                                                System.out.print("Select medicine no. to delete: ");
                                                                                int dam = sc.nextInt();
                                                                                switch (dam) {
                                                                                    case 0:
                                                                                        delA = false;
                                                                                        System.out.println("You are done deleting medicines!\n");
                                                                                        break;
                                                                                    default:
                                                                                        if (dam > s.allergiesList.size()) {
                                                                                            System.out.println("Invalid Input!");
                                                                                        } else {
                                                                                            System.out.println("You deleted " + s.allergiesList.get(dam - 1).getDrugName() + " succesfully!");
                                                                                            s.deleteAllergiesMed(dam - 1);
                                                                                        }
                                                                                        break;
                                                                                }

                                                                            } while (delA);

                                                                            break;
                                                                        case 2:
                                                                            boolean delB = true;
                                                                            s.viewBodyPainMed();
                                                                            System.out.println("Press 0 if done..");
                                                                            do {
                                                                                System.out.print("Select medicine no. to delete: ");
                                                                                int dBm = sc.nextInt();
                                                                                switch (dBm) {
                                                                                    case 0:
                                                                                        delB = false;
                                                                                        System.out.println("You are done deleting medicines!\n");
                                                                                        break;
                                                                                    default:
                                                                                        if (dBm > s.bodypainList.size()) {
                                                                                            System.out.println("Invalid Input!");
                                                                                        } else {
                                                                                            System.out.println("You deleted " + s.bodypainList.get(dBm - 1).getDrugName() + " succesfully!");
                                                                                            s.deleteBodyPainMed(dBm - 1);
                                                                                        }
                                                                                        break;
                                                                                }

                                                                            } while (delB);
                                                                            break;

                                                                        case 3:
                                                                            boolean delC = true;
                                                                            s.viewCoughMed();
                                                                            System.out.println("Press 0 if done..");
                                                                            do {
                                                                                System.out.print("Select medicine no. to delete: ");
                                                                                int dCm = sc.nextInt();
                                                                                switch (dCm) {
                                                                                    case 0:
                                                                                        delC = false;
                                                                                        System.out.println("You are done deleting medicines!\n");
                                                                                        break;
                                                                                    default:
                                                                                        if (dCm > s.coughList.size()) {
                                                                                            System.out.println("Invalid Input!");
                                                                                        } else {
                                                                                            System.out.println("You deleted " + s.coughList.get(dCm - 1).getDrugName() + " succesfully!");
                                                                                            s.deleteCoughMed(dCm - 1);
                                                                                        }
                                                                                        break;
                                                                                }

                                                                            } while (delC);
                                                                            break;

                                                                        case 4:
                                                                            boolean delH = true;
                                                                            s.viewHeadacheMed();
                                                                            System.out.println("Press 0 if done..");
                                                                            do {
                                                                                System.out.print("Select medicine no. to delete: ");
                                                                                int dHm = sc.nextInt();
                                                                                switch (dHm) {
                                                                                    case 0:
                                                                                        delH = false;
                                                                                        System.out.println("You are done deleting medicines!\n");
                                                                                        break;
                                                                                    default:
                                                                                        if (dHm > s.headacheList.size()) {
                                                                                            System.out.println("Invalid Input!");
                                                                                        } else {
                                                                                            System.out.println("You deleted " + s.headacheList.get(dHm - 1).getDrugName() + " succesfully!");
                                                                                            s.deleteHeadacheMed(dHm - 1);
                                                                                        }
                                                                                        break;
                                                                                }

                                                                            } while (delH);
                                                                            break;

                                                                        default:
                                                                            System.out.println("Invalid Option!");
                                                                            break;
                                                                    }
                                                                } while (delM);

                                                                break;
                                                            default:
                                                                System.out.println("Invalid Option!");
                                                                break;
                                                        }
                                                    } while (cmmed);
                                                    break;
                                                //VIEW CUSTOMER
                                                case 3:
                                                    int vc;
                                                    boolean vcb = true;
                                                    s.viewCustomers();
                                                    do {
                                                        System.out.println("\n---------------------------------------------------");
                                                        System.out.println("\t≣VIEW CUSTOMERS");

                                                        System.out.println("\n☛Press 1 to view ADULT details\n☛Press 2 to view SENIOR details\n☛Press 0 to Back\n");
                                                        System.out.println("---------------------------------------------------");
                                                        System.out.print("➛Select: ");
                                                        vc = sc.nextInt();
                                                        switch (vc) {
                                                            case 0:
                                                                vcb = false;
                                                                break;
                                                            case 1:
                                                                s.viewAdult();
                                                                break;
                                                            case 2:
                                                                s.viewSenior();
                                                                break;

                                                            default:
                                                                System.out.println("Invalid option!\n");
                                                                break;
                                                        }
                                                    } while (vcb);

                                                    break;

                                                //VIEW CUSTOMER ORDERS
                                                case 4:
                                                    System.out.println("\nNO FUNCTION YET...UNDERCONSTRUCTION!\n\n");
                                                    s.viewCustomers();
                                                    System.out.println("Press 0 if done...");
                                                    int vco;
                                                    boolean vcoB = true;
                                                    do {
                                                        System.out.print("Select customer no. to view his/her orders:");
                                                        vco = sc.nextInt();
                                                        switch (vco) {
                                                            case 0:
                                                                vcoB = false;
                                                                break;
                                                            default:
                                                                if (vco > s.customerList.size()) {
                                                                    System.out.println("Invalid Input!");
                                                                } else {
                                                                    if (s.madeOrder == false) {
                                                                        System.out.println("----------------------------------------------------------");
                                                                        System.out.println(s.customerList.get(vco - 1).getName() + " have not yet place orders!");
                                                                        System.out.println("----------------------------------------------------------");
                                                                    } else {
                                                                        s.viewOrder(s.customerList.get(vco - 1));
                                                                    }
                                                                }
                                                                break;
                                                        }

                                                    } while (vcoB);

                                                    break;
                                                default:
                                                    System.out.println("Invalid option!\n");
                                                    break;
                                            }
                                        } while (phOpBol);

                                        y = false;
                                        break;
                                    } else {
                                        System.out.println("\n\n✖Password and Username do not exist or mismatch! Try again!\n");
                                    }
                                } while (y);

                                break;
                            default:
                                System.out.println("Invalid option!");
                                break;
                        }
                    } while (in);

                    break;
                default:
                    System.out.println("Invalid option!");
                    break;

            }
        } while (ent);

    }

}
