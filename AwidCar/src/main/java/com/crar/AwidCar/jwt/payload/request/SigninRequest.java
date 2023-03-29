package com.crar.AwidCar.jwt.payload.request;

import com.crar.AwidCar.entity.enums.Roles;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SigninRequest {
    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    private String username;
    @NotNull
    private Roles roles;
    private String login;
    @NotBlank
    private String password;
}
