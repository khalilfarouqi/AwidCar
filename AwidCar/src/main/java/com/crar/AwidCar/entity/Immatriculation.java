package com.crar.AwidCar.entity;

import com.crar.AwidCar.entity.enums.Series;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Immatriculations")
public class Immatriculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Number")
    private int carNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "Series")
    private Series series;

    @ManyToOne
    @JoinColumn(name="prefecture_ref_id", nullable = false)
    private PrefectureRef prefectureRef;

}
