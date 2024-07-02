package br.unesp.farma.models;

public class Client extends PrivateIndividual{
    public Client(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
