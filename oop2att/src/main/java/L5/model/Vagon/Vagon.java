package L5.model.Vagon;

import L5.model.Person.Person;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public abstract class Vagon {
    @Getter
    private final VagonType vagonType;
    private final List<Person> persons;

    public Vagon(VagonType carType) {
        this.vagonType = carType;
        this.persons = new ArrayList<>();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void clearVagon() {
        persons.clear();
    }

    public void removePersonFromVagon(Person person) {
        persons.removeIf(c -> c.equals(person));
    }

    public void addPersonToVagon(Person person) {
        persons.add(person);
    }

}
