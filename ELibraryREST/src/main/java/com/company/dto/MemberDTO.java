package com.company.dto;

import com.company.entity.UserEntity;

public class MemberDTO {
    private String name;
    private String surname;
    private String fin;
    private String username;
    private String address;
    private String password;

    public MemberDTO() {
    }
    public MemberDTO(UserEntity entity) {
        this.name= entity.getName();
        this.surname= entity.getSurname();
        this.address=entity.getAddress();
        this.fin=entity.getFin();
        this.username=entity.getUsername();
        this.address=entity.getAddress();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
