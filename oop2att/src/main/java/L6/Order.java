package L6;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.Objects;

// Класс
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Order {
    @NonNull
    private int id;
    @NonNull
    private String OrderTime;
    @NonNull
    private Customer customer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order that = (Order) o;
        return id == that.id &&
                OrderTime.equals(that.OrderTime) &&
                customer.equals(that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, OrderTime, customer);
    }
}