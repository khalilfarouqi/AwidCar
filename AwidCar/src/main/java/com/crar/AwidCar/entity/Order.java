package com.crar.AwidCar.entity;

import com.crar.AwidCar.entity.enums.*;
import javax.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Etat")
    private Etat etat;

    @Column(name = "Country")
    private String country;

    @Enumerated(EnumType.STRING)
    @Column(name = "BookingCity")
    private City bookingCity;

    @Enumerated(EnumType.STRING)
    @Column(name = "ReturnCity")
    private City returnCity;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "Start_date")
    private Date startDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "End_date")
    private Date endDate;

    @Column(name = "TypeInsurance")
    private String typeInsurance;

    @Column(name = "OrderStatus")
    private String orderStatus;

    @Column(name = "Numbre_Days_Reserved")
    private int numbreDaysReserved;

    @Column(name = "Total")
    private double total;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client client;
}
