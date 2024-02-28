package main.java.com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

   private String firstName;
   private String lastname;
   private  String email;
   private List<Pet> pets = new ArrayList<>(); // таким чином поле pets ніколи не буде null (ініціализовано за замовчуванням)

    private Location location;


   private final LocalDateTime registrationClientDate = LocalDateTime.now();


   @Override
   public String toString() {
       return "Client {"
               +"\n\tfirstName = " + firstName
               + ", lastName = " + lastname
               + ", email = " + email
               + ", location = " + location
              + ", pets= " + pets
              +  "\n\tregistrationClientDate= " + registrationClientDate.format(FORMATTER)
               + "\n}";
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName)
                && Objects.equals(lastname, client.lastname)
                && Objects.equals(email, client.email)
                && Objects.equals(pets, client.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastname, email, pets);
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pet> getPets() {
        return pets;
    }


    public void setPets(List<Pet> pet) {
        this.pets = pet;
    }

    public void sortPetsByHealthState() {
        pets.sort(Pet.healthStateComparator);
    }


    public void addPet(Pet pet) {
       pets.add(pet);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public enum Location {
        KYIV,
        LVIV,
        ODESSA,
        UNKNOWN;
    }


}

