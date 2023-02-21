package br.net.dac.client.Application.Services.Client.Events;


import br.net.dac.client.Application.Services.Client.Model.Address;

public class CreateClientEvent {
    private String name;
    private String email;
    private String cpf;
    private String phone;
    private double wage;
    private Address address;

    public CreateClientEvent(String name, String email, String cpf, String phone, double wage, Address address) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
        this.wage = wage;
        this.address = address;
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
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    
}

