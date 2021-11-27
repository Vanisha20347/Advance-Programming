import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class A4_question1 {
    static Scanner scn = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();

    public static class Book {
        private String Title;
        private int ISBN;
        private int Barcode;

        Book(String m, int n, int s) {
            Title = m;
            ISBN = n;
            Barcode = s;
            b.add(Barcode);
        }

        public String get_title() {
            return Title;
        }

        public Integer get_ISBN() {
            return ISBN;
        }

        public Integer get_Barcode() {
            return Barcode;
        }
    }

    static ArrayList<Integer> b = new ArrayList<>();

    static class Sort implements Comparator<Book> {
        @Override
        public int compare(Book a, Book c) {
            int t = a.get_title().compareTo(c.get_title());
            int i = a.get_ISBN().compareTo(c.get_ISBN());
            int ba = a.get_Barcode().compareTo(c.get_Barcode());
            if (t == 0) {
                if (i == 0) {
                    return ba;
                } else {
                    return i;
                }
            } else {
                return t;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("                                  WELCOME TO THE LIBRARY");
        System.out.print("Enter the number of books :- ");
        int N = Integer.parseInt(scn.nextLine());
        System.out.print("Enter thr number of racks :- ");
        int K = Integer.parseInt(scn.nextLine());
        int slots = N / K;
        boolean hj = false;
        for (int i = 0; i < N; i++) {
            System.out.println("Enter the details of the book");
            System.out.print("Title:- ");
            String title = scn.nextLine();
            System.out.print("ISBN:- ");
            int ISBN = Integer.parseInt(scn.nextLine());
            System.out.print("Barcode:- ");
            int Barcode = Integer.parseInt(scn.nextLine());
            if (hj == false) {
                hj = true;
                Book h = new Book(title, ISBN, Barcode);
                books.add(h);
                System.out.println("Book Added!!");
            } else {
                boolean p =false;
                for (int j = 0; j < b.size(); j++) {
                    if (b.get(j) == Barcode) {
                        p=true;
                        System.out.println("Barcode must be unique");
                        System.out.println();
                        break;
                    }
                }
                if(p==false){
                        Book h = new Book(title, ISBN, Barcode);
                        books.add(h);
                        System.out.println("Book Added!!");
                }
            }
        }
        System.out.println();
        System.out.println("Books Details");
        for(int h=0;h<books.size();h++){
            System.out.println("Title:- "+ books.get(h).get_title());
            System.out.println("ISBN:- "+books.get(h).get_ISBN());
            System.out.println("Barcode:- "+books.get(h).get_Barcode());
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------");
        Collections.sort(books, new Sort());
        System.out.println("After Executing the plan");
        System.out.println("Books Details");
        int o=1;
        int r=1;
        for(int h=0;h<books.size();h++){
            System.out.println("Rack No:- " + r);
            System.out.println("Slot No:- " + o);
            if(o == slots){
                o=0;
                r++;
            }
            o++;
            System.out.println("Title:- "+ books.get(h).get_title());
            System.out.println("ISBN:- "+books.get(h).get_ISBN());
            System.out.println("Barcode:- "+books.get(h).get_Barcode());
            System.out.println();
        }
    }
}