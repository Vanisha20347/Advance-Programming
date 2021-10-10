import java.util.*;

public class A1_2020347 {
    static Scanner scn = new Scanner(System.in);

    static ArrayList<Vaccine> vaccine_added = new ArrayList<>();

    public static class Vaccine {
        String vaccine_name;
        int Number_of_Doses;
        int Gap_between_Doses;

        Vaccine(String m, int n, int s) {
            vaccine_name = m;
            Number_of_Doses = n;
            Gap_between_Doses = s;
        }
    }

    public static void add_vaccine() {
        String k;
        int m, n = 0;
        System.out.print("Vaccine Name:");
        k = scn.next();
        System.out.print("Number of Doses:");
        m = scn.nextInt();
        if (m != 1) {
            System.out.print("Gap between Doses:");
            n = scn.nextInt();
        }

        Vaccine j = new Vaccine(k, m, n);
        vaccine_added.add(j);
        System.out.print(String.format("Vaccine Name: %s, Number of Doses: %d, Gap Between Doses: %d\n", k, m, n));
    }

    static ArrayList<Hospital> hospital_registered = new ArrayList<>();
    static int count = 0;

    public static class Hospital {
        String Hospital_Name;
        int PinCode;
        String Unique_ID;

        Hospital(String m, int n, String x) {
            Hospital_Name = m;
            PinCode = n;
            Unique_ID = x;
        }
    }

    public static void register_hospital() {
        String k;
        int n;
        System.out.print("Hospital Name:");
        k = scn.next();
        System.out.print("PinCode:");
        n = scn.nextInt();
        String jk = String.format("%06d", count);
        count++;
        Hospital h = new Hospital(k, n, jk);
        hospital_registered.add(h);
        System.out.print(String.format("Hospital Name: %s, PinCode: %d, Unique ID: %s\n", k, n, jk));
    }

    static ArrayList<Citizen> citizen_registered = new ArrayList<>();

    public static class Citizen {
        String Name;
        int Age;
        long Unique_ID;
        String vaccination_status = "REGISTERED";
        String Vaccine_taken;
        int no_of_doses_taken = 0;
        int Next_Dose_due_date = 0;

        Citizen(String m, int n, long x) {
            Name = m;
            Age = n;
            Unique_ID = x;
        }
    }

    public static void register_citizen() {
        String k;
        int n;
        long m;
        System.out.print("Citizen Name:");
        k = scn.next();
        System.out.print("Age:");
        n = scn.nextInt();
        System.out.print("Unique ID:");
        m = scn.nextLong();
        System.out.print(String.format("Citizen Name: %s, Age: %d, Unique ID: %d\n", k, n, m));
        if (n >= 18) {
            Citizen c = new Citizen(k, n, m);
            citizen_registered.add(c);
        } else {
            System.out.println("Only above 18 are allowed");
        }
    }

    static ArrayList<Slots> slots_created = new ArrayList<>();

    public static class Slots {
        String Hospital_ID;
        int number_of_Slots, Day_Number, Quantity;
        String vaccinename;

        Slots(String h, int s, int d, int q, String v) {
            Hospital_ID = h;
            number_of_Slots = s;
            Day_Number = d;
            Quantity = q;
            vaccinename = v;
        }
    }

    public static void creating_slots() {
        int n, p, q, option;
        String m;
        System.out.print("Enter Hospital ID:");
        m = scn.next();
        int just = 0;
        for (int i = 0; i < hospital_registered.size(); i++) {
            if (hospital_registered.get(i).Unique_ID.equals(m)) {
                just++;
            }
        }
        if (just == 0) {
            System.out.println("Hospital Not Registered");
            return;
        }

        System.out.print("Enter number of Slots to be added:");
        n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Day Number:");
            p = scn.nextInt();
            System.out.print("Enter Quantity:");
            q = scn.nextInt();
            System.out.println("Select Vaccine");
            ArrayList<String> v = new ArrayList<>();
            for (int j = 0; j < vaccine_added.size(); j++) {
                System.out.print(String.format("%d. %s\n", j, vaccine_added.get(j).vaccine_name));
                v.add(vaccine_added.get(j).vaccine_name);
            }
            option = scn.nextInt();
            String g = v.get(option);
            System.out.println(String
                    .format("Slot added by Hospital %s for Day: %d, Available Quantity: %d of Vaccine %s", m, p, q, g));
            Slots f = new Slots(m, n, p, q, g);
            slots_created.add(f);
        }
    }

    static ArrayList<Slots> days_available_for_same_hospitalid = new ArrayList<>();

    public static void booking_slot() {
        int option;
        long m;
        System.out.print("Enter patient Unique ID:");
        m = scn.nextLong();
        int just = 0;

        for (int yt = 0; yt < citizen_registered.size(); yt++) {
            if (citizen_registered.get(yt).Unique_ID == m) {
                just++;
            }
        }
        if (just == 0) {
            System.out.println("Citizen Not Registered");
            return;
        }

        for (int tr = 0; tr < citizen_registered.size(); tr++) {
            if (citizen_registered.get(tr).Unique_ID == m) {
                if (citizen_registered.get(tr).vaccination_status.equals("FULLY VACCINATED")) {
                    System.out.print("The Citizen is already fully vaccinated \n");
                    return;
                }
            }
        }
        String s = "";
        System.out.print("1. Search by area \n2. Search by Vaccine \n3. Exit");
        System.out.print("\nEnter option:");
        option = scn.nextInt();
        boolean b = true;
        switch (option) {
            case 1:
                int w;
                System.out.print("Enter PinCode:");
                w = scn.nextInt();
                b = false;
                int var = 0;
                for (int i = 0; i < hospital_registered.size(); i++) {
                    if (hospital_registered.get(i).PinCode == w) {
                        String ui = hospital_registered.get(i).Unique_ID;
                        for (int u = 0; u < slots_created.size(); u++) {
                            if (slots_created.get(u).Hospital_ID.equals(ui)) {
                                if (slots_created.get(u).Quantity > 0) {
                                    System.out.println(hospital_registered.get(i).Unique_ID + " "
                                            + hospital_registered.get(i).Hospital_Name);
                                    var++;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (var == 0) {
                    System.out.println("No Hospitals registered for the given pincode having vaccine");
                    return;
                }

                break;
            case 2:

                System.out.print("Enter Vaccine name:");
                s = scn.next();
                b = true;
                int hj = 0;
                for (int i = 0; i < slots_created.size(); i++) {
                    if (slots_created.get(i).vaccinename.equals(s) && slots_created.get(i).Quantity > 0) {
                        hj++;
                        String y = slots_created.get(i).Hospital_ID;
                        String d = "";
                        for (int j = 0; j < hospital_registered.size(); j++) {
                            if (hospital_registered.get(j).Unique_ID.equals(y)) {
                                d = hospital_registered.get(j).Hospital_Name;
                                System.out.println(String.format("%s %s", slots_created.get(i).Hospital_ID, d));
                            }

                        }
                    }
                }
                if (hj == 0) {
                    System.out.println("This Vaccine is not available in any of the registered hospitals");
                    return;
                }
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid No.");

        }
        ArrayList<Integer> index = new ArrayList<>();
        String hi;
        System.out.print("Enter hospital id:");
        hi = scn.next();
        int due = 0;
        for (int t = 0; t < citizen_registered.size(); t++) {
            if (citizen_registered.get(t).Unique_ID == m) {
                due = citizen_registered.get(t).Next_Dose_due_date;
            }
        }

        for (int i = 0; i < slots_created.size(); i++) {
            if (hi.equals(slots_created.get(i).Hospital_ID)) {
                if (due <= slots_created.get(i).Day_Number) {
                    if (b == false) {
                        System.out.println(i + "-> Day:" + slots_created.get(i).Day_Number + " Available Qty:"
                                + slots_created.get(i).Quantity + " Vaccine:" + slots_created.get(i).vaccinename);
                        days_available_for_same_hospitalid.add(slots_created.get(i));
                        index.add(i);

                    }

                    else if ((b == true) && (slots_created.get(i).vaccinename.equals(s))) {
                        System.out.println(i + "-> Day:" + slots_created.get(i).Day_Number + " Available Qty:"
                                + slots_created.get(i).Quantity + " Vaccine:" + slots_created.get(i).vaccinename);
                        days_available_for_same_hospitalid.add(slots_created.get(i));
                        index.add(i);
                    }
                } else {
                    System.out.print("No slots available. The person is booking before its due date.\n");
                    return;
                }
            }
        }

        int ch;
        System.out.print("Choose Slot:");
        ch = scn.nextInt();

        days_available_for_same_hospitalid.get(ch).Quantity--;
        for (int i = 0; i < citizen_registered.size(); i++) {
            if (citizen_registered.get(i).Unique_ID == m) {
                citizen_registered.get(i).Vaccine_taken = days_available_for_same_hospitalid.get(ch).vaccinename;
                citizen_registered.get(i).no_of_doses_taken++;
                for (int gh = 0; gh < vaccine_added.size(); gh++) {
                    if (days_available_for_same_hospitalid.get(ch).vaccinename
                            .equals(vaccine_added.get(gh).vaccine_name)) {
                        if (citizen_registered.get(i).no_of_doses_taken < vaccine_added.get(gh).Number_of_Doses) {
                            citizen_registered.get(i).vaccination_status = "PARTIALLY VACCINATED";
                            if (citizen_registered.get(i).no_of_doses_taken == 1) {
                                citizen_registered.get(i).Next_Dose_due_date = days_available_for_same_hospitalid
                                        .get(ch).Day_Number;
                            }

                            citizen_registered.get(i).Next_Dose_due_date += vaccine_added.get(gh).Gap_between_Doses;

                        } else if (citizen_registered.get(i).no_of_doses_taken == vaccine_added
                                .get(gh).Number_of_Doses) {
                            citizen_registered.get(i).vaccination_status = "FULLY VACCINATED";
                        }
                    }
                }
                System.out.println(String.format("%s vaccinated with %s", citizen_registered.get(i).Name,
                        days_available_for_same_hospitalid.get(ch).vaccinename));
            }
        }
    }

    public static void slots_avaiable() {
        String id;
        System.out.print("Enter Hospital Id: ");
        id = scn.next();
        int just = 0;
        for (int i = 0; i < hospital_registered.size(); i++) {
            if (hospital_registered.get(i).Unique_ID.equals(id)) {
                just++;
            }
        }
        if (just == 0) {
            System.out.println("Hospital Not Registered");
            return;
        }
        for (int i = 0; i < slots_created.size(); i++) {
            if (slots_created.get(i).Hospital_ID.equals(id)) {
                System.out.println("Day: " + slots_created.get(i).Day_Number + " Vaccine:"
                        + slots_created.get(i).vaccinename + " Available Qty:" + slots_created.get(i).Quantity);
            }
        }
    }

    public static void Vaccination_Status() {
        long pi;
        System.out.print("Enter Patient ID:");
        pi = scn.nextLong();
        int just = 0;

        for (int yt = 0; yt < citizen_registered.size(); yt++) {
            if (citizen_registered.get(yt).Unique_ID == pi) {
                just++;
            }
        }
        if (just == 0) {
            System.out.println("Citizen Not Registered");
            return;
        }

        for (int i = 0; i < citizen_registered.size(); i++) {
            if (pi == citizen_registered.get(i).Unique_ID) {
                if (citizen_registered.get(i).vaccination_status == "REGISTERED") {
                    System.out.println("Citizen REGISTERED");
                } else if (citizen_registered.get(i).vaccination_status == "PARTIALLY VACCINATED") {
                    System.out.println("PARTIALLY VACCINATED");
                    System.out.println("Vaccine Given: " + citizen_registered.get(i).Vaccine_taken
                            + "\nNumber of Doses given: " + citizen_registered.get(i).no_of_doses_taken
                            + "\nNext Dose due date: " + citizen_registered.get(i).Next_Dose_due_date);
                } else if (citizen_registered.get(i).vaccination_status == "FULLY VACCINATED") {
                    System.out.println("FULLY VACCINATED");
                    System.out.println("Vaccine Given: " + citizen_registered.get(i).Vaccine_taken
                            + "\nNumber of Doses given: " + citizen_registered.get(i).no_of_doses_taken);
                }
            }
        }
    }

    public static void main(String[] args) {
        int choice = 0;
        System.out.println("\nCoWin Portal initialized....");
        while (choice != 8) {
            System.out.println(
                    "---------------------------------\n 1. Add Vaccine \n 2. Register Hospital \n 3. Register Citizen \n 4. Add Slot for Vaccination \n 5. Book Slot for Vaccination \n 6. List all slots for a hospital \n 7. Check Vaccination Status \n 8. Exit \n---------------------------------");
            choice = scn.nextInt();
            switch (choice) {
                case 1:
                    add_vaccine();
                    break;
                case 2:
                    register_hospital();
                    break;
                case 3:
                    register_citizen();
                    break;
                case 4:
                    creating_slots();
                    break;
                case 5:
                    booking_slot();
                    break;
                case 6:
                    slots_avaiable();
                    break;
                case 7:
                    Vaccination_Status();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Enter valid number.");
            }
        }
    }
}