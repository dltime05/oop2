package L5.service;

import L5.model.Vagon.VagonType;
import org.junit.jupiter.api.DisplayName;
import L5.exception.InvalidDateException;
import L5.model.Person.Person;
import org.junit.jupiter.api.*;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PersonManagerTest {
    private static final Person person = new Person("John Doe", VagonType.Platskart, LocalDate.of(1990, 5, 15), null);
    private static final String VALID_DATE = "2024-11-15";
    private static final String INVALID_DATE_FORMAT = "2024/11/15";
    private static final String PAST_DATE = "2023-01-01";
    private final PersonManager personManager = new PersonManager();

    @Test
    @DisplayName("Позитивный тест: проверка установки правильной даты")
    void testSetValidRentalDate() throws InvalidDateException {
        personManager.setTravelDate(person, VALID_DATE);
        assertEquals(LocalDate.parse(VALID_DATE), person.getTravelDate(),"Дата не соответствует ожидаемой.");
    }

    @Test
    @DisplayName("Негативный тест: проверка установки даты в неправильном формате.\n" +
            "Ожидается исключение InvalidDateException")
    void testInvalidDateFormat() {
        assertThrows(InvalidDateException.class,
                () -> personManager.setTravelDate(person, INVALID_DATE_FORMAT),
                "Ожидалось исключение InvalidDateException из-за неверного формата даты.");
    }

    @Test
    @DisplayName("Негативный тест: проверка установки даты в прошлом.\n" +
            "Ожидается исключение InvalidDateException.")
    void testPastDate() {
        assertThrows(InvalidDateException.class,
                () -> personManager.setTravelDate(person, PAST_DATE),
                "Ожидалось исключение InvalidDateException из-за попытки установки прошедшей даты.");
    }
}
