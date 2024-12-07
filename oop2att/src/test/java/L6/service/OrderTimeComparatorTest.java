package L6.service;

import L6.Customer;
import L6.Order;
import L6.comparator.OrderTimeComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class OrderTimeComparatorTest {

    private static Customer customer1 = new Customer()
            .setName("Артём")
            .setSurname("Береснев")
            .setPhoneNumber("89611828910");
    private static Customer customer2 = new Customer()
            .setName("Грей")
            .setSurname("Гоев")
            .setPhoneNumber("+7952812");

    private static Order order1 = new Order()
            .setId(1)
            .setOrderTime("11:11")
            .setCustomer(customer1);
    private static Order order2 = new Order()
            .setId(2)
            .setOrderTime("17:59")
            .setCustomer(customer2);

    @Test
    @DisplayName("Сортировка только по заказчику")
    void sortByClient() {
        List<Order> requests = new ArrayList<>();
        requests.add(order2);
        requests.add(order1);
        requests.sort(Comparator.comparing(Order::getCustomer));
        Assertions.assertEquals(requests.get(0),order1);
        Assertions.assertEquals(requests.get(1),order2);
    }

    @Test
    @DisplayName("Сортировка только по id")
    void sortById() {
        List<Order> orders = new ArrayList<>();
        orders.add(order2);
        orders.add(order1);
        orders.sort(Comparator.comparing(Order::getId));
        Assertions.assertEquals(orders.get(0), order1);
        Assertions.assertEquals(orders.get(1), order2);
    }

    @Test
    @DisplayName("Сортировка только по времени")
    void sortByTitle() {
        List<Order> orders = new ArrayList<>();
        orders.add(order2);
        orders.add(order1);
        orders.sort(new OrderTimeComparator());
        Assertions.assertEquals(orders.get(0), order1);
        Assertions.assertEquals(orders.get(1), order2);
    }
}
