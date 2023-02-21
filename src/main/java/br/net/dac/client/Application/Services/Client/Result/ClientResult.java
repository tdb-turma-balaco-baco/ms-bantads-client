package br.net.dac.client.Application.Services.Client.Result;

public class ClientResult {
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String phone;
    private double wage;
    private AddressResult clientAdress;
    
    public ClientResult(Long id, String name, String email, String cpf, String phone, double wage, AddressResult clientAdress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
        this.wage = wage;
        this.clientAdress = clientAdress;
    }
    public ClientResult() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    public Double getWage() {
        return wage;
    }
    public AddressResult getClientAdress() {
        return this.clientAdress;
    }
    public void setClientAdress(AddressResult clientAdress) {
        this.clientAdress = clientAdress;
    }
}
