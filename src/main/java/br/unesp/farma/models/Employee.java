package br.unesp.farma.models;

public class Employee extends PrivateIndividual{
    Role role;

    public Employee(String name, Role role) {
        this.name = name;
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
        return name;
    }
}
