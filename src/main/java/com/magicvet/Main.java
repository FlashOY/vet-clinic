package main.java.com.magicvet;

import main.java.com.magicvet.component.Application_Runner;

import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

import static main.java.com.magicvet.component.Autenticator.auth;

public class Main {


     public static Scanner SCANNER = new Scanner(System.in);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Do you want to register a pet right now? (yes/no): ");

        String wantsRegistrationInput = scanner.nextLine().toLowerCase();
        boolean wantsRegistration = wantsRegistrationInput.equals("yes");
        if(wantsRegistration) {
        Application_Runner runner = new Application_Runner();
        runner.run(); }
        else {
            System.out.println("Have a niceday!!!");
        }
    }

    }



