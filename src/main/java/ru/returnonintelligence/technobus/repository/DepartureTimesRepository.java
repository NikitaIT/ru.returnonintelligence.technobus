package ru.returnonintelligence.technobus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.returnonintelligence.technobus.domain.DepartureTimes;

/**
 * @author NIKIT on 11.07.2017.
 */
public interface DepartureTimesRepository extends JpaRepository<DepartureTimes, Long> {
    //if u want custom
    //@Query("select d from DepartureTimes d where d.id = :id")
    //DepartureTimes findById(@Param("id") long id);
}
