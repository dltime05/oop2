package L5.service;

import L5.model.Person.Person;
import L5.model.Vagon.*;
import org.junit.jupiter.api.Test;

import L5.exception.VagonIsFreeException;
import L5.model.Vagon.Vagon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VagonSellerManagerTest {
    private VagonSellerManager vagonSellerManager;
    private Vagon platskart;
    private Person personPlatskart;

    @BeforeEach
    void setUp() {
        vagonSellerManager = new VagonSellerManager();
        platskart = new Platskart();
        personPlatskart = new Person("John Doe", VagonType.Platskart, LocalDate.of(1990, 5, 15), LocalDate.of(2024, 11, 15));
    }

    @AfterEach
    void tearDown() {
        platskart.clearVagon();
    }

    @Test
    void addPersonToVagon_success() {
        assertDoesNotThrow(() -> vagonSellerManager.addPersonToVagon(platskart, personPlatskart), "Должно быть возможно назначить человек на нужный тип вагона.");
        assertTrue(vagonSellerManager.vagons.containsKey(VagonType.Platskart), "Вагон должен быть добавлен в список.");
        assertEquals(1, platskart.getPersons().size(), "Человек должен быть добавлен к автомобилю.");
    }

    @Test
    void addPersonToVagon_vagonIsFree() {
        assertDoesNotThrow(() -> vagonSellerManager.addPersonToVagon(platskart, personPlatskart)); // Занимаем машину клиентом SUV
        Person personSidyachiy = new Person("John Pork", VagonType.Platskart, LocalDate.of(1990, 5, 15), LocalDate.of(2024, 11, 15)); // Создаем нового клиента для SUV
        assertThrows(VagonIsFreeException.class, () -> vagonSellerManager.addPersonToVagon(platskart, personSidyachiy), "Ожидается исключение VagonIsFreeException");
    }
}