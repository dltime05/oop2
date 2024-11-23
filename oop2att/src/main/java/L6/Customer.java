package L6;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.Objects;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Customer implements Comparable<Customer> {
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private String phoneNumber;

    @Override
    public int compareTo(Customer o) {
        return surname.compareTo(o.surname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return name.equals(customer.name) &&
                surname.equals(customer.surname) &&
                phoneNumber.equals(customer.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phoneNumber);
    }
}