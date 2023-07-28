package com.crar.AwidCar.entity;

import com.crar.AwidCar.entity.enums.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "LastCheckIn")
    private Date lastCheckIn;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "PassWord")
    private String passWord;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "Gender")
    private Gender gender;

    @Column(name = "Age")
    private int age;

    @Column(name = "Adress")
    private String adress;

    @Column(name = "Tel")
    private String tel;

    @Enumerated(EnumType.STRING)
    @Column(name = "City")
    private City city;

    @Column(name = "Country")
    private String country;

    @Column(name = "CIN")
    private String cin;

    @Column(name = "Licence")
    private String licence;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DateLicence")
    private Date dateLicence;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DateCreation")
    private Date dateCreation;

    @Column(name = "Email")
    private String email;

    @Column(name = "VolNumber")
    private int volNumber;

    @OneToMany(mappedBy = "client")
    private List<Order> orders;

    @OneToMany(mappedBy = "client")
    private List<Notification> notifications;
}
