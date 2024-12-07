package L5.model.Vagon;
import L5.model.Person.Person;

public class Platskart extends Vagon {
    public Platskart() {
        super(VagonType.Platskart);
    }

    public void clearVagon() {
        getPersons().clear();
    }

    public void removePersonFromVagon(Person person) {
        getPersons().removeIf(c -> c.equals(person));
    }

    @Override
    public void addPersonToVagon(Person person) {
        getPersons().add(person);
    }
}