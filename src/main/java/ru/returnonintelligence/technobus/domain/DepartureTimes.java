package ru.returnonintelligence.technobus.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

/**
 * @author NIKIT on 10.07.2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departure_times")
public class DepartureTimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 6, nullable = false)
    private Long id;

    @Column(name = "day_of_week", length = 7, nullable = false)
    private int dayOfWeek;
    @Column
    @ElementCollection(targetClass=LocalTime.class)
    private List<LocalTime> pointTime;
}
