package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;

public class Autenticator {

 private   static String PASSWORD = "d";

  public   static boolean auth() {
        boolean accepted = false;
        for (int i = 0; i < 3; i++){
            System.out.println("Password");
            String input = Main.SCANNER.nextLine();

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
}
