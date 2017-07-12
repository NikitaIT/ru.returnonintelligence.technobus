package ru.returnonintelligence.technobus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.returnonintelligence.technobus.domain.DepartureTimes;
import ru.returnonintelligence.technobus.services.DepartureTimesService;
import ru.returnonintelligence.technobus.util.CustomErrorType;

import javax.inject.Inject;
import java.util.List;

/**
 * @author NIKIT on 11.07.2017.
 */
@RestController
@RequestMapping("/api/")
public class DepartureTimesController extends BaseController {

    private final DepartureTimesService departureTimesService;

    @Inject
    public DepartureTimesController(final DepartureTimesService departureTimesService) {
        this.departureTimesService = departureTimesService;
    }

    @RequestMapping(value = "/departure_times", method = RequestMethod.GET)
    public ResponseEntity<List<DepartureTimes>> getDepartureTimes() {
        LOGGER.debug("Received request to get all DepartureTimes");
        List<DepartureTimes> departures = departureTimesService.getAll();
        if (departures.isEmpty()) {
            return new ResponseEntity(new CustomErrorType("Усё плохо"),HttpStatus.NO_CONTENT);
            // many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<DepartureTimes>>(departures, HttpStatus.OK);
    }
}