package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
  private   static String NAME_PATTERN = "^[a-zA-Z-]{3,}+$";
  private   static String LASTNAME_PATTERN = "^[a-zA-Z-]{3,}$";

public Client registerNewClient() {
    Client client = null;

        System.out.println("Please provide a client details");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();

        System.out.println("First name: ");
        String name = Main.SCANNER.nextLine();

        System.out.println("Last name: ");
        String lastname = Main.SCANNER.nextLine();




        if (isEmailValid(email)) {
            if(isNameValid(name)){
                if(isLastNameValid(lastname)) {
                    client = buildClient(email, name, lastname);
                    System.out.println("New client: " + client.getFirstName()
                            + " " + client.getLastname() + " ("
                            + client.getEmail() + ")");
                } else {
                    System.out.println("Provided lastname is invalid.");
                }
            } else {
                System.out.println("Provided name is invalid.");
            }
        } else {
            System.out.println("Provided email is invalid.");
        }

        return client;
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
  private  static Client buildClient(String email, String name, String lastname) {
        Client client = new Client();
        client.setEmail(email);
        client.setFirstName(name);
        client.setLastname(lastname);


        // System.out.println("First name: ");
        //  client.firstName = SCANNER.nextLine();

        //  System.out.println("Last name: ");
        // client.lastname = SCANNER.nextLine();

        return  client;
    }

}
