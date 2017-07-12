package ru.returnonintelligence.technobus.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.returnonintelligence.technobus.domain.DepartureTimes;
import ru.returnonintelligence.technobus.repository.DepartureTimesRepository;
import ru.returnonintelligence.technobus.services.DepartureTimesService;

import java.util.List;

/**
 * @author NIKIT on 11.07.2017.
 */
@Service
@Transactional
public class DepartureTimesServiceImpl implements DepartureTimesService {

    @Autowired
    private DepartureTimesRepository departureTimesRepository;

    @Override
    public List<DepartureTimes> getAll() {
        return departureTimesRepository.findAll();
    }

    @Override
    public void setAll(List<DepartureTimes> departureTimesList) {
        departureTimesRepository.save(departureTimesList);
    }
}
