package L5.service;

import L5.exception.VagonIsFreeException;
import L5.exception.WrongVagonTypeException;
import L5.model.Person.Person;
import L5.model.Vagon.Vagon;
import L5.model.Vagon.VagonType;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VagonSellerManager {
    final Map<VagonType, Vagon> vagons = new HashMap<>();

    public void addPersonToVagon(Vagon vagon, Person person) throws WrongVagonTypeException {
        try {
            checkCarAvailabilityAndType(vagon, person);
            vagon.addPersonToVagon(person);
            vagons.put(vagon.getVagonType(), vagon);
            log.info("Клиенту присвоен нужный тип вагона: {}", vagon.getVagonType());
        } catch (VagonIsFreeException | WrongVagonTypeException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            logRentalStatus(vagon);
        }
    }

    private void logRentalStatus(Vagon vagon) {
        if (vagons.containsKey(vagon.getVagonType())) {
            log.info("Вагон {} доступен.", vagon.getVagonType());
        } else {
            log.warn("Вагон {} не доступен.", vagon.getVagonType());
        }
    }

    private void checkCarAvailabilityAndType(Vagon vagon, Person person) throws VagonIsFreeException, WrongVagonTypeException {
        // Проверяем тип вагона
        if (vagon.getVagonType() != person.getPreferredVagonType()) {
            throw new WrongVagonTypeException("Человек запросил другой тип вагона: " + person.getPreferredVagonType());
        }
        // Проверяем доступность вагона
        if (!vagon.getPersons().isEmpty()) { // Проверяем на занятость
            throw new VagonIsFreeException("Запрашиваемый тип вагона в данный момент недоступен.");
        }
    }
}
