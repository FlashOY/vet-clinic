package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;
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
               registerPets(client);
               System.out.println(client);
           }
        }
    }

    private static void registerPets(Client client){
        boolean continueAddPets = true;

        while (continueAddPets) {
            addPet(client);
            System.out.println("Do you want to add pets for the current clients? (y/n): ");
            String answer = Main.SCANNER.nextLine();

            if ("n".equals(answer)) {
                continueAddPets = false;

             //   continueAddPets =!"n".equals(answer); другий варіант
                //   continueAddPets ="y".equals(answer); третій варіант але кращий варіант перший


            }
        }
    }

    private static void addPet(Client client) {
        System.out.println("Adding a new pet.");


        Pet pet = petService.registerNewPet();
        if (pet != null) {
            client.addPet(pet);
            pet.setOwnerName(client.getFirstName() + " " + client.getLastname());
            System.out.println("Pet has been added.");
        }
    }
}
