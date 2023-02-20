package br.net.dac.client.Application.Services.Client.Events;

import br.net.dac.client.Application.Services.Client.Model.Adress;

public class UpdateClientEvent {
    private Long clientId;
    private String name;
    private String email;
    private String cpf;
    private String phone;
    private double wage;

    private Adress clientAdress;
    public UpdateClientEvent(String name, String email, String cpf, String phone, double wage, Adress adress) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
        this.wage = wage;
        this.clientAdress = adress;
    }
    public UpdateClientEvent () {

    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    public Adress getClientAdress() {
        return this.clientAdress;
    }
    public void setClientAdress(Adress clientAdress) {
        this.clientAdress = clientAdress;
    }
}
