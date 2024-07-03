package br.unesp.farma.models;

import jakarta.validation.constraints.NotNull;

public class Employee extends PrivateIndividual{
    @NotNull
    private Role role;

    public Employee(String name, Role role) {
        super.setName(name);
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return super.getName();
    }
}
