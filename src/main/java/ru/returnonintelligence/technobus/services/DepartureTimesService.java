package ru.returnonintelligence.technobus.services;

import ru.returnonintelligence.technobus.domain.DepartureTimes;

import java.util.List;

/**
 * @author NIKIT on 11.07.2017.
 */
public interface DepartureTimesService {
    List<DepartureTimes> getAll();
    void setAll(List<DepartureTimes> departureTimesList);
}
