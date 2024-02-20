package main.java.com.magicvet.model;

import java.util.Objects;

public class Client {
   private String firstName;
   private String lastname;
   private  String email;
   private  Pet pet;


   @Override
   public String toString() {
       return "Client {"
               +"\n\tfirstName = " + firstName
               + ", lastName = " + lastname
               + ", email = " + email
              + "\n\tpet= " + pet
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
                && Objects.equals(pet, client.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastname, email, pet);
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

    public Pet getPet() {
        return pet;
    }


    public void setPet(Pet pet) {
        this.pet = pet;
    }
}

