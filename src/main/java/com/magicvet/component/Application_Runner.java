package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;


public class Application_Runner {

private static final EntityRegister register = new EntityRegister();
    public static void run() {
       if (Autenticator.auth()) {
           register.registerClients();
       }
    }


}
