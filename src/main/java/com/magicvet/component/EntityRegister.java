package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;

import java.util.*;

public class EntityRegister {

    private static final ClientService clientServise = new ClientService();
    private static final PetService petService = new PetService();

    static void registerClients() {
        List<Client> clients = new ArrayList<>();
        String message = "Do you want to register more clients? (y/n):";
        do {
           Client client = addClient();
            if(client != null ) {
                clients.add(client);
            }
        } while (verifyPepeating(message));

        Map <Client.Location,List<Client>> clientsByLocation = groupClients(clients) ;
        PriClients(clientsByLocation);
    }

    private static void PriClients(Map<Client.Location, List<Client>> clientsByLocation) {
        for (Map.Entry<Client.Location, List<Client>> clients : clientsByLocation.entrySet()
             ) {
            String content = "\nLocation: "+ clients.getKey()
            + "\nClients (" + clients.getValue().size() + "):"
                    + "\n\t" + clients.getValue();
            System.out.println(content);
        }
    }

    private static Map<Client.Location, List<Client>> groupClients(List<Client> clients) {
       List<Client> fromKyiv = new ArrayList<>();
       List<Client> fromLviv = new ArrayList<>();
       List<Client> fromOdessa = new ArrayList<>();
        List<Client> unknownLocation = new ArrayList<>();

       for(Client client : clients ) {
           switch(client.getLocation()) {
               case KYIV -> fromKyiv.add(client);
               case LVIV -> fromLviv.add(client);
               case ODESSA -> fromOdessa.add(client);
               case UNKNOWN -> unknownLocation.add(client);
           }
       }

        Map <Client.Location,List<Client>> clientsByLocation = new HashMap<>();
       clientsByLocation.put(Client.Location.KYIV, fromKyiv);
        clientsByLocation.put(Client.Location.LVIV, fromLviv);
        clientsByLocation.put(Client.Location.ODESSA, fromOdessa);
        clientsByLocation.put(Client.Location.UNKNOWN, unknownLocation);

        return clientsByLocation;
    }

    private static Client addClient () {
        Client client = clientServise.registerNewClient();

        if(client != null) {
            registerPets(client);
            System.out.println(client);
        }

        return client;
    }

    public static void registerPets(Client client){

        String message_2 = "Do you want to add pets for the current clients? (y/n): ";
        do  {
            addPet(client);

        } while (verifyPepeating(message_2));
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

    private static boolean verifyPepeating(String message){
        System.out.println(message);

        String answer = Main.SCANNER.nextLine();
        if("y".equals(answer)) {
            return true;
        } else if ("n".equals(answer)) {
            return false;
        } else {
            System.out.println("Incorrect answer. Please try again.");
            return verifyPepeating(message); //рекурсивний запуск методу у разі вводу некоректного значення
        }
    }
}
