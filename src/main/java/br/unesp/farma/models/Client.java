package br.unesp.farma.models;

public class Client extends PrivateIndividual {

    private String info;

    public Client(String name) {
        super.setName(name);
    }

    @Override
    public String toString() {
        return super.getName();
    }

}
