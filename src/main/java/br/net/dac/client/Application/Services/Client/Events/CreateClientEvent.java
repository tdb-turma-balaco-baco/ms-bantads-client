package br.net.dac.client.Application.Services.Client.Events;


import br.net.dac.client.Application.Services.Client.Model.Adress;

public class CreateClientEvent {
    private String name;
    private String email;
    private String cpf;
    private String phone;
    private double wage;



    private Adress clientAdress;

    public CreateClientEvent(String name, String email, String cpf, String phone, double wage, Adress clientAdress) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
        this.wage = wage;
        this.clientAdress = clientAdress;
    }
    public CreateClientEvent () {

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

    public Adress getClientAdress() {
        return this.clientAdress;
    }
    public void setClientAdress(Adress clientAdress) {
        this.clientAdress = clientAdress;
    }
}

