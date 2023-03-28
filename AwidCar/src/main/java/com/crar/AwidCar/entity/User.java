package com.crar.AwidCar.entity;

import javax.persistence.*;

import com.crar.AwidCar.entity.enums.Roles;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Users")
public class User {
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

    @Column(name = "Role")
    @Enumerated(EnumType.STRING)
    private Roles roles;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
