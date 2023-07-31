package com.crar.AwidCar.entity;

import com.crar.AwidCar.entity.enums.Prefecture;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="PrefectureRefs")
public class PrefectureRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Code")
    private int code;

    @Enumerated(EnumType.STRING)
    @Column(name = "Prefecture")
    private Prefecture prefecture;

    @OneToMany(mappedBy = "prefectureRef", fetch = FetchType.EAGER)
    private List<Immatriculation> immatriculations;

}
