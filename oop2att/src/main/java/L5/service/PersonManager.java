package L5.service;

import L5.exception.InvalidDateException;
import L5.model.Person.Person;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class PersonManager {

    private static final Pattern DATE_PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");

    public void setTravelDate(Person person, String date) {
        validateDate(date);
        person.setTravelDate(LocalDate.parse(date));
    }

    private void validateDate(String date) {
        if (!DATE_PATTERN.matcher(date).matches()) {
            throw new InvalidDateException("Date format should be YYYY-MM-DD");
        }
        if (LocalDate.parse(date).isBefore(LocalDate.now())) {
            throw new InvalidDateException("Cannot set a past date for travel.");
        }
    }
}