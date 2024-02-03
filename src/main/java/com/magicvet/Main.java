package main.java.com.magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String PASSWORD = "default";
    static Scanner SCANNER = new Scanner(System.in);

    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String NAME_PATTERN = "^[a-zA-Z-]{3,}+$";
    static String LASTNAME_PATTERN = "^[a-zA-Z-]{3,}$";

    public static void main(String[] args) {
        run();
    }
    static void run() {
        if (auth()) {
            registerNewClient();
        }
    }
        static boolean auth() {
            boolean accepted = false;
            for (int i = 0; i < 3; i++){
                System.out.println("Password");
                String input = SCANNER.nextLine();

                if (PASSWORD.equals(input)) {
                    accepted = true;
                    break;
                } else {
                    System.out.println("Acsess denied. Please check your password");
                }
            }

            System.out.println(accepted ? "Welcome to the Magic Vet" : "Application has been blocked" );

            return accepted;
        }

        static void registerNewClient() {
            System.out.println("Please provide a client details");
            System.out.print("Email: ");
            String email = SCANNER.nextLine();

            System.out.println("First name: ");
            String name = SCANNER.nextLine();

            System.out.println("Last name: ");
            String lastname = SCANNER.nextLine();




            if (isEmailValid(email)) {
                if(isNameValid(name)){
                    if(isLastNameValid(lastname)) {
                        Client client = buildClient(email, name, lastname);
                        System.out.println("New client: " + client.firstName + " " + client.lastname + " (" + client.email + ")");
                    } else {
                        System.out.println("Provided lastname is invalid.");
                    }
            } else {
                System.out.println("Provided name is invalid.");
            }
        } else {
                System.out.println("Provided email is invalid.");
            }


    }
//Checking name, email, lastname
    private static boolean isLastNameValid(String lastname) {
        Pattern pattern_lastname = Pattern.compile(LASTNAME_PATTERN);
        Matcher matcher2 = pattern_lastname.matcher(lastname);
        return matcher2.matches();
    }

    private static boolean isNameValid(String name) {
        Pattern pattern_name = Pattern.compile(NAME_PATTERN);
        Matcher matcher1 = pattern_name.matcher(name);
        return matcher1.matches();
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern_email = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern_email.matcher(email);
        return matcher.matches();
    }



    /*
        static boolean isEmailValid(String email, String name, String lastname) {
            Pattern pattern_email = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern_email.matcher(email);

            Pattern pattern_name = Pattern.compile(NAME_PATTERN);
            Matcher matcher1 = pattern_name.matcher(name);

            Pattern pattern_lastname = Pattern.compile(LASTNAME_PATTERN);
            Matcher matcher2 = pattern_lastname.matcher(lastname);


            return matcher.matches();
        }
    */
     static Client buildClient(String email, String name, String lastname) {
        Client client = new Client();
        client.email = email;
         client.firstName = name;
         client.lastname = lastname;


        // System.out.println("First name: ");
       //  client.firstName = SCANNER.nextLine();

       //  System.out.println("Last name: ");
        // client.lastname = SCANNER.nextLine();

         return  client;
    }


}
