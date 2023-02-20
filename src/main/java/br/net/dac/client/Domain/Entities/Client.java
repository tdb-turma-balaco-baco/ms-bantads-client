package br.net.dac.client.Domain.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "client")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "phone")
    private String phone;

    @Column(name = "wage")
    private double wage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adressId")
    private Adress clientAdress;

    public Client(String name, String email, String cpf, String phone, double wage, Adress clientAdress) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
        this.wage = wage;
        this.clientAdress = clientAdress;
    }

    public Client() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Adress getClientAdress() {
        return this.clientAdress;
    }
    public void setClientAdress(Adress clientAdress) {
        this.clientAdress = clientAdress;
    }

}

