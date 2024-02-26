package main.java.com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;

public abstract class Pet {


    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
    private String type;
    private String sex;
    private String age;
    private String name;
    private String ownerName;

    private HealthState healthState;


   public void setHealthState(HealthState healthState) {
       this.healthState = healthState;
   }





    private  final LocalDateTime registrationDate = LocalDateTime.now();

    @Override
    public String toString() {
        return "Pet {"
                +"\n\ttype = " + type
                + ", sex = " + sex
                + ", age = " + age
                + ", name = " + name
                + ", ownerName = " + ownerName
                + ",registrationDate = " + registrationDate.format(FORMATTER)
                + ",\n\thealthState = " + healthState
                + "\n}";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(type, pet.type) && Objects.equals(sex, pet.sex) && Objects.equals(age, pet.age) && Objects.equals(name, pet.name) && Objects.equals(ownerName, pet.ownerName) && Objects.equals(healthState, pet.healthState);
    }



    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName, healthState);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

            public LocalDateTime
            getRegistrationDate() {
        return registrationDate;
    }

    public HealthState getHealthState() {
        return healthState;
    }

    public static Comparator<Pet> healthStateComparator = Comparator.comparing(Pet::getHealthState);


    public static enum HealthState {
        GOOD(1),
        MEDIUM(2),
        CRITICAL(3),
        UNKNOWN(0);

        private final int value_1;

        HealthState(int value_1) {
            this.value_1 = value_1;

        }

        public static Pet.HealthState fromString(String value_1) {
            for (Pet.HealthState healthState : values()) {
                if (healthState.toString().equals(value_1)) {
                    return healthState;
                }
            }

            System.out.println("Unable to parse value '" + value_1 + "'. Using default value: " + UNKNOWN);

            return UNKNOWN;
        }

        public int getValue_1() {
            return value_1;


        }
    }
}
