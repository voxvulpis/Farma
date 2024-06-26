package br.unesp.farma.models;

public class Employee extends PrivateIndividual{
    Role role;

    public Employee(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
