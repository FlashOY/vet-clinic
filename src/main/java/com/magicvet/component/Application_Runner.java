package main.java.com.magicvet.component;

import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;


public class Application_Runner {

    private static final ClientService clientServise = new ClientService();
    private static final PetService petService = new PetService();
    public static void run() {
        if (Autenticator.auth()) {
           Client client = clientServise.registerNewClient();

           if(client != null) {
               System.out.println("Adding a new pet.");
              Pet pet = petService.registerNewPet();
              client.setPet(pet);
              pet.setOwnerName(client.getFirstName() + " " + client.getLastname());
               System.out.println("Pet has been added.");

               System.out.println(client);
           }
        }
    }
}