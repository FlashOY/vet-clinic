package main.java.com.magicvet;

import main.java.com.magicvet.component.Application_Runner;
//import main.java.com.magicvet.model.Client;

import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

import static main.java.com.magicvet.component.Autenticator.auth;

public class Main {


   public static Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) {
        Application_Runner runner = new Application_Runner();
        runner.run();
    }

    }



