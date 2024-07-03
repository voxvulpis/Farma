package br.unesp.farma.models;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public abstract class PrivateIndividual extends Actor {
    @NotNull
    private String name;
    @NotNull
    private String cpf;
    @NotNull
    private Date birthDate;
    @NotNull
    private Gender gender;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
