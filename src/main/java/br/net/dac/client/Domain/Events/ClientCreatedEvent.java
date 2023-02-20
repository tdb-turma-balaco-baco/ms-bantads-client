package br.net.dac.client.Domain.Events;

import br.net.dac.client.Domain.Events.Common.DomainEvent;

public class ClientCreatedEvent extends DomainEvent {
    private String name;
    private String cpf;

    private String email;
    private double wage;
    public ClientCreatedEvent(String name, String cpf, String email, double wage) {
        this.name = name;
        this.cpf = cpf;
        this.wage = wage;
        this.email = email;
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
    public double getWage() {
        return wage;
    }
    public void setWage(double wage) {
        this.wage = wage;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
