package br.net.dac.client.Application.Services.Client.Result;

import br.net.dac.client.Application.Services.Client.Model.Adress;

public class AdressResult {
    private Long id;
    private String type;

    private String street;

    private String number;

    private String complement;

    private String cep;

    private String city;

    private String state;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String getComplement() {
        return complement;
    }
    public void setComplement(String complement) {
        this.complement = complement;
    }


    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public AdressResult(Long id, String type, String street, String number, String complement, String cep, String city, String state) {
        this.type = type;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.cep = cep;
        this.city = city;
        this.state = state;
        this.id = id;
    }
    public AdressResult() {

    }

}
