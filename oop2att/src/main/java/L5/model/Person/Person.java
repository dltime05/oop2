package L5.model.Person;

import L5.model.Vagon.VagonType;

import java.time.LocalDate;
import java.util.Objects;


public class Person {
    private String name;
    private VagonType preferredVagonType;
    private LocalDate birthDate;
    private LocalDate travelDate;

    public Person(String name, VagonType preferredVagonType, LocalDate birthDate, LocalDate travelDate) {
        this.name = name;
        this.preferredVagonType = preferredVagonType;
        this.birthDate = birthDate;
        this.travelDate = travelDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VagonType getPreferredVagonType() { // Добавили геттер
        return preferredVagonType;
    }

    public void setPreferredVagonType(VagonType preferredVagonType) {
        this.preferredVagonType = preferredVagonType;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person other = (Person) obj;
        return Objects.equals(name, other.name) &&
                preferredVagonType == other.preferredVagonType &&
                birthDate.equals(other.birthDate) &&
                travelDate.equals(other.travelDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, preferredVagonType, birthDate, travelDate);
    }
}

