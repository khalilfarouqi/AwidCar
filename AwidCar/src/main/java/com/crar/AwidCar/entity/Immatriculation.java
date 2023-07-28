package com.crar.AwidCar.entity;

import com.crar.AwidCar.entity.enums.Series;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
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
