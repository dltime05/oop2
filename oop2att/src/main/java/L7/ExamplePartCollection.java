package L7;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ExamplePartCollection<T> {
    private ExamplePartCollection<T> previous;
    private ExamplePartCollection<T> next;
    private T value;

    public ExamplePartCollection(T value) {
        this.value = value;
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExamplePartCollection<T> that = (ExamplePartCollection<T>) o;
        // Проверка равенства с использованием значения
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "ExamplePartCollection{" +
                "value=" + value +
                '}';
    }
}

